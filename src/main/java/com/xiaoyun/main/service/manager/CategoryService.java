package com.xiaoyun.main.service.manager;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import com.xiaoyun.main.model.Category;
import com.xiaoyun.main.service.base.BaseService;

public interface CategoryService extends BaseService<Category> {
	
	public List<Category> getFirstLevel(Map<String,Object> qryMap);
	
	public List<Category> getSecondLevel(Map<String,Object> qryMap);

}
