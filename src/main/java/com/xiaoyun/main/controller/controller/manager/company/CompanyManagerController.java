package com.xiaoyun.main.controller.controller.manager.company;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

import com.alibaba.fastjson.JSONObject;
import com.xiaoyun.main.common.Paginator;
import com.xiaoyun.main.controller.base.AbstractBaseController;
import com.xiaoyun.main.model.User;
import com.xiaoyun.main.service.manager.UserService;

@Controller
@RequestMapping("/companyManager")
public class CompanyManagerController extends AbstractBaseController {
	
	
	@Autowired
	private UserService userService;
	
	@RequestMapping("/getCompanyList")
	public JSONObject getCompanyList(HttpServletRequest request, HttpServletResponse response,String content,String value,@ModelAttribute Paginator paginator){
		Map<String,Object> qryMap = new HashMap<>();
		List<User> list=null;
		if("null".equals(content)){
			list=userService.getCompanyList(qryMap, paginator);
			return  getJsonResult(list);
		}else{
			if("companyName".equals(content)){
				qryMap.put("companyName", value);
				list=userService.getCompanyList(qryMap, paginator);
			}
			return  getJsonResult(list);
		}
	}
	@RequestMapping("/addCompany")
	public JSONObject addCompany(HttpServletRequest request,User user){
		if(!"null".equals(user.getCompanyname())){
			int length=userService.update(user);
			return getJsonResult(length);
		}
		String msg="请输入公司名称";
		return getErrorJsonResult(msg);
	}
	@RequestMapping("/update")
	public JSONObject update(HttpServletRequest request,User user){
		if(!"null".equals(user.getCompanyname())){
			int length=userService.update(user);
			return getJsonResult(length);
		}
		String msg="请填写公司名称";
		return getErrorJsonResult(msg);
	}

}
