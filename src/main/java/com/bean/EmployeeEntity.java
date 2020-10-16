package com.bean;

import java.util.List;

public class EmployeeEntity {
    /// <summary>
    /// 员工唯一标识ID（不可修改），企业内必须唯一。长度为1~64个字符，如果不传，服务器将自动生成一个userid
    /// 是否必须(否)
    /// </summary>
    public String userid;
    /// <summary>
    /// 成员名称。长度为1~64个字符
    /// 是否必须(是)
    /// </summary>
    public String name;
    /// <summary>
    /// 在对应的部门中的排序, Map结构的json字符串, key是部门的Id, value是人员在这个部门的排序值
    /// 是否必须(否)
    /// </summary>
    public String orderInDepts;
    /// <summary>
    /// 数组类型，数组里面值为整型，成员所属部门id列表
    /// 是否必须(是)
    /// </summary>
    public List<Integer> department;
    /// <summary>
    /// 职位信息。长度为0~64个字符
    /// 是否必须(否)
    /// </summary>
    public String position;
    /// <summary>
    /// 手机号码。企业内必须唯一
    /// 是否必须(是)
    /// </summary>
    public String mobile;
    /// <summary>
    /// 分机号，长度为0~50个字符
    /// 是否必须(否)
    /// </summary>
    public String tel;
    /// <summary>
    /// 办公地点，长度为0~50个字符
    /// 是否必须(否)
    /// </summary>
    public String workPlace;
    /// <summary>
    /// 备注，长度为0~1000个字符
    /// 是否必须(否)
    /// </summary>
    public String remark;
    /// <summary>
    /// 邮箱。长度为0~64个字符。企业内必须唯一
    /// 是否必须(否)
    /// </summary>
    public String email;
    /// <summary>
    /// 员工工号。对应显示到OA后台和客户端个人资料的工号栏目。长度为0~64个字符
    /// 是否必须(否)
    /// </summary>
    public String jobnumber;
    /// <summary>
    /// 是否号码隐藏, true表示隐藏, false表示不隐藏。隐藏手机号后，手机号在个人资料页隐藏，但仍可对其发DING、发起钉钉免费商务电话。
    /// 是否必须(否)
    /// </summary>
    public Boolean isHide;
    /// <summary>
    /// 是否高管模式，true表示是，false表示不是。开启后，手机号码对所有员工隐藏。普通员工无法对其发DING、发起钉钉免费商务电话。高管之间不受影响。
    /// 是否必须(否)
    /// </summary>
    public Boolean isSenior;

    @Override
    public String toString() {
        return "EmployeeEntity{" +
                "userid='" + userid + '\'' +
                ", name='" + name + '\'' +
                ", orderInDepts='" + orderInDepts + '\'' +
                ", department=" + department +
                ", position='" + position + '\'' +
                ", mobile='" + mobile + '\'' +
                ", tel='" + tel + '\'' +
                ", workPlace='" + workPlace + '\'' +
                ", remark='" + remark + '\'' +
                ", email='" + email + '\'' +
                ", jobnumber='" + jobnumber + '\'' +
                ", isHide=" + isHide +
                ", isSenior=" + isSenior +
                '}';
    }

    public String getUserid() {
        return userid;
    }

    public void setUserid(String userid) {
        this.userid = userid;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getOrderInDepts() {
        return orderInDepts;
    }

    public void setOrderInDepts(String orderInDepts) {
        this.orderInDepts = orderInDepts;
    }

    public List<Integer> getDepartment() {
        return department;
    }

    public void setDepartment(List<Integer> department) {
        this.department = department;
    }

    public String getPosition() {
        return position;
    }

    public void setPosition(String position) {
        this.position = position;
    }

    public String getMobile() {
        return mobile;
    }

    public void setMobile(String mobile) {
        this.mobile = mobile;
    }

    public String getTel() {
        return tel;
    }

    public void setTel(String tel) {
        this.tel = tel;
    }

    public String getWorkPlace() {
        return workPlace;
    }

    public void setWorkPlace(String workPlace) {
        this.workPlace = workPlace;
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getJobnumber() {
        return jobnumber;
    }

    public void setJobnumber(String jobnumber) {
        this.jobnumber = jobnumber;
    }

    public Boolean getHide() {
        return isHide;
    }

    public void setHide(Boolean hide) {
        isHide = hide;
    }

    public Boolean getSenior() {
        return isSenior;
    }

    public void setSenior(Boolean senior) {
        isSenior = senior;
    }
}
