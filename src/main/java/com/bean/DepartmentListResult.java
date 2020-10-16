package com.bean;

import java.util.Arrays;

public class DepartmentListResult {
    private String errcode;
    private String errmsg;
    private String[] sub_dept_id_list;

    @Override
    public String toString() {
        return "DepartmentListResult{" +
                "errcode='" + errcode + '\'' +
                ", errmsg='" + errmsg + '\'' +
                ", sub_dept_id_list=" + Arrays.toString(sub_dept_id_list) +
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

    public String[] getSub_dept_id_list() {
        return sub_dept_id_list;
    }

    public void setSub_dept_id_list(String[] sub_dept_id_list) {
        this.sub_dept_id_list = sub_dept_id_list;
    }
}
