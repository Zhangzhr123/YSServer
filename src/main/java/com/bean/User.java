package com.bean;
/**
 * Created by zzr on 2019/05/20
 * 用户类
 */

public class User {
    private String 用户编号;
    private String 用户名称;
    private String 用户密码;
    private String 部门编号;
    private String 部门名称;
    private String 用户手机;
    private String 用户邮箱;
    private String 备注;
    private Long startIndex;
    private Long endIndex;

    public Long getStartIndex() {
        return startIndex;
    }

    public void setStartIndex(Long startIndex) {
        this.startIndex = startIndex;
    }

    public Long getEndIndex() {
        return endIndex;
    }

    public void setEndIndex(Long endIndex) {
        this.endIndex = endIndex;
    }

    public String get用户编号() {
        return 用户编号;
    }

    public void set用户编号(String 用户编号) {
        this.用户编号 = 用户编号;
    }

    public String get用户名称() {
        return 用户名称;
    }

    public void set用户名称(String 用户名称) {
        this.用户名称 = 用户名称;
    }

    public String get用户密码() {
        return 用户密码;
    }

    public void set用户密码(String 用户密码) {
        this.用户密码 = 用户密码;
    }

    public String get部门编号() {
        return 部门编号;
    }

    public void set部门编号(String 部门编号) {
        this.部门编号 = 部门编号;
    }

    public String get部门名称() {
        return 部门名称;
    }

    public void set部门名称(String 部门名称) {
        this.部门名称 = 部门名称;
    }

    public String get用户手机() {
        return 用户手机;
    }

    public void set用户手机(String 用户手机) {
        this.用户手机 = 用户手机;
    }

    public String get用户邮箱() {
        return 用户邮箱;
    }

    public void set用户邮箱(String 用户邮箱) {
        this.用户邮箱 = 用户邮箱;
    }

    public String get备注() {
        return 备注;
    }

    public void set备注(String 备注) {
        this.备注 = 备注;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof User)) return false;

        User user = (User) o;

        if (用户编号 != null ? !用户编号.equals(user.用户编号) : user.用户编号 != null) return false;
        if (用户名称 != null ? !用户名称.equals(user.用户名称) : user.用户名称 != null) return false;
        if (用户密码 != null ? !用户密码.equals(user.用户密码) : user.用户密码 != null) return false;
        if (部门编号 != null ? !部门编号.equals(user.部门编号) : user.部门编号 != null) return false;
        if (部门名称 != null ? !部门名称.equals(user.部门名称) : user.部门名称 != null) return false;
        if (用户手机 != null ? !用户手机.equals(user.用户手机) : user.用户手机 != null) return false;
        if (用户邮箱 != null ? !用户邮箱.equals(user.用户邮箱) : user.用户邮箱 != null) return false;
        return 备注 != null ? 备注.equals(user.备注) : user.备注 == null;
    }

}

