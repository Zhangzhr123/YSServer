package com.bean;

public class Depart {
    //部门ID
    private String ObjectID;
    //父级部门ID
    private String ParentID;
    //部门名称
    private String Name;
    //部门全称
    private String DesName;
    //部门Code
    private String Code;

    public String getCode() {
        return Code;
    }

    public void setCode(String code) {
        Code = code;
    }

    public String getObjectID() {
        return ObjectID;
    }

    public void setObjectID(String objectID) {
        ObjectID = objectID;
    }

    public String getParentID() {
        return ParentID;
    }

    public void setParentID(String parentID) {
        ParentID = parentID;
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
}
