package com.xiaoyun.main.service.app.impl;

import java.util.List;

import org.springframework.stereotype.Service;

import com.xiaoyun.main.model.Meal;
import com.xiaoyun.main.service.app.AppMealService;
import com.xiaoyun.main.service.base.impl.BaseServiceImpl;

import tk.mybatis.mapper.common.Mapper;

@Service
public class AppMealServiceImpl extends BaseServiceImpl<Meal> implements AppMealService {

	@Override
	public Mapper<Meal> getMapper() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Meal> getMealList() {
		// TODO Auto-generated method stub
		return getMapper().selectAll();
	}

}
