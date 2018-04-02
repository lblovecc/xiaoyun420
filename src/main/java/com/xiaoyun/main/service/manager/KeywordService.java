package com.xiaoyun.main.service.manager;

import java.util.List;
import java.util.Map;

import com.xiaoyun.main.model.Keyword;
import com.xiaoyun.main.service.base.BaseService;

public interface KeywordService extends BaseService<Keyword>{

	public List<Keyword> getList(Map<String,Object> qryMap );
	
	public int add(Keyword keyword);
	
	public int delete(long id);
	
	public int update(Keyword keyword);
}
