package com.xiaoyun.main.service.app.impl;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.xiaoyun.main.mapper.TagMapper;
import com.xiaoyun.main.model.Tag;
import com.xiaoyun.main.service.app.AppTagService;
import com.xiaoyun.main.service.base.impl.BaseServiceImpl;

import tk.mybatis.mapper.common.Mapper;

@Service
public class AppTagServiceImpl extends BaseServiceImpl<Tag> implements AppTagService {
	
	@Autowired
	private TagMapper tagMapper;

	@Override
	public List<Tag> getTagList(Map<String, Object> qryMap) {
		
		return tagMapper.getTagList(qryMap);
	}

	@Override
	public Mapper<Tag> getMapper() {
		// TODO Auto-generated method stub
		return null;
	}
	
	@Override
	public Tag selectOne(Tag tag){
		return tagMapper.selectOne(tag);
	}

}
