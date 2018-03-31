package com.xiaoyun.main.service.app.impl;

import org.springframework.stereotype.Service;

import com.xiaoyun.main.model.ViewChance;
import com.xiaoyun.main.service.app.AppViewChanceService;
import com.xiaoyun.main.service.base.impl.BaseServiceImpl;

import tk.mybatis.mapper.common.Mapper;

@Service
public class AppViewChanceServiceImpl extends BaseServiceImpl<ViewChance> implements AppViewChanceService {

	@Override
	public Mapper<ViewChance> getMapper() {
		// TODO Auto-generated method stub
		return null;
	}

}
