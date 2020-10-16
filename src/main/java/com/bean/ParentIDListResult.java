package com.bean;

import java.util.Arrays;

public class ParentIDListResult {
    private String errcode;
    private String errmsg;
    private String[] parentIds;

    @Override
    public String toString() {
        return "ParentIDListResult{" +
                "errcode='" + errcode + '\'' +
                ", errmsg='" + errmsg + '\'' +
                ", parentIds=" + Arrays.toString(parentIds) +
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

    public String[] getParentIds() {
        return parentIds;
    }

    public void setParentIds(String[] parentIds) {
        this.parentIds = parentIds;
    }
}
