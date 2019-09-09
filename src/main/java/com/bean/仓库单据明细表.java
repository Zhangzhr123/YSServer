package com.bean;
/**
 * Created by zzr on 2019/05/23
 * 仓库单据明细表
 */

public class 仓库单据明细表 {
    private String 单据编号;
    private String 单据明细编号;
    private String ERP单据编号;
    private String 订单编号;
    private String 物料编号;
    private String 物料名称;
    private String 类型代码;
    private String 类型名称;
    private String 物料规格;
    private String 物料单位;
    private double 数量;
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

    public String get单据编号() {
        return 单据编号;
    }

    public void set单据编号(String 单据编号) {
        this.单据编号 = 单据编号;
    }

    public String get单据明细编号() {
        return 单据明细编号;
    }

    public void set单据明细编号(String 单据明细编号) {
        this.单据明细编号 = 单据明细编号;
    }

    public String getERP单据编号() {
        return ERP单据编号;
    }

    public void setERP单据编号(String ERP单据编号) {
        this.ERP单据编号 = ERP单据编号;
    }

    public String get订单编号() {
        return 订单编号;
    }

    public void set订单编号(String 订单编号) {
        this.订单编号 = 订单编号;
    }

    public String get物料编号() {
        return 物料编号;
    }

    public void set物料编号(String 物料编号) {
        this.物料编号 = 物料编号;
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

    public double get数量() {
        return 数量;
    }

    public void set数量(double 数量) {
        this.数量 = 数量;
    }
}
