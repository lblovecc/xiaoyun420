package com.xiaoyun.main.service.manager.impl;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.github.pagehelper.PageHelper;
import com.xiaoyun.main.common.Paginator;
import com.xiaoyun.main.mapper.BuyMapper;
import com.xiaoyun.main.model.Buy;
import com.xiaoyun.main.model.vo.BuyVO;
import com.xiaoyun.main.service.base.impl.BaseServiceImpl;
import com.xiaoyun.main.service.manager.BuyService;

import tk.mybatis.mapper.common.Mapper;

@Service
public class BuyServiceImpl extends BaseServiceImpl<Buy> implements BuyService{

	@Autowired
	private BuyMapper buyMapper;
	@Override
	public List<BuyVO> getList(Map<String, Object> qryMap, Paginator paginator) {
		PageHelper.startPage(paginator.getPageNumber(), paginator.getPageSize());
		List<BuyVO> list=buyMapper.getBuyList(qryMap);
		return list;
	}

	@Override
	public int delete(long  id) {
		// TODO Auto-generated method stub
		return buyMapper.deleteByPrimaryKey(id);
	}

	@Override
	public Mapper<Buy> getMapper() {
		// TODO Auto-generated method stub
		return null;
	}

}
