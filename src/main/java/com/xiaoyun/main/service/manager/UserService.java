package com.xiaoyun.main.service.manager;

import java.util.List;
import java.util.Map;

import com.xiaoyun.main.model.User;
import com.xiaoyun.main.service.base.BaseService;

public interface UserService extends BaseService<User> {

	public User getUserByOpenid(String openid);
	
	public List<User> getUserList(Map<String, Object> qryMap);
	
	public int deleteUser(long id);
	
	public int update(User user);
	
}
