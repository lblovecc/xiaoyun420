package com.xiaoyun.main.controller.controller.app.meal;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.alibaba.fastjson.JSONObject;
import com.xiaoyun.main.controller.base.AbstractBaseController;
import com.xiaoyun.main.model.Meal;
import com.xiaoyun.main.service.app.AppMealService;

/**
 * 获取套餐信息
 * @author Mr.LB
 *
 */
@Controller
@RequestMapping(value="/xiaochengxu")
public class AppMealAction extends AbstractBaseController {

	@Autowired
	private AppMealService mealService;
	
	@RequestMapping(value="/get_meal_list")
	public JSONObject getMealList(HttpServletRequest httpServletRequest){
		
		List<Meal> mealList = mealService.getMealList();
		
		return getAppJsonResult(mealList);
	}
}
