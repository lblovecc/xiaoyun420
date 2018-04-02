package com.xiaoyun.main.controller.controller.manager.order;


import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.alibaba.fastjson.JSONObject;
import com.xiaoyun.main.controller.base.AbstractBaseController;
import com.xiaoyun.main.model.Order;
import com.xiaoyun.main.service.manager.OrderService;

@Controller
@RequestMapping("/orderManager")
public class OrderManagerController extends AbstractBaseController {

	@Autowired
	private OrderService orderService;
	
	/**
	 * 查询订单
	 * @param request
	 * @param content 所有订单、订单状态、支付状态、
	 * @param value 
	 * @return
	 */
	@RequestMapping("/getList")
	public JSONObject getOrderList(HttpServletRequest request,String content,String value){
		Map<String,Object> qryMap = new HashMap<>();
		List<Order> list=null;
		if("null".equals(content)){
			list=orderService.getList(qryMap);
			 return getJsonResult(list);
		}else{
			if("orderStatus".equals(content)){
				qryMap.put("orderStatus", value);
				list=orderService.getList(qryMap);
				return getJsonResult(list);
			}
			if("payStatus".equals(content)){
				qryMap.put("payStatus", value);
				list=orderService.getList(qryMap);
				return getJsonResult(list);
			}
		}
		return getJsonResult(list);
	}
	/**
	 * 更新订单
	 * @param request
	 * @param order
	 * @return
	 */
	@RequestMapping("/update")
	public JSONObject update(HttpServletRequest request,Order order){
		int length=orderService.update(order);
		return getJsonResult(length);
		
	}
	/**
	 * 删除订单
	 * @param request
	 * @param id
	 * @return
	 */
	@RequestMapping("/delete")
	public JSONObject delete(HttpServletRequest request,long id){
		int length=orderService.delete(id);
		return getJsonResult(length);
	}
	/**
	 * 添加订单
	 * @param request
	 * @param order
	 * @return
	 */
	@RequestMapping("/add")
	public JSONObject add(HttpServletRequest request,Order order){
		
		int length=orderService.update(order);
		return getJsonResult(length);
	}
}
