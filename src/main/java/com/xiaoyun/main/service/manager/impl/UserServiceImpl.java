package com.xiaoyun.main.service.manager.impl;


import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.github.pagehelper.PageHelper;
import com.xiaoyun.main.common.Paginator;
import com.xiaoyun.main.mapper.UserMapper;
import com.xiaoyun.main.model.User;
import com.xiaoyun.main.service.base.impl.BaseServiceImpl;
import com.xiaoyun.main.service.manager.UserService;

import tk.mybatis.mapper.common.Mapper;
@Service
public class UserServiceImpl extends BaseServiceImpl<User> implements UserService {

	@Autowired
	private UserMapper userMapper;
	
	
	@Override
	public User getUserByOpenid(String openid) {
		User user=userMapper.findUserByOpenid(openid);
		return user;
	}

	@Override
	public Mapper<User> getMapper() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<User> getUserList(Map<String, Object> qryMap,Paginator paginator) {
		PageHelper.startPage(paginator.getPageNumber(), paginator.getPageSize());
		return userMapper.getUserList(qryMap);
	}

	@Override
	public int deleteUser(long id) {
		
		return userMapper.deleteByPrimaryKey(id);
	}

	@Override
	public int update(User user) {
		return userMapper.updateByPrimaryKeySelective(user);
	}

	@Override
	public List<User> getCompanyList(Map<String, Object> qryMap,Paginator paginator) {
		PageHelper.startPage(paginator.getPageNumber(), paginator.getPageSize());
		return userMapper.getCompanyList(qryMap);
	}



}