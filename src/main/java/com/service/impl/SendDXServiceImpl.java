package com.service.impl;

import com.alibaba.fastjson.JSONObject;
import com.bean.EmployeeResult;
import com.bean.GZD;
import com.bean.SendDX;
import com.bean.SyncPassword;
import com.dao.SendDXDao;
import com.dao.SyncPasswordDao;
import com.dao.insertDXDao;
import com.dingtalk.api.DefaultDingTalkClient;
import com.dingtalk.api.DingTalkClient;
import com.dingtalk.api.request.OapiGettokenRequest;
import com.dingtalk.api.request.OapiMessageCorpconversationAsyncsendV2Request;
import com.dingtalk.api.request.OapiUserGetByMobileRequest;
import com.dingtalk.api.response.OapiGettokenResponse;
import com.dingtalk.api.response.OapiMessageCorpconversationAsyncsendV2Response;
import com.dingtalk.api.response.OapiUserGetByMobileResponse;
import com.service.ISendDXService;
import com.service.ISyncPasswordService;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.factory.PasswordEncoderFactories;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Service
public class SendDXServiceImpl implements ISendDXService {

    @Autowired
    private SendDXDao sendDXDao;
    @Autowired
    private insertDXDao insertDXDao;

    @Override
    public void sendDX() {
        try {
            SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");

            //获取短信
            List<SendDX> sendDXES = sendDXDao.getSendDX();

            //获取token
            DingTalkClient client0 = new DefaultDingTalkClient("https://oapi.dingtalk.com/gettoken");
            OapiGettokenRequest req0 = new OapiGettokenRequest();
            req0.setAppkey("dingxigqmxvneops7uce");//dingxigqmxvneops7uce
            //8oFKGdkjk850jKtp1UmNwObfot-9F74_LNQ5e2Onkem88RiVRdA7iv4l_OXqQ_5U
            req0.setAppsecret("8oFKGdkjk850jKtp1UmNwObfot-9F74_LNQ5e2Onkem88RiVRdA7iv4l_OXqQ_5U");
            req0.setHttpMethod("GET");
            OapiGettokenResponse rsp0 = client0.execute(req0);
            System.out.println(rsp0.getBody());
            String accessToken = rsp0.getAccessToken();

            //根据手机号发送钉钉通知
            if (sendDXES != null && sendDXES.size() > 0) {
                for (int i = 0; i < sendDXES.size(); i++) {
                    String str1 = (sendDXES.get(i).getSMSText()).substring(0, (sendDXES.get(i).getSMSText()).indexOf(" "));
                    String str2 = (sendDXES.get(i).getSMSText()).substring(str1.length() + 1, (sendDXES.get(i).getSMSText()).length());
                    System.out.println(str2);

                    GZD select = new GZD();
                    select.setSjh(sendDXES.get(i).getMbl());

                    InputStream is = Resources.getResourceAsStream("MysqlConfig.xml");
                    SqlSessionFactory sessionFactory = new SqlSessionFactoryBuilder().build(is);
                    SqlSession sqlsession = sessionFactory.openSession(true);
                    List<GZD> date = sqlsession.selectList("com.dao.insertDXDao.getByMbl", select);
                    sqlsession.commit();
                    sqlsession.close();

                    if (date == null || date.size() == 0) {
                        //根据手机号获取人员id
                        DingTalkClient client = new DefaultDingTalkClient("https://oapi.dingtalk.com/user/get_by_mobile");
                        OapiUserGetByMobileRequest request = new OapiUserGetByMobileRequest();
                        request.setMobile(sendDXES.get(i).getMbl());
                        OapiUserGetByMobileResponse execute = client.execute(request, accessToken);
                        JSONObject deJson = (JSONObject) JSONObject.toJSON(execute);
                        EmployeeResult employeeResult = JSONObject.toJavaObject(deJson, EmployeeResult.class);
                        System.out.println(employeeResult);

                        if (employeeResult.getErrcode().equals("0")) {
                            //发送信息
                            DingTalkClient dtclient = new DefaultDingTalkClient("https://oapi.dingtalk.com/topapi/message/corpconversation/asyncsend_v2");
                            OapiMessageCorpconversationAsyncsendV2Request req = new OapiMessageCorpconversationAsyncsendV2Request();
                            req.setAgentId((long) 763436042);//763436042
                            //正式
                            req.setUseridList(employeeResult.getUserid());
                            OapiMessageCorpconversationAsyncsendV2Request.Msg obj1 = new OapiMessageCorpconversationAsyncsendV2Request.Msg();
                            obj1.setMsgtype("text");
                            OapiMessageCorpconversationAsyncsendV2Request.Text obj2 = new OapiMessageCorpconversationAsyncsendV2Request.Text();
                            obj2.setContent(str2);
                            obj1.setText(obj2);
                            req.setMsg(obj1);
                            OapiMessageCorpconversationAsyncsendV2Response rsp = dtclient.execute(req, accessToken);
                            System.out.println(rsp.getBody());

                            //将数据放入集合中
                            GZD gzd = new GZD();
                            gzd.setId(String.valueOf(new Date().getTime()));
                            gzd.setBt(str1);
                            gzd.setFsnr(str2);
                            gzd.setSjh(sendDXES.get(i).getMbl());
                            gzd.setFssj(sdf.format(new Date()));
                            gzd.setSffs("1");

                            //添加到云枢数据库
                            InputStream is1 = Resources.getResourceAsStream("MysqlConfig.xml");
                            SqlSessionFactory sessionFactory1 = new SqlSessionFactoryBuilder().build(is1);
                            SqlSession sqlsession1 = sessionFactory1.openSession(true);
                            sqlsession1.insert("com.dao.insertDXDao.insertDX", gzd);
                            sqlsession1.commit();
                            sqlsession1.close();
                        }
                    }


                }


            }

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
