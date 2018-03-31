package com.xiaoyun.main.controller.controller.app.user;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.alibaba.fastjson.JSONObject;
import com.xiaoyun.main.controller.base.AbstractBaseController;
import com.xiaoyun.main.model.Address;
import com.xiaoyun.main.model.User;
import com.xiaoyun.main.model.vo.UserVO;
import com.xiaoyun.main.service.app.AppUserService;

/**
 * 用户信息
 * @author Mr.LB
 *
 */

@Controller
@RequestMapping(value="/xiaochengxu")
public class AppUserAction extends AbstractBaseController{
	
	@Autowired
	private AppUserService userService;
	
	/**
	 * 修改用户信息
	 * @param user
	 * @param address
	 * @return
	 */
	@ResponseBody
	@RequestMapping(value="/update_user_info.do")
	public JSONObject updateUserInfo(User user,Address address){
		
		int m = userService.updateUserInfo(user, address);
		
		if(m==0){
			return getAppErrorJsonResult("1", "添加信息失败,请重新尝试!");
		}else{
			return getAppJsonResult();
		}
	}
	
	/**
	 * 获取用户信息
	 * @param userId
	 * @return
	 */
	@ResponseBody
	@RequestMapping(value="/get_user_info.do")
	public JSONObject getUserInfo(Long userId){
		
		Map<String,Object> qryMap = new HashMap<String,Object>();
		UserVO user = userService.getUserInfo(qryMap);
		
		return getAppJsonResult(user);
	}

}
