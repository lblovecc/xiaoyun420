package com.xiaoyun.main.mapper;

import java.util.List;
import java.util.Map;

import com.xiaoyun.main.model.vo.CollectVO;
import com.xiaoyun.main.model.vo.SupplyAndBuyVO;
import com.xiaoyun.main.model.User;
import com.xiaoyun.main.model.vo.UserVO;

public interface UserMapper {
	
    int deleteByPrimaryKey(Long id);

    int insert(User record);

    int insertSelective(User record);

    User selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(User record);

    int updateByPrimaryKey(User record);
    
    UserVO getUserInfo(Map<String,Object> qryMap);
    
    List<SupplyAndBuyVO> getSupplyAndBuyList(Map<String,Object> qryMap);
    
    List<CollectVO> getCollectList(Map<String,Object> qryMap);
    
    User findUserByOpenid(String openid);
    
    List<User> getUserList(Map<String, Object> qryMap);
}