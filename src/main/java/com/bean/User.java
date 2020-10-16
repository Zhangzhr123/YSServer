package com.bean;

import java.util.Date;

public class User {
    //员工姓名
    private String Name;
    //部门全称
    private String DesName;
    //工号和员工ID
    private String EmployeeNumber;
    //邮箱
    private String Email;
    //手机号
    private String Mobile;
    //部门ID
    private String ParentID;
    //部门Code
    private String Code;

    public String getCode() {
        return Code;
    }

    public void setCode(String code) {
        Code = code;
    }

    public String getName() {
        return Name;
    }

    public void setName(String name) {
        Name = name;
    }

    public String getDesName() {
        return DesName;
    }

    public void setDesName(String desName) {
        DesName = desName;
    }

    public String getEmployeeNumber() {
        return EmployeeNumber;
    }

    public void setEmployeeNumber(String employeeNumber) {
        EmployeeNumber = employeeNumber;
    }

    public String getEmail() {
        return Email;
    }

    public void setEmail(String email) {
        Email = email;
    }

    public String getMobile() {
        return Mobile;
    }

    public void setMobile(String mobile) {
        Mobile = mobile;
    }

    public String getParentID() {
        return ParentID;
    }

    public void setParentID(String parentID) {
        ParentID = parentID;
    }
}
