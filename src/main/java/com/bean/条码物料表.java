package com.bean;
/**
 * Created by zzr on 2019/07/08
 * 条码物料表
 */
public class 条码物料表 {
    private String 条码编号;
    private String 条码类型;
    private String 物料编码;
    private String 物料名称;
    private String 类型代码;
    private String 类型名称;
    private String 物料规格;
    private String 物料单位;
    private String 生产批次;
    private Double 数量;
    private Long startIndex;
    private Long endIndex;

    public String get条码编号() {
        return 条码编号;
    }

    public void set条码编号(String 条码编号) {
        this.条码编号 = 条码编号;
    }

    public String get条码类型() {
        return 条码类型;
    }

    public void set条码类型(String 条码类型) {
        this.条码类型 = 条码类型;
    }

    public String get物料编码() {
        return 物料编码;
    }

    public void set物料编码(String 物料编码) {
        this.物料编码 = 物料编码;
    }

    public String get物料名称() {
        return 物料名称;
    }

    public void set物料名称(String 物料名称) {
        this.物料名称 = 物料名称;
    }

    public String get类型代码() {
        return 类型代码;
    }

    public void set类型代码(String 类型代码) {
        this.类型代码 = 类型代码;
    }

    public String get类型名称() {
        return 类型名称;
    }

    public void set类型名称(String 类型名称) {
        this.类型名称 = 类型名称;
    }

    public String get物料规格() {
        return 物料规格;
    }

    public void set物料规格(String 物料规格) {
        this.物料规格 = 物料规格;
    }

    public String get物料单位() {
        return 物料单位;
    }

    public void set物料单位(String 物料单位) {
        this.物料单位 = 物料单位;
    }

    public String get生产批次() {
        return 生产批次;
    }

    public void set生产批次(String 生产批次) {
        this.生产批次 = 生产批次;
    }

    public Double get数量() {
        return 数量;
    }

    public void set数量(Double 数量) {
        this.数量 = 数量;
    }

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
}
