package com.bean;

public class DepartmentEntity {
    private String errcode;
    private String errmsg;
    private String id;
    private String name;
    private Integer order;
    private Long parentid;
    private Boolean createDeptGroup;
    private Boolean autoAddUser;
    private Boolean deptHiding;
    private String deptPermits;
    private String userPermits;
    private Boolean outerDept;
    private String outerPermitDepts;
    private String outerPermitUsers;
    private String orgDeptOwner;
    private String deptManagerUseridList;
    private String sourceIdentifier;
    private String ext;

    @Override
    public String toString() {
        return "DepartmentEntity{" +
                "errcode='" + errcode + '\'' +
                ", errmsg='" + errmsg + '\'' +
                ", id='" + id + '\'' +
                ", name='" + name + '\'' +
                ", order=" + order +
                ", parentid=" + parentid +
                ", createDeptGroup=" + createDeptGroup +
                ", autoAddUser=" + autoAddUser +
                ", deptHiding=" + deptHiding +
                ", deptPermits='" + deptPermits + '\'' +
                ", userPermits='" + userPermits + '\'' +
                ", outerDept=" + outerDept +
                ", outerPermitDepts='" + outerPermitDepts + '\'' +
                ", outerPermitUsers='" + outerPermitUsers + '\'' +
                ", orgDeptOwner='" + orgDeptOwner + '\'' +
                ", deptManagerUseridList='" + deptManagerUseridList + '\'' +
                ", sourceIdentifier='" + sourceIdentifier + '\'' +
                ", ext='" + ext + '\'' +
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

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getOrder() {
        return order;
    }

    public void setOrder(Integer order) {
        this.order = order;
    }

    public Long getParentid() {
        return parentid;
    }

    public void setParentid(Long parentid) {
        this.parentid = parentid;
    }

    public Boolean getCreateDeptGroup() {
        return createDeptGroup;
    }

    public void setCreateDeptGroup(Boolean createDeptGroup) {
        this.createDeptGroup = createDeptGroup;
    }

    public Boolean getAutoAddUser() {
        return autoAddUser;
    }

    public void setAutoAddUser(Boolean autoAddUser) {
        this.autoAddUser = autoAddUser;
    }

    public Boolean getDeptHiding() {
        return deptHiding;
    }

    public void setDeptHiding(Boolean deptHiding) {
        this.deptHiding = deptHiding;
    }

    public String getDeptPermits() {
        return deptPermits;
    }

    public void setDeptPermits(String deptPermits) {
        this.deptPermits = deptPermits;
    }

    public String getUserPermits() {
        return userPermits;
    }

    public void setUserPermits(String userPermits) {
        this.userPermits = userPermits;
    }

    public Boolean getOuterDept() {
        return outerDept;
    }

    public void setOuterDept(Boolean outerDept) {
        this.outerDept = outerDept;
    }

    public String getOuterPermitDepts() {
        return outerPermitDepts;
    }

    public void setOuterPermitDepts(String outerPermitDepts) {
        this.outerPermitDepts = outerPermitDepts;
    }

    public String getOuterPermitUsers() {
        return outerPermitUsers;
    }

    public void setOuterPermitUsers(String outerPermitUsers) {
        this.outerPermitUsers = outerPermitUsers;
    }

    public String getOrgDeptOwner() {
        return orgDeptOwner;
    }

    public void setOrgDeptOwner(String orgDeptOwner) {
        this.orgDeptOwner = orgDeptOwner;
    }

    public String getDeptManagerUseridList() {
        return deptManagerUseridList;
    }

    public void setDeptManagerUseridList(String deptManagerUseridList) {
        this.deptManagerUseridList = deptManagerUseridList;
    }

    public String getSourceIdentifier() {
        return sourceIdentifier;
    }

    public void setSourceIdentifier(String sourceIdentifier) {
        this.sourceIdentifier = sourceIdentifier;
    }

    public String getExt() {
        return ext;
    }

    public void setExt(String ext) {
        this.ext = ext;
    }
}
