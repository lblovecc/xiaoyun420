package com.xiaoyun.main.model;

import java.util.Date;

public class Collect {
    private Long id;

    private String collecttype;

    private Long supplyid;

    private Long buyid;

    private Long userid;

    private Date createtime;

    private Date updatetime;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getCollecttype() {
        return collecttype;
    }

    public void setCollecttype(String collecttype) {
        this.collecttype = collecttype == null ? null : collecttype.trim();
    }

    public Long getSupplyid() {
        return supplyid;
    }

    public void setSupplyid(Long supplyid) {
        this.supplyid = supplyid;
    }

    public Long getBuyid() {
        return buyid;
    }

    public void setBuyid(Long buyid) {
        this.buyid = buyid;
    }

    public Long getUserid() {
        return userid;
    }

    public void setUserid(Long userid) {
        this.userid = userid;
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