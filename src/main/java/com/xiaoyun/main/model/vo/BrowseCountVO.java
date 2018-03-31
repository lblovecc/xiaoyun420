package com.xiaoyun.main.model.vo;

/**
 * 浏览次数实体
 * 
 * @author Mr.LB
 *
 */
public class BrowseCountVO {
	
	private Long supplyId;				//供应帖子id
	
	private Long buyId;					//求购帖子id
	
	public Long getBuyId() {
		return buyId;
	}

	public void setBuyId(Long buyId) {
		this.buyId = buyId;
	}

	public Long getSupplyId() {
		return supplyId;
	}

	public void setSupplyId(Long supplyId) {
		this.supplyId = supplyId;
	}

	public Integer getBrowseCount() {
		return browseCount;
	}

	public void setBrowseCount(Integer browseCount) {
		this.browseCount = browseCount;
	}

	private Integer browseCount;		//浏览次数

}
