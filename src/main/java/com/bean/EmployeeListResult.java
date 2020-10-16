package com.bean;

import java.util.List;

public class EmployeeListResult {
    private String errcode;
    private String errmsg;
    private List<EmployeeEntity> userlist;

    @Override
    public String toString() {
        return "EmployeeListResult{" +
                "errcode='" + errcode + '\'' +
                ", errmsg='" + errmsg + '\'' +
                ", userlist=" + userlist +
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

    public List<EmployeeEntity> getUserlist() {
        return userlist;
    }

    public void setUserlist(List<EmployeeEntity> userlist) {
        this.userlist = userlist;
    }
}
