package com.xiaoyun.main.service.manager.impl;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.xiaoyun.main.mapper.BrowseMapper;
import com.xiaoyun.main.model.Browse;
import com.xiaoyun.main.service.base.impl.BaseServiceImpl;
import com.xiaoyun.main.service.manager.BrowseService;

import tk.mybatis.mapper.common.Mapper;

@Service
public class BrowseServiceImpl extends BaseServiceImpl<Browse> implements BrowseService {

	@Autowired
	private BrowseMapper browseMapper;
	@Override
	public List<Browse> getBrowseList(Map<String, Object> qryMap) {
	
		return 	browseMapper.getBrowseList(qryMap);
	}
	

	@Override
	public Mapper<Browse> getMapper() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int update(Browse browse) {
		
		return browseMapper.updateByPrimaryKeySelective(browse);
	}


	@Override
	public int delete(long id) {
		return browseMapper.deleteByPrimaryKey(id);
	}


	@Override
	public int add(Browse browse) {
		
		return browseMapper.insertSelective(browse);
	}



}
