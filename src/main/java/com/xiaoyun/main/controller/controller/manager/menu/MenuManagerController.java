package com.xiaoyun.main.controller.controller.manager.menu;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.alibaba.fastjson.JSONObject;
import com.xiaoyun.main.controller.base.AbstractBaseController;
import com.xiaoyun.main.model.Menu;
import com.xiaoyun.main.service.manager.MenuService;
@Controller
@RequestMapping("/menuManager")
public class MenuManagerController extends AbstractBaseController  {

	@Autowired
	private MenuService menuService;
	
	@RequestMapping("/getList")
	public JSONObject getList(HttpServletRequest request){
		
		Map<String,Object> qryMap = new HashMap<>();
		List<Menu> list=menuService.getMenuList(qryMap);
		return getJsonResult(list);
	}
	
	@RequestMapping("/add")
	public JSONObject add(HttpServletRequest request,Menu menu){
		int length=menuService.add(menu);
		return getJsonResult(length);
	}
	@RequestMapping("/delete")
	public JSONObject delete(HttpServletRequest request,long id){
		int length=menuService.delete(id);
		return getJsonResult(length);
	}
	
	@RequestMapping("/update")
	public JSONObject update(HttpServletRequest request,Menu menu){
		int length=menuService.update(menu);
		return getJsonResult(length);
	}
}
