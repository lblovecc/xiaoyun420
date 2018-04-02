package com.xiaoyun.main.service.manager.impl;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.github.pagehelper.PageHelper;
import com.xiaoyun.main.common.Paginator;
import com.xiaoyun.main.mapper.ManagerMapper;
import com.xiaoyun.main.model.Manager;
import com.xiaoyun.main.service.base.impl.BaseServiceImpl;
import com.xiaoyun.main.service.manager.ManagerService;

import tk.mybatis.mapper.common.Mapper;

@Service
public class ManagerServiceImpl extends BaseServiceImpl<Manager> implements ManagerService {

	@Autowired
	private ManagerMapper managerMapper;
	
	@Override
	public List<Manager> getList(Map<String, Object> qryMap, Paginator paginator) {
		PageHelper.startPage(paginator.getPageNumber(), paginator.getPageSize());
		
		return managerMapper.getManagerList(qryMap);
	}

	@Override
	public int delete(long id) {
		return managerMapper.deleteByPrimaryKey(id);
	}

	@Override
	public int add(Manager manager) {
		return managerMapper.insertSelective(manager);
	}

	@Override
	public int update(Manager manager) {
		return managerMapper.updateByPrimaryKeySelective(manager);
	}

	@Override
	public Mapper<Manager> getMapper() {
		// TODO Auto-generated method stub
		return null;
	}

}
