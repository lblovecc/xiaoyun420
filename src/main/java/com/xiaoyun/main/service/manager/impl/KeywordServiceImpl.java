package com.xiaoyun.main.service.manager.impl;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.github.pagehelper.PageHelper;
import com.xiaoyun.main.common.Paginator;
import com.xiaoyun.main.mapper.KeywordMapper;
import com.xiaoyun.main.model.Keyword;
import com.xiaoyun.main.service.base.impl.BaseServiceImpl;
import com.xiaoyun.main.service.manager.KeywordService;

import tk.mybatis.mapper.common.Mapper;

@Service
public class KeywordServiceImpl extends BaseServiceImpl<Keyword> implements KeywordService {

	@Autowired
	private KeywordMapper keywordMapper;

	@Override
	public List<Keyword> getList(Map<String,Object> qryMap ,Paginator paginator) {
		PageHelper.startPage(paginator.getPageNumber(),paginator.getPageSize());
		List<Keyword> keywordList=keywordMapper.getKeyList(qryMap);
		return keywordList;
	}

	@Override
	public int add(Keyword keyword) {
	
		return keywordMapper.insertSelective(keyword);
	}

	@Override
	public int delete(long id) {
		// TODO Auto-generated method stub
		return keywordMapper.deleteByPrimaryKey(id);
	}

	@Override
	public int update(Keyword keyword) {
		// TODO Auto-generated method stub
		return keywordMapper.updateByPrimaryKeySelective(keyword);
	}

	@Override
	public Mapper<Keyword> getMapper() {
		// TODO Auto-generated method stub
		return null;
	}

}
