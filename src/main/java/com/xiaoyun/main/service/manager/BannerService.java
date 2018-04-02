package com.xiaoyun.main.service.manager;

import java.util.List;
import java.util.Map;

import com.xiaoyun.main.model.Banner;
import com.xiaoyun.main.service.base.BaseService;


public interface BannerService extends BaseService<Banner>{

	public List<Banner> getBannerList(Map<String,Object> qryMap);
	
	public int update(Banner banner);
	
	public int delete(long id);
	
	public int add(Banner banner);
}
