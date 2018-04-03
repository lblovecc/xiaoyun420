package com.xiaoyun.main.service.app.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.xiaoyun.main.mapper.CollectMapper;
import com.xiaoyun.main.model.Collect;
import com.xiaoyun.main.service.app.AppCollectService;
import com.xiaoyun.main.service.base.impl.BaseServiceImpl;

import tk.mybatis.mapper.common.Mapper;

@Service
public class AppCollectServiceImpl extends BaseServiceImpl<Collect> implements AppCollectService {
	
	@Autowired
	private CollectMapper collectMapper;

	@Override
	public Mapper<Collect> getMapper() {
		// TODO Auto-generated method stub
		return null;
	}
	
	public int insert(Collect collect){
		return collectMapper.insert(collect);
	}
	
	@Override
	public Collect selectOne(Collect collect){
		return collectMapper.selectOne(collect);
	}

}
