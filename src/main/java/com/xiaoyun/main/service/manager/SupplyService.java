package com.xiaoyun.main.service.manager;

import java.util.List;
import java.util.Map;

import com.xiaoyun.main.model.Supply;
import com.xiaoyun.main.service.base.BaseService;

public interface SupplyService extends BaseService<Supply> {

	public List<Supply> getList(Map<String,Object> qryMap);
	
	public int add(Supply supply);
	
	public int delete(long id);
	
	public int update(Supply supply);
}
