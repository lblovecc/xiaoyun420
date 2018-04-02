package com.xiaoyun.main.service.manager.impl;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.github.pagehelper.PageHelper;
import com.xiaoyun.main.common.Paginator;
import com.xiaoyun.main.mapper.BannerMapper;
import com.xiaoyun.main.model.Banner;
import com.xiaoyun.main.service.base.impl.BaseServiceImpl;
import com.xiaoyun.main.service.manager.BannerService;

import tk.mybatis.mapper.common.Mapper;
@Service
public class BannerServiceImppl extends BaseServiceImpl<Banner> implements BannerService{

	@Autowired
	private BannerMapper bannerMapper;
	@Override
	public List<Banner> getBannerList(Map<String, Object> qryMap,Paginator paginator) {
		PageHelper.startPage(paginator.getPageNumber(), paginator.getPageSize());
		return bannerMapper.getBannerList(qryMap);
	}

	@Override
	public Mapper<Banner> getMapper() {
		// TODO Auto-generated method stub
		return null; 
	}

	@Override
	public int update(Banner banner) {
		return bannerMapper.updateByPrimaryKeySelective(banner);
	}

	@Override
	public int delete(long id) {
		return bannerMapper.deleteByPrimaryKey(id);
	}

	@Override
	public int add(Banner banner) {
		
		return bannerMapper.insertSelective(banner);
	}

}
