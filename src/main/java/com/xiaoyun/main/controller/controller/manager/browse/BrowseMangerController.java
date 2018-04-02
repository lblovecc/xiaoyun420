package com.xiaoyun.main.controller.controller.manager.browse;


import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.alibaba.fastjson.JSONObject;
import com.xiaoyun.main.controller.base.AbstractBaseController;
import com.xiaoyun.main.model.Browse;
import com.xiaoyun.main.service.manager.BrowseService;

@Controller
@RequestMapping("browseManager")
public class BrowseMangerController extends AbstractBaseController {

	@Autowired
	private BrowseService browseService;
	@RequestMapping("/getList")
	public JSONObject getTagList(HttpServletRequest request, HttpServletResponse response){
		Map<String,Object> qryMap = new HashMap<>();
		List<Browse> list=browseService.getBrowseList(qryMap);
		return getJsonResult(list);
	}

	@RequestMapping("/update")
	public JSONObject update(HttpServletRequest request, HttpServletResponse response,Browse browse){
		
		int length=browseService.updateNotNull(browse);
		return getJsonResult(length);
		
	}
	
	@RequestMapping("/delete")
	public JSONObject delete(HttpServletRequest request, HttpServletResponse response,long id){
		
		int length=browseService.delete(id);
		
		return getJsonResult(length);
	}
	
	@RequestMapping("/add")
	public JSONObject add(HttpServletRequest request,Browse browse){
		
		int length=browseService.add(browse);
		
		return getJsonResult(length);
	}
}
