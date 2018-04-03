package com.xiaoyun.main.service.manager;

import java.util.List;
import java.util.Map;

import com.xiaoyun.main.common.Paginator;
import com.xiaoyun.main.model.User;
import com.xiaoyun.main.service.base.BaseService;
/**
 * 包含用户管理和商家管理
 * @author Liar
 *
 */
public interface UserService /*extends BaseService<User>*/ {

	public User getUserByOpenid(String openid);
	
	public List<User> getUserList(Map<String, Object> qryMap,Paginator paginator);
	
	public int deleteUser(long id);
	
	public int update(User user);
	
	public List<User> getCompanyList(Map<String, Object> qryMap,Paginator paginator);
}
