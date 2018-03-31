package com.xiaoyun.main.controller.controller.app.category;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.alibaba.fastjson.JSONObject;
import com.xiaoyun.main.controller.base.AbstractBaseController;
import com.xiaoyun.main.model.Category;
import com.xiaoyun.main.service.app.AppCategoryService;

/**
 * 
 * @author Mr.LB
 * 
 * 类目信息(包含一级类目、二级类目)
 *
 */

@Controller
@RequestMapping({"/xiaochengxu"})
public class AppCategoryAction extends AbstractBaseController{
	
	@Autowired
	private AppCategoryService categoryService;
	
	/**
	 * 获取类目集合(包含一级类目、二级类目)
	 * @param request
	 * @param response
	 * @return
	 */
	@ResponseBody
	@RequestMapping({"/get_category_list"})
	public JSONObject getCategoryInfo(HttpServletRequest request, HttpServletResponse response){
		
		String parentId = request.getParameter("parentId");
		String type = request.getParameter("type");				//类目类型       1:一级类目  2:二级类目
		Map<String,Object> qryMap = new HashMap<>();
		
		qryMap.put("parentId", parentId);
		qryMap.put("type", type);
		
		List<Category> categoryList = categoryService.getCategoryList(qryMap);
		
		return getAppJsonResult(categoryList);
		
	}

}
