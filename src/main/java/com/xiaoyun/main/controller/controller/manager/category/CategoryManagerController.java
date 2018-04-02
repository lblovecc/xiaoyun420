package com.xiaoyun.main.controller.controller.manager.category;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.alibaba.fastjson.JSONObject;
import com.xiaoyun.main.controller.base.AbstractBaseController;
import com.xiaoyun.main.mapper.CategoryMapper;
import com.xiaoyun.main.model.Category;
import com.xiaoyun.main.service.manager.CategoryService;

@Controller
@RequestMapping("/categoryManager")
public class CategoryManagerController extends AbstractBaseController {

	@Autowired
	private CategoryService categoryService;
	
	@RequestMapping("/getCategoryList")
	public JSONObject getCategoryList(HttpServletRequest request ){
		
		//一级目录list
		List<ArrayList<Category>> list= new ArrayList<ArrayList<Category>>();
		Map<String,Object> qryMap1 = new HashMap<>();
		qryMap1.put("type", 1);
		List<Category> list1 =categoryService.getFirstLevel(qryMap1);
	
		
		
		List<Category> list2=null;
		for (Category category : list1) {
			Map<String,Object> qryMap2 = new HashMap<>();
			qryMap2.put("parentId", category.getParentid());
			qryMap2.put("type", 2);
			list2=categoryService.getSecondLevel(qryMap2);
		//	list.add
		}
		return getJsonResult(list2);
		
	}
}
