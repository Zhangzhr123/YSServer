package com.bean;
/**
 * Created by zzr on 2019/05/30
 * 盘点差异表
 */
public class 盘点差异表 {
    private String 计划编号;
    private String 物料编号;
    private String 物料名称;
    private String 类型代码;
    private String 类型名称;
    private String 物料规格;
    private String 生产批次;
    private double 库存数量;
    private double 盘点数量;
    private double 差异数量;
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

    public String get计划编号() {
        return 计划编号;
    }

    public void set计划编号(String 计划编号) {
        this.计划编号 = 计划编号;
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

    public String get生产批次() {
        return 生产批次;
    }

    public void set生产批次(String 生产批次) {
        this.生产批次 = 生产批次;
    }

    public double get库存数量() {
        return 库存数量;
    }

    public void set库存数量(double 库存数量) {
        this.库存数量 = 库存数量;
    }

    public double get盘点数量() {
        return 盘点数量;
    }

    public void set盘点数量(double 盘点数量) {
        this.盘点数量 = 盘点数量;
    }

    public double get差异数量() {
        return 差异数量;
    }

    public void set差异数量(double 差异数量) {
        this.差异数量 = 差异数量;
    }
}
