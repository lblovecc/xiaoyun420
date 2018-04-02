package com.xiaoyun.main.service.manager;

import java.util.List;
import java.util.Map;

import com.xiaoyun.main.model.Browse;
import com.xiaoyun.main.service.base.BaseService;

public interface BrowseService extends BaseService<Browse> {

	public List<Browse> getBrowseList(Map<String,Object> qryMap);
	
	public int update(Browse browse);
	
	public int delete(long id);
	
	public int add(Browse browse);
}
