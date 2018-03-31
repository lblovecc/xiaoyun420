package com.xiaoyun.main.service.app;

import java.util.List;
import java.util.Map;

import com.xiaoyun.main.model.Tag;
import com.xiaoyun.main.service.base.BaseService;

public interface AppTagService extends BaseService<Tag> {
	
	List<Tag> getTagList(Map<String,Object> qryMap);

}
