package com.xiaoyun.main.service.app.impl;

import java.util.Date;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.transaction.interceptor.TransactionAspectSupport;

import com.xiaoyun.main.mapper.AddressMapper;
import com.xiaoyun.main.mapper.UserMapper;
import com.xiaoyun.main.mapper.ViewChanceMapper;
import com.xiaoyun.main.model.Address;
import com.xiaoyun.main.model.User;
import com.xiaoyun.main.model.ViewChance;
import com.xiaoyun.main.model.vo.UserVO;
import com.xiaoyun.main.service.app.AppUserService;
import com.xiaoyun.main.service.base.impl.BaseServiceImpl;

import tk.mybatis.mapper.common.Mapper;

@Service
public class AppUserServiceImpl extends BaseServiceImpl<User> implements AppUserService{
	
	@Autowired
	private UserMapper userMapper;
	
	@Autowired
	private ViewChanceMapper viewChanceMapper;
	
	@Autowired
	private AddressMapper addressMapper;

	@Override
	public Mapper<User> getMapper() {
		// TODO Auto-generated method stub
		return null;
	}

	@Transactional
	@Override
	public int saveUserInfo(User user) {
		
		Date now = new Date();
		
		user.setCreatetime(now);
		
		try{
			userMapper.insert(user);
			
			ViewChance viewChance = new ViewChance();
			viewChance.setCreatetime(now);
			viewChance.setForwardcount(0);
			viewChance.setFreecount(3);
			viewChance.setMealcount(0);
			viewChance.setUpdatetime(now);
			viewChance.setUserid(user.getId());
			
			viewChanceMapper.insert(viewChance);
			
			return 2;
		}catch(Exception e){
			//throw new RuntimeException(); 			事务回滚方法一
			TransactionAspectSupport.currentTransactionStatus().setRollbackOnly();			//事务回滚方法二
			return 0;
		}
	}

	@Override
	public int updateUserInfo(User user, Address address) {
		
		try{
			addressMapper.insert(address);
			
			user.setAddressid(address.getId());
			
			userMapper.updateByPrimaryKey(user);
			
			return 2;
		}catch(Exception e){
			//throw new RuntimeException(); 			事务回滚方法一
			TransactionAspectSupport.currentTransactionStatus().setRollbackOnly();			//事务回滚方法二
			return 0;
		}
		
	}

	@Override
	public UserVO getUserInfo(Map<String, Object> qryMap) {
		return userMapper.getUserInfo(qryMap);
	}
	
}
