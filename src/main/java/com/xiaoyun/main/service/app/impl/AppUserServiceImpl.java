package com.xiaoyun.main.service.app.impl;

import java.util.Date;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.transaction.interceptor.TransactionAspectSupport;

import com.github.pagehelper.PageHelper;
import com.xiaoyun.main.common.EasyUIPaginator;
import com.xiaoyun.main.mapper.AddressMapper;
import com.xiaoyun.main.mapper.UserMapper;
import com.xiaoyun.main.mapper.ViewChanceMapper;
import com.xiaoyun.main.model.Address;
import com.xiaoyun.main.model.vo.CollectVO;
import com.xiaoyun.main.model.vo.SupplyAndBuyVO;
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

	@Transactional
	@Override
	public int saveUserInfo(User user) {
		
		Date now = new Date();
		
		user.setCreatetime(now);
		user.setUpdatetime(now);
		
		try{
			userMapper.insertSelective(user);
			
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

	@Transactional
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

	@Override
	public List<SupplyAndBuyVO> getSupplyAndBuyList(Map<String, Object> qryMap,EasyUIPaginator paginator) {
		
		PageHelper.startPage(paginator.getPage(), paginator.getRows());
		
		return userMapper.getSupplyAndBuyList(qryMap);
	}

	@Override
	public List<CollectVO> getCollectList(Map<String, Object> qryMap, EasyUIPaginator paginator) {
		
		PageHelper.startPage(paginator.getPage(), paginator.getRows());
		
		return userMapper.getCollectList(qryMap);
	}
	
	public User selectOne(User user){
		return userMapper.selectOne(user);
	}
	
	public int updateNotNull(User user){
		return userMapper.updateByPrimaryKeySelective(user);
	}

	@Override
	public Mapper<User> getMapper() {
		// TODO Auto-generated method stub
		return null;
	}
	
}
