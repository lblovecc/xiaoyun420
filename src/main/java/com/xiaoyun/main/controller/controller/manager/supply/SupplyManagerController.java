package com.xiaoyun.main.controller.controller.manager.supply;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.alibaba.fastjson.JSONObject;
import com.xiaoyun.main.controller.base.AbstractBaseController;
import com.xiaoyun.main.model.Supply;
import com.xiaoyun.main.service.manager.SupplyService;
import com.xiaoyun.main.service.manager.UserService;
@Controller
@RequestMapping("/supplyManager")
public class SupplyManagerController extends AbstractBaseController{
	
	@Autowired
	private SupplyService supplyService;
	@Autowired
	private UserService userService;
	/**
	 * 查询所有供应商品
	 * @param request
	 * @param content title\openid
	 * @param value    
	 * @return
	 */
	@RequestMapping("/getList")
	public JSONObject getSupplyList(HttpServletRequest request,String content,String value){
		
		Map<String,Object> qryMap = new HashMap<>();
		
		List<Supply> list=null;
		if("null".equals(content)){
			list=supplyService.getList(qryMap);
			return getJsonResult(list);
		}else{
			if("title".equals(content)){
				qryMap.put("title", value);
				list=supplyService.getList(qryMap);
				return getJsonResult(list);
			}
			if("openid".equals(content)){
				Long userId=userService.getUserByOpenid(value).getId();
				qryMap.put("openid", userId);
				list=supplyService.getList(qryMap);
				return getJsonResult(list);
			}
			return null;
		}
		
	}

	@RequestMapping("/update")
	public JSONObject update(HttpServletRequest request,Supply supply){
		
		int length=supplyService.update(supply);
		
		return getJsonResult(length);
		
	}
	
	@RequestMapping("/delete")
	public JSONObject delete(HttpServletRequest request,long id){
		int length=supplyService.delete(id);
		return getJsonResult(length);
	}
	
	@RequestMapping("/add")
	public JSONObject add(HttpServletRequest request,Supply supply){
		int length=supplyService.add(supply);
		return getJsonResult(length);
	}
	
	
}
