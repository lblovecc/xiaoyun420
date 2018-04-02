package com.xiaoyun.main.service.manager.impl;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.github.pagehelper.PageHelper;
import com.xiaoyun.main.common.Paginator;
import com.xiaoyun.main.mapper.SupplyMapper;
import com.xiaoyun.main.model.Supply;
import com.xiaoyun.main.model.vo.SupplyVO;
import com.xiaoyun.main.service.base.impl.BaseServiceImpl;
import com.xiaoyun.main.service.manager.SupplyService;

import tk.mybatis.mapper.common.Mapper;

@Service
public class SupplyServiceImpl extends BaseServiceImpl<Supply> implements SupplyService {

	@Autowired
	private SupplyMapper supplyMapper ;
	
	@Override
	public List<SupplyVO> getList(Map<String, Object> qryMap,Paginator paginator) {
		PageHelper.startPage(paginator.getPageNumber(),paginator.getPageSize());
		List<SupplyVO> list=supplyMapper.getSupplyList(qryMap);
		return list;
	}

	@Override
	public int add(Supply supply) {
		return supplyMapper.insertSelective(supply);
	}

	@Override
	public int delete(long id) {
		return supplyMapper.deleteByPrimaryKey(id);
	}

	@Override
	public int update(Supply supply) {
		return supplyMapper.updateByPrimaryKeySelective(supply);
	}

	@Override
	public Mapper<Supply> getMapper() {
		// TODO Auto-generated method stub
		return null;
	}

}
