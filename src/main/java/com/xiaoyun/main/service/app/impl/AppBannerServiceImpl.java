package com.xiaoyun.main.service.app.impl;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.xiaoyun.main.mapper.BannerMapper;
import com.xiaoyun.main.model.Banner;
import com.xiaoyun.main.service.app.AppBannerService;
import com.xiaoyun.main.service.base.impl.BaseServiceImpl;

import tk.mybatis.mapper.common.Mapper;

@Service
public class AppBannerServiceImpl extends BaseServiceImpl<Banner> implements AppBannerService{
	
	@Autowired
	private BannerMapper bannerMapper;

	@Override
	public Mapper<Banner> getMapper() {
		// TODO Auto-generated method stub
		return null;
	}
	
	public List<Banner> getBannerList(Map<String,Object> qryMap){
		
		return bannerMapper.getBannerList(qryMap);
	}

}
