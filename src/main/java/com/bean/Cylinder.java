package com.bean;

import java.util.Date;

//钢瓶登记信息表
public class Cylinder {
    private String cylinderIDNum;//钢瓶ID
    private String cylinderNumber;//单位内编号
    private String cylinderCode;//产品编号
    private String cylinderQRCode;//二维码
    private String companyName;//制造单位
    private String cylinderSpec;//规格（KG）
    private String cylinderPressure;//公称工作压力
    private String cylinderVolume;//容积（升）
    private String cylinderMakeDate;//制造年月
    private String cylinderType;//设备品种
    private String cylinderMedia;//充装介质
    private String cylinderStatus;//状态
    private String cylinderScrapDate;//报废日期
    private String cylinderLastInspectDate;//上次检测日期
    private String cylinderNextInspectDate;//下次检测日期
    private String cylinderClinet;//客户托管
    private String property1;
    private String property2;
    private String remark;//备注
    private String useFlag;//使用标识
    private String deleteFlag;//删除标识
    private Date creationDate;
    private String createdBy;
    private Date lastUpdateDate;//登记日期
    private String lastUpdatedBy;//登记人

    public String getCylinderIDNum() {
        return cylinderIDNum;
    }

    public void setCylinderIDNum(String cylinderIDNum) {
        this.cylinderIDNum = cylinderIDNum;
    }

    public String getCylinderNumber() {
        return cylinderNumber;
    }

    public void setCylinderNumber(String cylinderNumber) {
        this.cylinderNumber = cylinderNumber;
    }

    public String getCylinderCode() {
        return cylinderCode;
    }

    public void setCylinderCode(String cylinderCode) {
        this.cylinderCode = cylinderCode;
    }

    public String getCylinderQRCode() {
        return cylinderQRCode;
    }

    public void setCylinderQRCode(String cylinderQRCode) {
        this.cylinderQRCode = cylinderQRCode;
    }

    public String getCompanyName() {
        return companyName;
    }

    public void setCompanyName(String companyName) {
        this.companyName = companyName;
    }

    public String getCylinderSpec() {
        return cylinderSpec;
    }

    public void setCylinderSpec(String cylinderSpec) {
        this.cylinderSpec = cylinderSpec;
    }

    public String getCylinderPressure() {
        return cylinderPressure;
    }

    public void setCylinderPressure(String cylinderPressure) {
        this.cylinderPressure = cylinderPressure;
    }

    public String getCylinderVolume() {
        return cylinderVolume;
    }

    public void setCylinderVolume(String cylinderVolume) {
        this.cylinderVolume = cylinderVolume;
    }

    public String getCylinderMakeDate() {
        return cylinderMakeDate;
    }

    public void setCylinderMakeDate(String cylinderMakeDate) {
        this.cylinderMakeDate = cylinderMakeDate;
    }

    public String getCylinderType() {
        return cylinderType;
    }

    public void setCylinderType(String cylinderType) {
        this.cylinderType = cylinderType;
    }

    public String getCylinderMedia() {
        return cylinderMedia;
    }

    public void setCylinderMedia(String cylinderMedia) {
        this.cylinderMedia = cylinderMedia;
    }

    public String getCylinderStatus() {
        return cylinderStatus;
    }

    public void setCylinderStatus(String cylinderStatus) {
        this.cylinderStatus = cylinderStatus;
    }

    public String getCylinderScrapDate() {
        return cylinderScrapDate;
    }

    public void setCylinderScrapDate(String cylinderScrapDate) {
        this.cylinderScrapDate = cylinderScrapDate;
    }

    public String getCylinderLastInspectDate() {
        return cylinderLastInspectDate;
    }

    public void setCylinderLastInspectDate(String cylinderLastInspectDate) {
        this.cylinderLastInspectDate = cylinderLastInspectDate;
    }

    public String getCylinderNextInspectDate() {
        return cylinderNextInspectDate;
    }

    public void setCylinderNextInspectDate(String cylinderNextInspectDate) {
        this.cylinderNextInspectDate = cylinderNextInspectDate;
    }

    public String getCylinderClinet() {
        return cylinderClinet;
    }

    public void setCylinderClinet(String cylinderClinet) {
        this.cylinderClinet = cylinderClinet;
    }

    public String getProperty1() {
        return property1;
    }

    public void setProperty1(String property1) {
        this.property1 = property1;
    }

    public String getProperty2() {
        return property2;
    }

    public void setProperty2(String property2) {
        this.property2 = property2;
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark;
    }

    public String getUseFlag() {
        return useFlag;
    }

    public void setUseFlag(String useFlag) {
        this.useFlag = useFlag;
    }

    public String getDeleteFlag() {
        return deleteFlag;
    }

    public void setDeleteFlag(String deleteFlag) {
        this.deleteFlag = deleteFlag;
    }

    public Date getCreationDate() {
        return creationDate;
    }

    public void setCreationDate(Date creationDate) {
        this.creationDate = creationDate;
    }

    public String getCreatedBy() {
        return createdBy;
    }

    public void setCreatedBy(String createdBy) {
        this.createdBy = createdBy;
    }

    public Date getLastUpdateDate() {
        return lastUpdateDate;
    }

    public void setLastUpdateDate(Date lastUpdateDate) {
        this.lastUpdateDate = lastUpdateDate;
    }

    public String getLastUpdatedBy() {
        return lastUpdatedBy;
    }

    public void setLastUpdatedBy(String lastUpdatedBy) {
        this.lastUpdatedBy = lastUpdatedBy;
    }
}
