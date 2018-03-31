package com.xiaoyun.main.model;

import java.util.Date;

public class BuyTagTemp {
    private Long id;

    private Long buyid;

    private Long tagid;

    private Date createtime;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getBuyid() {
        return buyid;
    }

    public void setBuyid(Long buyid) {
        this.buyid = buyid;
    }

    public Long getTagid() {
        return tagid;
    }

    public void setTagid(Long tagid) {
        this.tagid = tagid;
    }

    public Date getCreatetime() {
        return createtime;
    }

    public void setCreatetime(Date createtime) {
        this.createtime = createtime;
    }
}