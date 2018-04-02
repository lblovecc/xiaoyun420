package com.xiaoyun.main.service.manager.impl;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.xiaoyun.main.mapper.TagMapper;
import com.xiaoyun.main.model.Tag;
import com.xiaoyun.main.service.base.impl.BaseServiceImpl;
import com.xiaoyun.main.service.manager.TagService;

import tk.mybatis.mapper.common.Mapper;
@Service
public class TagServiceImpl extends BaseServiceImpl<Tag> implements TagService{

	@Autowired
	private TagMapper tagMapper;
	@Override
	public List<Tag> getList(Map<String, Object> qryMap) {
		
		return tagMapper.getTagList(qryMap);
	}

	@Override
	public int add(Tag tag) {
		return tagMapper.insertSelective(tag);
	}

	@Override
	public int delete(long id) {
		return tagMapper.deleteByPrimaryKey(id);
	}

	@Override
	public int update(Tag tag) {
		return tagMapper.updateByPrimaryKeySelective(tag);
	}

	@Override
	public Mapper<Tag> getMapper() {
		// TODO Auto-generated method stub
		return null;
	}

}
