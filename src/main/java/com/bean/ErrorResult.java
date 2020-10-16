package com.bean;

/**
 * Created by zzr on 2019/05/20
 * 结果类
 */
public class ErrorResult {

    private String errcode;
    private String errmsg;

    @Override
    public String toString() {
        return "ErrorResult{" +
                "errcode=" + errcode +
                ", errmsg='" + errmsg + '\'' +
                '}';
    }

    public String getErrcode() {
        return errcode;
    }

    public void setErrcode(String errcode) {
        this.errcode = errcode;
    }

    public String getErrmsg() {
        return errmsg;
    }

    public void setErrmsg(String errmsg) {
        this.errmsg = errmsg;
    }
}
