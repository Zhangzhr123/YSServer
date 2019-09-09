package com.utils;



import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;

import java.io.IOException;


public class ApacheHttpUtil {

    static CloseableHttpClient httpclient = HttpClients.createDefault();
    /**
     * 向指定URL发送GET方法的请求
     *
     * @param url   发送请求的URL
     * @param param 请求参数，请求参数应该是 name1=value1&name2=value2 的形式。
     * @return URL 所代表远程资源的响应结果
     */
    public static String sendGet(String url, String param) {
        String result = "";
        HttpGet httpGet = new HttpGet(url + "?" + param);
        CloseableHttpResponse response1 = null;
        try {
            response1 = httpclient.execute(httpGet);
            if(response1.getStatusLine().getStatusCode() == 200) {
                // 获取相应字符串
                result = EntityUtils.toString(response1.getEntity());
            }
        }catch(Exception e){
            e.printStackTrace();
        }
        finally {
            try{
                if(response1 != null){
                    response1.close();
                }
            }catch (IOException ioe){
                ioe.printStackTrace();
            }
        }
        return result;
    }

    /**
     * 发送post请求
     *
     * @return 响应的数据
     */
    public static String sendPost(String url, String params) {
        String result = "";
        HttpPost httpPost = new HttpPost(url);
        CloseableHttpResponse response2 = null;
        try {
            StringEntity s = new StringEntity(params, "UTF-8");
            s.setContentEncoding("UTF-8");
            s.setContentType("application/json");
            httpPost.setEntity(s);
            response2 = httpclient.execute(httpPost);
            if(response2.getStatusLine().getStatusCode() == 200) {
                // 获取相应字符串
                result = EntityUtils.toString(response2.getEntity());
            }
        }catch (Exception e){

        }finally {
            try{
                response2.close();
            }catch(IOException ioe){

            }
        }
        return result;
    }



}