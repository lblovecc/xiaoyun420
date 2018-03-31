package com.xiaoyun.main.model.vo;

import java.util.Date;

public class SupplyAndBuyVO {
	
	private Long id;

    private Long categoryid1;

    private Long categoryid2;

    private String title;

    private String detile;

    private Integer price;

    private String pictureurls;

    private Long userid;

    private String tagids;

    private String status;

    private Integer clicks;

    private Date createTime;

    private Date updateTime;

    private Long managerid;
    
    private String type;			//类型   supply或者buy
    
    private String unit;

    private Integer count;

    private Date endTime;

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
		this.title = title;
	}

	public String getDetile() {
		return detile;
	}

	public void setDetile(String detile) {
		this.detile = detile;
	}

	public Integer getPrice() {
		return price;
	}

	public void setPrice(Integer price) {
		this.price = price;
	}

	public String getPictureurls() {
		return pictureurls;
	}

	public void setPictureurls(String pictureurls) {
		this.pictureurls = pictureurls;
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
		this.tagids = tagids;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public Integer getClicks() {
		return clicks;
	}

	public void setClicks(Integer clicks) {
		this.clicks = clicks;
	}

	public Date getCreateTime() {
		return createTime;
	}

	public void setCreateTime(Date createTime) {
		this.createTime = createTime;
	}

	public Date getUpdateTime() {
		return updateTime;
	}

	public void setUpdateTime(Date updateTime) {
		this.updateTime = updateTime;
	}

	public Long getManagerid() {
		return managerid;
	}

	public void setManagerid(Long managerid) {
		this.managerid = managerid;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public String getUnit() {
		return unit;
	}

	public void setUnit(String unit) {
		this.unit = unit;
	}

	public Integer getCount() {
		return count;
	}

	public void setCount(Integer count) {
		this.count = count;
	}

	public Date getEndTime() {
		return endTime;
	}

	public void setEndTime(Date endTime) {
		this.endTime = endTime;
	}

}
