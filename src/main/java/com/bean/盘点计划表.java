package com.bean;
/**
 * Created by zzr on 2019/05/22
 * 盘点计划表
 */
import java.util.Date;

public class 盘点计划表 {

    private String 计划编号;
    private String 盘点名称;
    private String 盘点方式;
    private String 盘点项目;
    private String 盘点人编号;
    private String 盘点人名称;
    private Date 盘点开始时间;
    private Date 盘点结束时间;
    private String 完成程度;
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

    public String get盘点名称() {
        return 盘点名称;
    }

    public void set盘点名称(String 盘点名称) {
        this.盘点名称 = 盘点名称;
    }

    public String get盘点方式() {
        return 盘点方式;
    }

    public void set盘点方式(String 盘点方式) {
        this.盘点方式 = 盘点方式;
    }

    public String get盘点项目() {
        return 盘点项目;
    }

    public void set盘点项目(String 盘点项目) {
        this.盘点项目 = 盘点项目;
    }

    public String get盘点人编号() {
        return 盘点人编号;
    }

    public void set盘点人编号(String 盘点人编号) {
        this.盘点人编号 = 盘点人编号;
    }

    public String get盘点人名称() {
        return 盘点人名称;
    }

    public void set盘点人名称(String 盘点人名称) {
        this.盘点人名称 = 盘点人名称;
    }

    public Date get盘点开始时间() {
        return 盘点开始时间;
    }

    public void set盘点开始时间(Date 盘点开始时间) {
        this.盘点开始时间 = 盘点开始时间;
    }

    public Date get盘点结束时间() {
        return 盘点结束时间;
    }

    public void set盘点结束时间(Date 盘点结束时间) {
        this.盘点结束时间 = 盘点结束时间;
    }

    public String get完成程度() {
        return 完成程度;
    }

    public void set完成程度(String 完成程度) {
        this.完成程度 = 完成程度;
    }
}
