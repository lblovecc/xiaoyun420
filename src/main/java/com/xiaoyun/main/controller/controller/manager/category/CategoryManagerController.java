package com.xiaoyun.main.controller.controller.manager.category;

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
import com.xiaoyun.main.model.Category;
import com.xiaoyun.main.service.manager.CategoryService;

@Controller
@RequestMapping("/categoryManager")
public class CategoryManagerController extends AbstractBaseController {

	@Autowired
	private CategoryService categoryService;
	/**
	 * 获取一级菜单
	 * @param request
	 * @param paginator
	 * @return
	 */
	@RequestMapping("/getCategoryList")
	public JSONObject getCategoryList(HttpServletRequest request,@ModelAttribute Paginator paginator ){
		
		//一级目录list
		//List<ArrayList<Category>> list= new ArrayList<ArrayList<Category>>();
		Map<String,Object> qryMap = new HashMap<>();
		qryMap.put("type", 1);
		List<Category> list1 =categoryService.getFirstLevel(qryMap);//一级目录
		
		return getJsonResult(list1);
	}
	/**
	 * 根据parentId取得二级类目
	 * @param request
	 * @param id parentId
	 * @param paginator
	 * @return
	 */
	@RequestMapping("/getListByParentId")
	public JSONObject getListByParentId(HttpServletRequest request,long id,@ModelAttribute Paginator paginator){
		Map<String,Object> qryMap = new HashMap<>();
		qryMap.put("parentId", id);
		List<Category> list1 =categoryService.getSecondLevel(qryMap);//二级目录
		return getJsonResult(list1);
	}
	/**
	 * 添加类目，如果一级类目没有父id
	 * 二级类目手动选择父id
	 * @param request
	 * @param category
	 * @return
	 */
	@RequestMapping("/add")
	public JSONObject add(HttpServletRequest request,Category category){
		int length =categoryService.addGategory(category);
		return getJsonResult(length);
	}
	/**
	 * 删除二级菜单
	 * @param request
	 * @param id
	 * @return
	 */
	@RequestMapping("/deleteSecond")
	public JSONObject deleteSecond(HttpServletRequest request,long id){
		int length =categoryService.deleteSecondLevel(id);
		return getJsonResult(length);
	}
	/**
	 * 删除一级菜单，同时二级子菜单一起删除
	 * @param request
	 * @param id
	 * @return
	 */
	@RequestMapping("/deleteFirst")
	public JSONObject deleteFirst(HttpServletRequest request,long id){
		Map<String,Object> qryMap = new HashMap<>();
		qryMap.put("parentId", id);
		List<Category> list1 =categoryService.getSecondLevel(qryMap);//该一级类目下的二级目录
		for (Category category : list1) {//删除二级类目
			categoryService.deleteSecondLevel(category.getParentid());
		}
		int length =categoryService.deleteSecondLevel(id);
		return getJsonResult(length);
	}
	
}
