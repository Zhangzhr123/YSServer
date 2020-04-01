package com.bean;

//充装统计表
public class Filling {
    private String fillingDate;//充装日期
    private String fillingTemperature;//充装温度（℃）
    private String cylinderIDNum;//钢瓶ID
    private String fillingInspectors;//检查人员
    private String fillingSignWeight;//钢瓶标记重量(kg)
    private String fillingActualWeight;//实际重量（kg）
    private String fillingSumWeight;//充装后总重量（kg）
    private String fillingFillWeight;//充装重量（kg）
    private String fillingFillman;//充装人员
    private String fillingAgainWeight;//复称重量（kg）

    public String getFillingDate() {
        return fillingDate;
    }

    public void setFillingDate(String fillingDate) {
        this.fillingDate = fillingDate;
    }

    public String getFillingTemperature() {
        return fillingTemperature;
    }

    public void setFillingTemperature(String fillingTemperature) {
        this.fillingTemperature = fillingTemperature;
    }

    public String getCylinderIDNum() {
        return cylinderIDNum;
    }

    public void setCylinderIDNum(String cylinderIDNum) {
        this.cylinderIDNum = cylinderIDNum;
    }

    public String getFillingInspectors() {
        return fillingInspectors;
    }

    public void setFillingInspectors(String fillingInspectors) {
        this.fillingInspectors = fillingInspectors;
    }

    public String getFillingSignWeight() {
        return fillingSignWeight;
    }

    public void setFillingSignWeight(String fillingSignWeight) {
        this.fillingSignWeight = fillingSignWeight;
    }

    public String getFillingActualWeight() {
        return fillingActualWeight;
    }

    public void setFillingActualWeight(String fillingActualWeight) {
        this.fillingActualWeight = fillingActualWeight;
    }

    public String getFillingSumWeight() {
        return fillingSumWeight;
    }

    public void setFillingSumWeight(String fillingSumWeight) {
        this.fillingSumWeight = fillingSumWeight;
    }

    public String getFillingFillWeight() {
        return fillingFillWeight;
    }

    public void setFillingFillWeight(String fillingFillWeight) {
        this.fillingFillWeight = fillingFillWeight;
    }

    public String getFillingFillman() {
        return fillingFillman;
    }

    public void setFillingFillman(String fillingFillman) {
        this.fillingFillman = fillingFillman;
    }

    public String getFillingAgainWeight() {
        return fillingAgainWeight;
    }

    public void setFillingAgainWeight(String fillingAgainWeight) {
        this.fillingAgainWeight = fillingAgainWeight;
    }
}
