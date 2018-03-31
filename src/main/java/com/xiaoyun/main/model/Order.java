package com.xiaoyun.main.model;

import java.util.Date;

public class Order {
    private Long id;

    private Integer meaid;

    private String orderstatus;

    private String paystatus;

    private Integer actualamount;

    private Integer payamount;

    private String paytype;

    private Long userid;

    private Long managerid;

    private Date createtime;

    private Date updatetime;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Integer getMeaid() {
        return meaid;
    }

    public void setMeaid(Integer meaid) {
        this.meaid = meaid;
    }

    public String getOrderstatus() {
        return orderstatus;
    }

    public void setOrderstatus(String orderstatus) {
        this.orderstatus = orderstatus == null ? null : orderstatus.trim();
    }

    public String getPaystatus() {
        return paystatus;
    }

    public void setPaystatus(String paystatus) {
        this.paystatus = paystatus == null ? null : paystatus.trim();
    }

    public Integer getActualamount() {
        return actualamount;
    }

    public void setActualamount(Integer actualamount) {
        this.actualamount = actualamount;
    }

    public Integer getPayamount() {
        return payamount;
    }

    public void setPayamount(Integer payamount) {
        this.payamount = payamount;
    }

    public String getPaytype() {
        return paytype;
    }

    public void setPaytype(String paytype) {
        this.paytype = paytype == null ? null : paytype.trim();
    }

    public Long getUserid() {
        return userid;
    }

    public void setUserid(Long userid) {
        this.userid = userid;
    }

    public Long getManagerid() {
        return managerid;
    }

    public void setManagerid(Long managerid) {
        this.managerid = managerid;
    }

    public Date getCreatetime() {
        return createtime;
    }

    public void setCreatetime(Date createtime) {
        this.createtime = createtime;
    }

    public Date getUpdatetime() {
        return updatetime;
    }

    public void setUpdatetime(Date updatetime) {
        this.updatetime = updatetime;
    }
}