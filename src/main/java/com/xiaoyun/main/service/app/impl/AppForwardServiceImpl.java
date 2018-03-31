package com.xiaoyun.main.service.app.impl;

import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.interceptor.TransactionAspectSupport;

import com.xiaoyun.main.mapper.ForwardMapper;
import com.xiaoyun.main.mapper.ViewChanceMapper;
import com.xiaoyun.main.model.Forward;
import com.xiaoyun.main.model.ViewChance;
import com.xiaoyun.main.service.app.AppForwardService;
import com.xiaoyun.main.service.app.AppViewChanceService;
import com.xiaoyun.main.service.base.impl.BaseServiceImpl;

import tk.mybatis.mapper.common.Mapper;

@Service
public class AppForwardServiceImpl extends BaseServiceImpl<Forward> implements AppForwardService {
	
	@Autowired
	private ForwardMapper forwardMapper;
	
	@Autowired
	private ViewChanceMapper viewChanceMapper;
	
	@Autowired
	private AppViewChanceService viewChanceService;

	@Override
	public Mapper<Forward> getMapper() {
		// TODO Auto-generated method stub
		return null;
	}
	
	@Override
	public int forwardSupplyOrBuy(Forward forward){
		
		Date date = new Date();
		
		ViewChance viewChance = new ViewChance();
		
		viewChance.setUserid(forward.getUserid());
		
		ViewChance selectViewChance = viewChanceService.selectOne(viewChance);
		
		try{
			
			if(null == selectViewChance){
				viewChance.setCreatetime(date);
				viewChance.setForwardcount(1);
				viewChance.setFreecount(3);
				viewChance.setMealcount(0);
				viewChance.setUpdatetime(date);
				viewChance.setUserid(forward.getUserid());
				
				viewChanceMapper.insert(viewChance);
			}else{
				selectViewChance.setForwardcount(selectViewChance.getForwardcount()+1);
				selectViewChance.setUpdatetime(date);
				
				viewChanceMapper.updateByPrimaryKeySelective(selectViewChance);
			}
			
			forwardMapper.insert(forward);
			
			return 2;
			
		}catch(Exception e){
			//throw new RuntimeException(); 			事务回滚方法一
			TransactionAspectSupport.currentTransactionStatus().setRollbackOnly();			//事务回滚方法二
			return 0;
		}
		
	}

}
