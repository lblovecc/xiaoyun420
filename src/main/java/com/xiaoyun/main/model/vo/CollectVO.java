package com.xiaoyun.main.model.vo;

import java.util.Date;

public class CollectVO extends SupplyAndBuyVO{
	
	private Date collectTime;		//收藏时间

	public Date getCollectTime() {
		return collectTime;
	}

	public void setCollectTime(Date collectTime) {
		this.collectTime = collectTime;
	}

}
