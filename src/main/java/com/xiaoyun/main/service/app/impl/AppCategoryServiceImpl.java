package com.xiaoyun.main.service.app.impl;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.xiaoyun.main.mapper.CategoryMapper;
import com.xiaoyun.main.model.Category;
import com.xiaoyun.main.service.app.AppCategoryService;
import com.xiaoyun.main.service.base.impl.BaseServiceImpl;

import tk.mybatis.mapper.common.Mapper;

@Service
public class AppCategoryServiceImpl extends BaseServiceImpl<Category> implements AppCategoryService{
	
	@Autowired
	private CategoryMapper categoryMapper;

	@Override
	public List<Category> getCategoryList(Map<String, Object> qryMap) {

		return categoryMapper.getCategoryList(qryMap);
	}

	@Override
	public Mapper<Category> getMapper() {
		// TODO Auto-generated method stub
		return null;
	}

}
