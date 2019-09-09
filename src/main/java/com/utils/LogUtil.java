package com.utils;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

//记录器
public class LogUtil {

    public static Logger logger = LoggerFactory.getLogger("logutil");

    public static String writeLog( Exception e){
        String res = "";
        StackTraceElement[] ste = e.getStackTrace();
        logger.error(e.getMessage());
        if(ste != null && ste.length > 0){
            for(int i = 0; i < ste.length; i++){
                StackTraceElement s = ste[i];
                String se = "异常文件:" + s.getFileName() + ";异常类：" + s.getClassName() + "；异常方法:" + s.getMethodName() + "；异常位置:" + s.getLineNumber();
                res += se;
                logger.error(se);
            }
        }
        return res;
    }
    public static void writeLog(String name, String message){
        Logger log = LoggerFactory.getLogger(name);
        log.error(message);
    }
}
