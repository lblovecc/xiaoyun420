package com.xiaoyun.main.service.manager;

import java.util.List;
import java.util.Map;

import com.xiaoyun.main.model.Role;
import com.xiaoyun.main.service.base.BaseService;

public interface RoleService extends BaseService<Role> {

 	public List<Role> getRoleList(Map<String,Object> qryMap);
 	
 	public int add(Role role);
 	
 	public int delete(long id);
 	
 	
}
