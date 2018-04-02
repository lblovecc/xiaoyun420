package com.xiaoyun.main.service.manager;

import java.util.List;

import com.xiaoyun.main.model.Collect;
import com.xiaoyun.main.service.base.BaseService;

public interface CollectService extends BaseService<Collect> {

	public List<Collect> getCollectList();
	
	
	
}
