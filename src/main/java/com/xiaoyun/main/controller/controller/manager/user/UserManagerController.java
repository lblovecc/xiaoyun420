package com.xiaoyun.main.controller.controller.manager.user;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.alibaba.fastjson.JSONObject;
import com.xiaoyun.main.common.Paginator;
import com.xiaoyun.main.controller.base.AbstractBaseController;
import com.xiaoyun.main.model.User;
import com.xiaoyun.main.service.manager.UserService;
/**
 * 用户管理
 * @author Liar
 *
 */
@Controller
@RequestMapping({"/userManager"})
public class UserManagerController extends AbstractBaseController{
	
	@Autowired
	private UserService userService;
	/**
	 * 获取用户信息列表
	 * @param request
	 * @param response
	 * @param content
	 * @param value
	 * @param paginator
	 * @return
	 */
	@ResponseBody
	@RequestMapping({"/getUserList"})
	public JSONObject getUserList(HttpServletRequest request, HttpServletResponse response,String content,String value,@ModelAttribute Paginator paginator){
		
		Map<String,Object> qryMap = new HashMap<>();
		List<User> userList = null;
		if("null".equals(content)){
			userList = userService.getUserList(qryMap, paginator);
			return getJsonResult(userList);
		}else{
			if("openid".equals(content)){
				qryMap.put("openid", value);
			}
			if("status".equals(content)){
				qryMap.put("status", value);
			}
			userList = userService.getUserList(qryMap,paginator);
			return getJsonResult(userList);
		}
	}
	/**
	 * 更新用户信息
	 * @param request
	 * @param response
	 * @param user
	 * @return
	 */
	@RequestMapping({"/update"})
	public JSONObject updateUser(HttpServletRequest request, HttpServletResponse response,User user){
		int length=userService.update(user);
		return getJsonResult(length); 
	}
	/**
	 * 根据id删除用户
	 * @param request
	 * @param response
	 * @param id
	 * @return
	 */
	@ResponseBody
	@RequestMapping({"/deleteUser"})
	public JSONObject deleteUser(HttpServletRequest request, HttpServletResponse response,long id){
		
		int length=userService.deleteUser(id);
		return getJsonResult(length); 
	}

}
