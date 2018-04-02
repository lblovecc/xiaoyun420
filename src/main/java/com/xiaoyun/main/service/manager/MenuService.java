package com.xiaoyun.main.service.manager;

import java.util.List;
import java.util.Map;


import com.xiaoyun.main.common.Paginator;
import com.xiaoyun.main.model.Menu;
import com.xiaoyun.main.service.base.BaseService;

public interface MenuService extends BaseService<Menu> {

	public List<Menu> getMenuList(Map<String,Object> qryMap, Paginator paginator);
	
	public int update(Menu menu);
	
	public int delete(long id);
	
	public int add(Menu menu);
}
