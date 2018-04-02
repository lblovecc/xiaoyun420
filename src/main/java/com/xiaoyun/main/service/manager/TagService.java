package com.xiaoyun.main.service.manager;

import java.util.List;
import java.util.Map;

import com.xiaoyun.main.model.Tag;
import com.xiaoyun.main.service.base.BaseService;

public interface TagService extends BaseService<Tag> {

	public List<Tag> getList(Map<String ,Object> qryMap);
	
	public int add(Tag tag);
	
	public int delete(long id);
	
	public int update(Tag tag);
}
