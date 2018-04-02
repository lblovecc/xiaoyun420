package com.xiaoyun.main.controller.controller.manager.manager;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

import com.alibaba.fastjson.JSONObject;
import com.xiaoyun.main.common.Paginator;
import com.xiaoyun.main.controller.base.AbstractBaseController;

@Controller
@RequestMapping("/manager")
public class ManagerController extends AbstractBaseController  {

	@RequestMapping("/getManagerList")
	public JSONObject getList(HttpServletRequest request,@ModelAttribute Paginator paginator){
		
		
		return null;
	}
	
	@RequestMapping("/add")
	public JSONObject add(){
		return null;
	}
	@RequestMapping("/delete")
	public JSONObject delete(){
		return null;
	}
}
