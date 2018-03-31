package com.xiaoyun.main.model;

import java.util.Date;

public class Forward {
    private Long id;

    private String type;

    private Date createtime;

    private Date updatetime;

    private Long userid;

    private Long supplyid;

    private Long buyid;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type == null ? null : type.trim();
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

    public Long getUserid() {
        return userid;
    }

    public void setUserid(Long userid) {
        this.userid = userid;
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
}