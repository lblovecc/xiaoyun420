package com.xiaoyun.main.service.app;

import com.xiaoyun.main.model.Collect;
import com.xiaoyun.main.service.base.BaseService;

public interface AppCollectService extends BaseService<Collect> {
	
	public int insert(Collect collect);
	
	public Collect selectOne(Collect collect);

}
