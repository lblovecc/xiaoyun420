package com.xiaoyun.main.service.app.impl;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.transaction.interceptor.TransactionAspectSupport;

import com.github.pagehelper.PageHelper;
import com.xiaoyun.main.common.EasyUIPaginator;
import com.xiaoyun.main.mapper.BrowseMapper;
import com.xiaoyun.main.mapper.SupplyMapper;
import com.xiaoyun.main.mapper.SupplyTagTempMapper;
import com.xiaoyun.main.model.Browse;
import com.xiaoyun.main.model.Supply;
import com.xiaoyun.main.model.SupplyTagTemp;
import com.xiaoyun.main.model.vo.SupplyVO;
import com.xiaoyun.main.service.app.AppSupplyService;
import com.xiaoyun.main.service.base.impl.BaseServiceImpl;

import tk.mybatis.mapper.common.Mapper;

@Service
public class AppSupplyServiceImpl extends BaseServiceImpl<Supply> implements AppSupplyService {
	
	@Autowired
	private SupplyMapper supplyMapper;
	
	@Autowired
	private BrowseMapper browseMapper;
	
	@Autowired
	private SupplyTagTempMapper supplyTagTempMapper;

	@Override
	public Mapper<Supply> getMapper() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<SupplyVO> getSupplyList(Map<String, Object> qryMap,EasyUIPaginator paginator) {
		
		PageHelper.startPage(paginator.getPage(), paginator.getRows());
		
		List<SupplyVO> supplyList = supplyMapper.getSupplyList(qryMap);
		
		return supplyList;
	}
	
	@Override
	public List<SupplyVO> getSupplyList(Map<String, Object> qryMap){
		
		List<SupplyVO> supplyList = supplyMapper.getSupplyList(qryMap);
		
		return supplyList;
	}
	
//	private List<SupplyVO> addInfoToSupply(List<SupplyVO> supplyList){
//		
//		List<BrowseCountVO> browseCountList = supplyMapper.getBrowseCountForSupply(supplyList);		//供应帖子浏览次数集合
//		
//		for(SupplyVO supplyVO : supplyList){
//			
//			supplyVO.setBrowseCount(0);					//浏览次数默认为0
//			
//			long supplyId = supplyVO.getSupplyId();
//			
//			for(BrowseCountVO browseCountVO : browseCountList){
//				
//				long supplyId2 = browseCountVO.getSupplyId();
//				
//				if(supplyId==supplyId2){
//					supplyVO.setBrowseCount(browseCountVO.getBrowseCount());
//				}
//			}
//		}
//		
//		return supplyList;
//	}
	
	/**
	 * 添加供应帖子的点击量和浏览记录
	 */
	@Transactional
	@Override
	public int addClickAndBrowse(Long supplyId,Long userId){
		
		Date now = new Date();
		
		Supply supply = supplyMapper.selectByPrimaryKey(supplyId);
		
		supply.setClicks(supply.getClicks()+1);			//增加帖子的点击量
		supply.setUpdatetime(now);
		
		Browse browse = new Browse();
		
		browse.setCreatetime(now);
		browse.setSupplyid(supplyId);
		browse.setType("supply");
		browse.setUserid(userId);
		browse.setUpdatetime(now);
		
		try{
			supplyMapper.updateByPrimaryKey(supply);	//增加帖子的点击量
			
			browseMapper.insert(browse);				//添加浏览记录
			
			return 2;
		}catch(Exception e){
			//throw new RuntimeException(); 			事务回滚方法一
			TransactionAspectSupport.currentTransactionStatus().setRollbackOnly();			//事务回滚方法二
			return 0;
		}
	}
	
	public int addSupply(Supply supply,String[] tagIdArr){
		
		Date now = new Date();
		
		supply.setClicks(0);
		supply.setCreatetime(now);
		supply.setStatus("checking");
		supply.setUpdatetime(now);
		 
		List<SupplyTagTemp> supplyTagTempList = new ArrayList<>();
		
		for(String tagIdStr : tagIdArr){
			SupplyTagTemp supplyTagTemp = new SupplyTagTemp();
			supplyTagTemp.setCreatetime(now);
			supplyTagTemp.setSupplyid(supply.getId());
			supplyTagTemp.setTagid(Long.valueOf(tagIdStr));
			supplyTagTempList.add(supplyTagTemp);
		}
		
		try{
			supplyMapper.insert(supply);
			
			supplyTagTempMapper.addSupplyTagTemp(supplyTagTempList);
			
			return 2;
		}catch(Exception e){
			//throw new RuntimeException(); 			事务回滚方法一
			TransactionAspectSupport.currentTransactionStatus().setRollbackOnly();			//事务回滚方法二
			return 0;
		}
		
	}
	
	
	public int updateSupply(Supply supply,String[] tagIdArr){
		
		Date now = new Date();
		
		supply.setClicks(0);
		supply.setCreatetime(now);
		supply.setStatus("checking");
		supply.setUpdatetime(now);
		 
		List<SupplyTagTemp> supplyTagTempList = new ArrayList<>();
		
		for(String tagIdStr : tagIdArr){
			SupplyTagTemp supplyTagTemp = new SupplyTagTemp();
			supplyTagTemp.setCreatetime(now);
			supplyTagTemp.setSupplyid(supply.getId());
			supplyTagTemp.setTagid(Long.valueOf(tagIdStr));
			supplyTagTempList.add(supplyTagTemp);
		}
		
		try{
			supplyMapper.updateByPrimaryKeySelective(supply);
			
			supplyTagTempMapper.addSupplyTagTemp(supplyTagTempList);
			
			return 2;
		}catch(Exception e){
			//throw new RuntimeException(); 			事务回滚方法一
			TransactionAspectSupport.currentTransactionStatus().setRollbackOnly();			//事务回滚方法二
			return 0;
		}
		
	}

}
