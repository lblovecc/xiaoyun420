package com.xiaoyun.main.controller.controller.manager.user;

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
import com.xiaoyun.main.model.User;
import com.xiaoyun.main.service.manager.UserService;

@Controller
@RequestMapping({"/userManager"})
public class UserManagerController extends AbstractBaseController{
	
	@Autowired
	private UserService userService;
	@RequestMapping({"/getUserList"})
	public JSONObject getUserList(HttpServletRequest request, HttpServletResponse response,String content,String value){
		
		Map<String,Object> qryMap = new HashMap<>();
		List<User> userList = null;
		if("null".equals(content)){
			userList = userService.getUserList(qryMap);
			return getJsonResult(userList);
		}else{
			if("openid".equals(content)){
				qryMap.put("openid", value);
			}
			if("status".equals(content)){
				qryMap.put("status", value);
			}
			userList = userService.getUserList(qryMap);
			return getJsonResult(userList);
		}
	}
	@RequestMapping({"/update"})
	public JSONObject updateUser(HttpServletRequest request, HttpServletResponse response,User user){
		int length=userService.update(user);
		return getJsonResult(length); 
	}
	@RequestMapping({"/deleteUser"})
	public JSONObject deleteUser(HttpServletRequest request, HttpServletResponse response,long id){
		
		int length=userService.delete(id);
		return getJsonResult(length); 
	}

}
