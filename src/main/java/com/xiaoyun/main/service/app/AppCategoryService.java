package com.xiaoyun.main.service.app;

import java.util.List;
import java.util.Map;

import com.xiaoyun.main.model.Category;
import com.xiaoyun.main.service.base.BaseService;

public interface AppCategoryService extends BaseService<Category>{
	
	public List<Category> getCategoryList(Map<String,Object> qryMap);

}
