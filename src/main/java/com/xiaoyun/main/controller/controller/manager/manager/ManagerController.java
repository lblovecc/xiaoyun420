package com.xiaoyun.main.controller.controller.manager.manager;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

import com.alibaba.fastjson.JSONObject;
import com.xiaoyun.main.common.Paginator;
import com.xiaoyun.main.controller.base.AbstractBaseController;
import com.xiaoyun.main.model.Manager;
import com.xiaoyun.main.service.manager.ManagerService;

@Controller
@RequestMapping("/manager")
public class ManagerController extends AbstractBaseController  {

	@Autowired
	private ManagerService managerService;
	
	@RequestMapping("/getManagerList")
	public JSONObject getList(HttpServletRequest request,@ModelAttribute Paginator paginator){
		
		Map<String,Object> qryMap=new HashMap<>();
		List<Manager> list=managerService.getList(qryMap, paginator);
		return getJsonResult(list);
	}
	
	@RequestMapping("/add")
	public JSONObject add(HttpServletRequest request ,Manager manager){
		int length=managerService.add(manager);
		return getJsonResult(length);
	}
	@RequestMapping("/delete")
	public JSONObject delete(HttpServletRequest request, long id){
		int length=managerService.delete(id);
		return getJsonResult(length);
	}
}
