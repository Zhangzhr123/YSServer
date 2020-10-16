package com.bean;

import java.util.List;

public class GetDepartList {

    private String errcode;
    private String errmsg;
    private List<DepartmentEntity> department;

    @Override
    public String toString() {
        return "GetDepartList{" +
                "errcode='" + errcode + '\'' +
                ", errmsg='" + errmsg + '\'' +
                ", department=" + department +
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

    public List<DepartmentEntity> getDepartment() {
        return department;
    }

    public void setDepartment(List<DepartmentEntity> department) {
        this.department = department;
    }
}
