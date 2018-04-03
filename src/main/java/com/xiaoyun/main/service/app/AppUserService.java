package com.xiaoyun.main.service.app;
import java.util.List;
import java.util.Map;

import com.xiaoyun.main.common.EasyUIPaginator;
import com.xiaoyun.main.model.Address;
import com.xiaoyun.main.model.vo.CollectVO;
import com.xiaoyun.main.model.vo.SupplyAndBuyVO;
import com.xiaoyun.main.model.User;
import com.xiaoyun.main.model.vo.UserVO;
import com.xiaoyun.main.service.base.BaseService;

public interface AppUserService extends BaseService<User>{
	
	public int saveUserInfo(User user);
	
	public int updateUserInfo(User user,Address address);
	
	public UserVO getUserInfo(Map<String,Object> qryMap);
	
	public List<SupplyAndBuyVO> getSupplyAndBuyList(Map<String,Object> qryMap,EasyUIPaginator paginator);
	
	public List<CollectVO> getCollectList(Map<String,Object> qryMap,EasyUIPaginator paginator);
	
	public User selectOne(User user);
	
	public int updateNotNull(User user);

}
