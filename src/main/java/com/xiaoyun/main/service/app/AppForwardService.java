package com.xiaoyun.main.service.app;

import com.xiaoyun.main.model.Forward;
import com.xiaoyun.main.service.base.BaseService;

public interface AppForwardService extends BaseService<Forward> {
	
	public int forwardSupplyOrBuy(Forward forward);

}
