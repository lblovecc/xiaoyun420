package com.xiaoyun.main.service.app;

import java.util.List;
import java.util.Map;

import com.xiaoyun.main.model.Banner;
import com.xiaoyun.main.service.base.BaseService;

public interface AppBannerService extends BaseService<Banner>{
	
	public List<Banner> getBannerList(Map<String,Object> qryMap);

}
