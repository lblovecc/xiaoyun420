package com.xiaoyun.main.service.manager.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.xiaoyun.main.mapper.CategoryMapper;
import com.xiaoyun.main.model.Category;
import com.xiaoyun.main.service.base.impl.BaseServiceImpl;
import com.xiaoyun.main.service.manager.CategoryService;

import tk.mybatis.mapper.common.Mapper;

@Service
public class CategoryServiceImpl extends BaseServiceImpl<Category> implements CategoryService{

	@Autowired
	private CategoryMapper categoryMapper;
	@Override
	public List<Category> getFirstLevel(Map<String, Object> qryMap) {
		
		return categoryMapper.getCategoryList(qryMap);
	}

	@Override
	public List<Category> getSecondLevel(Map<String, Object> qryMap) {
		return categoryMapper.getCategoryList(qryMap);
	}

	@Override
	public Mapper<Category> getMapper() {
		// TODO Auto-generated method stub
		return null;
	}

}
