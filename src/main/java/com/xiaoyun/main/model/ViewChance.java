package com.xiaoyun.main.model;

import java.util.Date;

public class ViewChance {
    private Long id;

    private Long userid;

    private Integer freecount;

    private Integer forwardcount;

    private Integer mealcount;

    private Date createtime;

    private Date updatetime;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getUserid() {
        return userid;
    }

    public void setUserid(Long userid) {
        this.userid = userid;
    }

    public Integer getFreecount() {
        return freecount;
    }

    public void setFreecount(Integer freecount) {
        this.freecount = freecount;
    }

    public Integer getForwardcount() {
        return forwardcount;
    }

    public void setForwardcount(Integer forwardcount) {
        this.forwardcount = forwardcount;
    }

    public Integer getMealcount() {
        return mealcount;
    }

    public void setMealcount(Integer mealcount) {
        this.mealcount = mealcount;
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