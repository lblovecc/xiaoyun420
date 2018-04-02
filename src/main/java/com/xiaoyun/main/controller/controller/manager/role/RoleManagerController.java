package com.xiaoyun.main.controller.controller.manager.role;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.alibaba.fastjson.JSONObject;
import com.xiaoyun.main.controller.base.AbstractBaseController;
import com.xiaoyun.main.model.Role;
import com.xiaoyun.main.service.manager.RoleService;
/**
 * 角色管理
 * @author Liar
 *
 */
@Controller
@RequestMapping("/roleManager")
public class RoleManagerController extends AbstractBaseController {
	
	@Autowired
	private RoleService roleService;
	
	@RequestMapping("/getRoleList")
	public JSONObject getRoleList(HttpServletRequest request){
		
		Map<String,Object> qryMap=new HashMap();
		List<Role> list=roleService.getRoleList(qryMap);
		
		return getJsonResult(list);
	}
	@RequestMapping("/delete")
	public JSONObject delete(HttpServletRequest request,long id){
		int length=roleService.delete(id);
		return getJsonResult(length);
	}
	@RequestMapping("/add")
	public JSONObject add(HttpServletRequest request,Role role){
		int length=roleService.add(role);
		return getJsonResult(length);
	}
	
}
