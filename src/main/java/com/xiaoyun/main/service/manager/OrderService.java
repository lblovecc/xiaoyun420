package com.xiaoyun.main.service.manager;

import java.util.List;
import java.util.Map;

import com.xiaoyun.main.model.Order;
import com.xiaoyun.main.service.base.BaseService;

public interface OrderService extends BaseService<Order> {

	public List<Order> getList(Map<String, Object> qryMap);
	
	public int delete(long id);
	
	public int update(Order order);
}
