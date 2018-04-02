package com.xiaoyun.main.service.manager;

import java.util.List;
import java.util.Map;

import com.xiaoyun.main.common.Paginator;
import com.xiaoyun.main.model.Manager;
import com.xiaoyun.main.service.base.BaseService;

public interface ManagerService extends BaseService<Manager> {

	public List<Manager> getList(Map<String ,Object> qryMap ,Paginator paginator);
	
	public int delete(long id);
	
	public int add(Manager manager);
	
	public int update(Manager manager);
}
