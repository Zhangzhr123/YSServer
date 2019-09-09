package com.bean;
/**
 * Created by zzr on 2019/05/27
 * 库存查询表
 */
import java.util.Date;

public class 库存查询表 {
    private String 条码编号;
    private String 物料代码;
    private String 物料名称;
    private String 类型代码;
    private String 类型名称;
    private String 托盘编号;
    private String 库位编号;
    private String 库位类型;
    private String 库位状态;
    private Integer 库位禁用;
    private String 物料规格;
    private String 计划编号;
    private String 生产批次;
    private double 物料重量;
    private Date 生产日期;
    private Date 入库时间;
    private Long startIndex;
    private Long endIndex;

    public String get条码编号() {
        return 条码编号;
    }

    public void set条码编号(String 条码编号) {
        this.条码编号 = 条码编号;
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

    public String get物料代码() {
        return 物料代码;
    }

    public void set物料代码(String 物料代码) {
        this.物料代码 = 物料代码;
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

    public String get托盘编号() {
        return 托盘编号;
    }

    public void set托盘编号(String 托盘编号) {
        this.托盘编号 = 托盘编号;
    }

    public String get库位编号() {
        return 库位编号;
    }

    public void set库位编号(String 库位编号) {
        this.库位编号 = 库位编号;
    }

    public String get库位状态() {
        return 库位状态;
    }

    public void set库位状态(String 库位状态) {
        this.库位状态 = 库位状态;
    }

    public Integer get库位禁用() {
        return 库位禁用;
    }

    public void set库位禁用(Integer 库位禁用) {
        this.库位禁用 = 库位禁用;
    }

    public String get库位类型() {
        return 库位类型;
    }

    public void set库位类型(String 库位类型) {
        this.库位类型 = 库位类型;
    }

    public String get物料规格() {
        return 物料规格;
    }

    public void set物料规格(String 物料规格) {
        this.物料规格 = 物料规格;
    }

    public String get计划编号() {
        return 计划编号;
    }

    public void set计划编号(String 计划编号) {
        this.计划编号 = 计划编号;
    }

    public String get生产批次() {
        return 生产批次;
    }

    public void set生产批次(String 生产批次) {
        this.生产批次 = 生产批次;
    }

    public Date get生产日期() {
        return 生产日期;
    }

    public void set生产日期(Date 生产日期) {
        this.生产日期 = 生产日期;
    }

    public Date get入库时间() {
        return 入库时间;
    }

    public void set入库时间(Date 入库时间) {
        this.入库时间 = 入库时间;
    }

    public double get物料重量() {
        return 物料重量;
    }

    public void set物料重量(double 物料重量) {
        this.物料重量 = 物料重量;
    }
}
