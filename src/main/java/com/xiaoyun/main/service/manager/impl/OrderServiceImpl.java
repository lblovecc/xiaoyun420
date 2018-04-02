package com.xiaoyun.main.service.manager.impl;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.github.pagehelper.PageHelper;
import com.xiaoyun.main.common.Paginator;
import com.xiaoyun.main.mapper.OrderMapper;
import com.xiaoyun.main.model.Order;
import com.xiaoyun.main.service.base.impl.BaseServiceImpl;
import com.xiaoyun.main.service.manager.OrderService;

import tk.mybatis.mapper.common.Mapper;

@Service
public class OrderServiceImpl extends BaseServiceImpl<Order> implements OrderService {

	@Autowired
	private OrderMapper orderMapper;
	
	@Override
	public List<Order> getList(Map<String, Object> qryMap,Paginator paginator) {
		PageHelper.startPage(paginator.getPageNumber(), paginator.getPageSize());
		return orderMapper.getList(qryMap);
	}

	@Override
	public int delete(long id) {
		return orderMapper.deleteByPrimaryKey(id);
	}

	@Override
	public int update(Order order) {
		return orderMapper.updateByPrimaryKeySelective(order);
	}

	@Override
	public Mapper<Order> getMapper() {
		// TODO Auto-generated method stub
		return null;
	}

	
}