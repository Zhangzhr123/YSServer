package com.bean;
/**
 * Created by zzr on 2019/06/03
 * 仓库单据表
 */
import java.util.Date;

public class 仓库单据表 {
    private String 单据编号;
    private String 单据类型;
    private Integer 单据标识;
    private String 单据状态;
    private Date 单据日期;
    private String 操作人编号;
    private String 操作人名称;
    private String 备注;
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

    public String get单据类型() {
        return 单据类型;
    }

    public void set单据类型(String 单据类型) {
        this.单据类型 = 单据类型;
    }

    public Integer get单据标识() {
        return 单据标识;
    }

    public void set单据标识(Integer 单据标识) {
        this.单据标识 = 单据标识;
    }

    public String get单据状态() {
        return 单据状态;
    }

    public void set单据状态(String 单据状态) {
        this.单据状态 = 单据状态;
    }

    public Date get单据日期() {
        return 单据日期;
    }

    public void set单据日期(Date 单据日期) {
        this.单据日期 = 单据日期;
    }

    public String get操作人编号() {
        return 操作人编号;
    }

    public void set操作人编号(String 操作人编号) {
        this.操作人编号 = 操作人编号;
    }

    public String get操作人名称() {
        return 操作人名称;
    }

    public void set操作人名称(String 操作人名称) {
        this.操作人名称 = 操作人名称;
    }

    public String get备注() {
        return 备注;
    }

    public void set备注(String 备注) {
        this.备注 = 备注;
    }
}
