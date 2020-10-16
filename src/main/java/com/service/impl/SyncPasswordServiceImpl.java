package com.service.impl;

import com.bean.SyncPassword;
import com.dao.SyncPasswordDao;
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
import java.util.List;

@Service
public class SyncPasswordServiceImpl implements ISyncPasswordService {


    @Autowired
    private SyncPasswordDao syncPasswordMapper;

    @Override
    public void syncPassword() {
        try {
            //获取BPM用户密码
            List<SyncPassword> bpmPassword = syncPasswordMapper.getBPMPassword();
            System.out.println("更新总数===" + bpmPassword.size());
            //将密码进行加密
            PasswordEncoder pe = PasswordEncoderFactories.createDelegatingPasswordEncoder();
            int i = 1;
            for (SyncPassword pwd : bpmPassword) {
                pwd.setPassword(pe.encode(pwd.getPassword()));
                //更新到云枢数据库
                InputStream is = Resources.getResourceAsStream("MysqlConfig.xml");
                SqlSessionFactory sessionFactory = new SqlSessionFactoryBuilder().build(is);
                SqlSession sqlsession = sessionFactory.openSession();
                sqlsession.update("com.dao.SyncPasswordDao.updatePwd", pwd);
                sqlsession.commit();
                sqlsession.close();
                i++;
                System.out.println("更新到===" + i);
                if (i == bpmPassword.size()) {
                    return;
                }
            }
            System.out.println("更新总数===" + bpmPassword.size());
            //更新到云枢数据库
//            InputStream is = Resources.getResourceAsStream("MysqlConfig.xml");
//            SqlSessionFactory sessionFactory = new SqlSessionFactoryBuilder().build(is);
//            SqlSession sqlsession = sessionFactory.openSession();
//            sqlsession.update("com.dao.SyncPasswordDao.updatePwd", bpmPassword);
//            sqlsession.commit();
//            sqlsession.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
