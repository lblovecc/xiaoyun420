package com.xiaoyun.main.service.app.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.xiaoyun.main.mapper.MealMapper;
import com.xiaoyun.main.model.Meal;
import com.xiaoyun.main.service.app.AppMealService;
import com.xiaoyun.main.service.base.impl.BaseServiceImpl;

import tk.mybatis.mapper.common.Mapper;

@Service
public class AppMealServiceImpl extends BaseServiceImpl<Meal> implements AppMealService {
	
	@Autowired
	private MealMapper mealMapper;

	@Override
	public List<Meal> getMealList() {
		// TODO Auto-generated method stub
		return mealMapper.selectAll();
	}

	@Override
	public Mapper<Meal> getMapper() {
		// TODO Auto-generated method stub
		return null;
	}

}
