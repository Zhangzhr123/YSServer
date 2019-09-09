package com.utils;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Created by SUNMC on 2017/8/31.
 */
public class DateUtil {

    public static String nowYMD(){
        return new SimpleDateFormat("yyyy-MM-dd").format(new Date());
    }
    public static String nowLong(){
        return new Date().getTime() + "";
    }

    public static String nowYMD(Date date){
        return new SimpleDateFormat("yyyy-MM-dd").format(date);
    }
    public static long toNowMinite(Date date){
        long res = 0;
        if(date != null){
            res = (new Date().getTime() - date.getTime())/60000;
        }
        return  res;
    }
    public static long toNowDay(Date date){
        long res = 0;
        if(date != null){
            res = (new Date().getTime() - date.getTime())/(60000*60*24);
        }
        return  res;
    }
}
