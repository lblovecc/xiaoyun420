package com.xiaoyun.main.service.manager.impl;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.github.pagehelper.PageHelper;
import com.xiaoyun.main.common.Paginator;
import com.xiaoyun.main.mapper.MenuMapper;
import com.xiaoyun.main.model.Menu;
import com.xiaoyun.main.service.base.impl.BaseServiceImpl;
import com.xiaoyun.main.service.manager.MenuService;

import tk.mybatis.mapper.common.Mapper;
@Service
public class MenuServiceImpl extends BaseServiceImpl<Menu> implements MenuService {

	@Autowired
	private MenuMapper menuMapper;
	@Override
	public List<Menu> getMenuList(Map<String, Object> qryMap,Paginator paginator) {
		PageHelper.startPage(paginator.getPageNumber(), paginator.getPageSize());
		return menuMapper.getList(qryMap);
	}

	@Override
	public int update(Menu menu) {
		return menuMapper.updateByPrimaryKeySelective(menu);
	}

	@Override
	public int delete(long id) {
		return menuMapper.deleteByPrimaryKey(id);
	}

	@Override
	public int add(Menu menu) {
		return menuMapper.insertSelective(menu);
	}

	@Override
	public Mapper<Menu> getMapper() {
		// TODO Auto-generated method stub
		return null;
	}

}
