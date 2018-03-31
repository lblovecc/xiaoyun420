package com.xiaoyun.main.service.app.impl;

import org.springframework.stereotype.Service;

import com.xiaoyun.main.model.Collect;
import com.xiaoyun.main.service.app.AppCollectService;
import com.xiaoyun.main.service.base.impl.BaseServiceImpl;

import tk.mybatis.mapper.common.Mapper;

@Service
public class AppCollectServiceImpl extends BaseServiceImpl<Collect> implements AppCollectService {

	@Override
	public Mapper<Collect> getMapper() {
		// TODO Auto-generated method stub
		return null;
	}

}
