package com.xiaoyun.main.model;

import java.util.Date;

public class Buy {
    private Long id;

    private Long categoryid1;

    private Long categoryid2;

    private String title;

    private String detile;

    private String unit;

    private Integer count;

    private Date endtime;

    private Long userid;

    private String tagids;

    private String status;

    private Integer clicks;

    private Date createtime;

    private Date updatetime;

    private Long managerid;
    
    private String type;			//类型   默认为buy

    public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getCategoryid1() {
        return categoryid1;
    }

    public void setCategoryid1(Long categoryid1) {
        this.categoryid1 = categoryid1;
    }

    public Long getCategoryid2() {
        return categoryid2;
    }

    public void setCategoryid2(Long categoryid2) {
        this.categoryid2 = categoryid2;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title == null ? null : title.trim();
    }

    public String getDetile() {
        return detile;
    }

    public void setDetile(String detile) {
        this.detile = detile == null ? null : detile.trim();
    }

    public String getUnit() {
        return unit;
    }

    public void setUnit(String unit) {
        this.unit = unit == null ? null : unit.trim();
    }

    public Integer getCount() {
        return count;
    }

    public void setCount(Integer count) {
        this.count = count;
    }

    public Date getEndtime() {
        return endtime;
    }

    public void setEndtime(Date endtime) {
        this.endtime = endtime;
    }

    public Long getUserid() {
        return userid;
    }

    public void setUserid(Long userid) {
        this.userid = userid;
    }

    public String getTagids() {
        return tagids;
    }

    public void setTagids(String tagids) {
        this.tagids = tagids == null ? null : tagids.trim();
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status == null ? null : status.trim();
    }

    public Integer getClicks() {
        return clicks;
    }

    public void setClicks(Integer clicks) {
        this.clicks = clicks;
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

    public Long getManagerid() {
        return managerid;
    }

    public void setManagerid(Long managerid) {
        this.managerid = managerid;
    }
}