package com.xiaoyun.main.service.manager.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.xiaoyun.main.mapper.CollectMapper;
import com.xiaoyun.main.model.Collect;
import com.xiaoyun.main.service.base.impl.BaseServiceImpl;
import com.xiaoyun.main.service.manager.CollectService;

import tk.mybatis.mapper.common.Mapper;

@Service
public class CollectServiceImpl extends BaseServiceImpl<Collect> implements CollectService {

	@Autowired
	private CollectMapper collectMapper;
	
	@Override
	public List<Collect> getCollectList() {

		return collectMapper.getCollectList();
	}

	@Override
	public Mapper<Collect> getMapper() {
		// TODO Auto-generated method stub
		return null;
	}

	


}
