package com.xiaoyun.main.service.app.impl;

import org.springframework.stereotype.Service;

import com.xiaoyun.main.model.AuthCode;
import com.xiaoyun.main.service.app.AppAuthCodeService;
import com.xiaoyun.main.service.base.impl.BaseServiceImpl;

import tk.mybatis.mapper.common.Mapper;

@Service
public class AppAuthCodeServiceImpl extends BaseServiceImpl<AuthCode> implements AppAuthCodeService {

	@Override
	public Mapper<AuthCode> getMapper() {
		// TODO Auto-generated method stub
		return null;
	}

}
