package com.xiaoyun.main.service.manager.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.xiaoyun.main.mapper.SupplyMapper;
import com.xiaoyun.main.model.Supply;
import com.xiaoyun.main.service.base.impl.BaseServiceImpl;
import com.xiaoyun.main.service.manager.SupplyService;

import tk.mybatis.mapper.common.Mapper;

@Service
public class SupplyServiceImpl extends BaseServiceImpl<Supply> implements SupplyService {

	@Autowired
	private SupplyMapper supplyMapper ;
	
	@Override
	public List<Supply> getList(Map<String, Object> qryMap) {
		
	/*	List<Supply> list=supplyMapper.getList(qryMap);
		return list;*/
		return null;
	}

	@Override
	public int add(Supply supply) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int delete(long id) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int update(Supply supply) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public Mapper<Supply> getMapper() {
		// TODO Auto-generated method stub
		return null;
	}

}
