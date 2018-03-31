package com.xiaoyun.main.service.app;
import java.util.Map;

import com.xiaoyun.main.model.Address;
import com.xiaoyun.main.model.User;
import com.xiaoyun.main.model.vo.UserVO;
import com.xiaoyun.main.service.base.BaseService;

public interface AppUserService extends BaseService<User>{
	
	public int saveUserInfo(User user);
	
	public int updateUserInfo(User user,Address address);
	
	public UserVO getUserInfo(Map<String,Object> qryMap);

}
