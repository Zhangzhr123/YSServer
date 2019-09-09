package com.bean;
/**
 * Created by zzr on 2019/05/27
 * 物流任务表
 */
import java.util.Date;

public class 物流任务表 {
    private String 任务编号;
    private String 单据编号;
    private String 叉车编号;
    private String 任务类型;
    private String 任务状态;
    private String 任务优先级;
    private String 单据明细编号;
    private String 物料编号;
    private String 物料名称;
    private String 类型代码;
    private String 类型名称;
    private String 物料规格;
    private String 起始站点;
    private String 目的站点;
    private String 批次;
    private double 数量;
    private String 备注;
    private String 开始时间;
    private String 结束时间;
    private Long startIndex;
    private Long endIndex;
    private String 叉车名称;

    public String get叉车编号() {
        return 叉车编号;
    }

    public void set叉车编号(String 叉车编号) {
        this.叉车编号 = 叉车编号;
    }

    public String get叉车名称() {
        return 叉车名称;
    }

    public void set叉车名称(String 叉车名称) {
        this.叉车名称 = 叉车名称;
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

    public String get备注() {
        return 备注;
    }

    public void set备注(String 备注) {
        this.备注 = 备注;
    }

    public String get任务类型() {
        return 任务类型;
    }

    public void set任务类型(String 任务类型) {
        this.任务类型 = 任务类型;
    }

    public String get任务状态() {
        return 任务状态;
    }

    public void set任务状态(String 任务状态) {
        this.任务状态 = 任务状态;
    }

    public String get任务优先级() {
        return 任务优先级;
    }

    public void set任务优先级(String 任务优先级) {
        this.任务优先级 = 任务优先级;
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

    public String get起始站点() {
        return 起始站点;
    }

    public void set起始站点(String 起始站点) {
        this.起始站点 = 起始站点;
    }

    public String get目的站点() {
        return 目的站点;
    }

    public void set目的站点(String 目的站点) {
        this.目的站点 = 目的站点;
    }

    public String get开始时间() {
        return 开始时间;
    }

    public void set开始时间(String 开始时间) {
        this.开始时间 = 开始时间;
    }

    public String get结束时间() {
        return 结束时间;
    }

    public void set结束时间(String 结束时间) {
        this.结束时间 = 结束时间;
    }

    public double get数量() {
        return 数量;
    }

    public void set数量(double 数量) {
        this.数量 = 数量;
    }

    public String get任务编号() {
        return 任务编号;
    }

    public void set任务编号(String 任务编号) {
        this.任务编号 = 任务编号;
    }

    public String get批次() {
        return 批次;
    }

    public void set批次(String 批次) {
        this.批次 = 批次;
    }
}
