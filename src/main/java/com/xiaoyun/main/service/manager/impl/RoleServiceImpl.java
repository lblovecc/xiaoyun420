package com.xiaoyun.main.service.manager.impl;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.github.pagehelper.PageHelper;
import com.xiaoyun.main.common.Paginator;
import com.xiaoyun.main.mapper.RoleMapper;
import com.xiaoyun.main.model.Role;
import com.xiaoyun.main.service.base.impl.BaseServiceImpl;
import com.xiaoyun.main.service.manager.RoleService;

import tk.mybatis.mapper.common.Mapper;

@Service
public class RoleServiceImpl extends BaseServiceImpl<Role> implements RoleService{

	@Autowired
	private RoleMapper roleMapper;
	
	
	@Override
	public List<Role> getRoleList(Map<String, Object> qryMap, Paginator paginator) {
		PageHelper.startPage(paginator.getPageNumber(),paginator.getPageSize());
		return roleMapper.getList(qryMap);
	}

	@Override
	public int add(Role role) {
		return roleMapper.insertSelective(role);
	}

	@Override
	public int delete(long id) {
		return roleMapper.deleteByPrimaryKey(id);
	}

	@Override
	public Mapper<Role> getMapper() {
		return null;
	}

}
