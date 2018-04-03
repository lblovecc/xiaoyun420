package com.xiaoyun.main.service.app.impl;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.interceptor.TransactionAspectSupport;

import com.github.pagehelper.PageHelper;
import com.xiaoyun.main.common.EasyUIPaginator;
import com.xiaoyun.main.mapper.BuyMapper;
import com.xiaoyun.main.mapper.BuyTagTempMapper;
import com.xiaoyun.main.mapper.ViewChanceMapper;
import com.xiaoyun.main.mapper.ViewMapper;
import com.xiaoyun.main.model.Buy;
import com.xiaoyun.main.model.BuyTagTemp;
import com.xiaoyun.main.model.User;
import com.xiaoyun.main.model.View;
import com.xiaoyun.main.model.ViewChance;
import com.xiaoyun.main.model.vo.BuyVO;
import com.xiaoyun.main.service.app.AppBuyService;
import com.xiaoyun.main.service.base.impl.BaseServiceImpl;

import tk.mybatis.mapper.common.Mapper;

@Service
public class AppBuyServiceImpl extends BaseServiceImpl<Buy> implements AppBuyService {
	
	@Autowired
	private BuyMapper buyMapper;
	
	@Autowired
	private ViewMapper viewMapper;
	
	@Autowired
	private ViewChanceMapper viewChanceMapper;
	
	@Autowired
	private BuyTagTempMapper buyTagTempMapper;

	/**
	 * 获取求购帖子信息
	 */
	@Override
	public List<BuyVO> getBuyList(Map<String, Object> qryMap) {
		// TODO Auto-generated method stub
		return null;
	}

	/**
	 * 获取求购帖子列表
	 */
	@Override
	public List<BuyVO> getBuyList(Map<String, Object> qryMap, EasyUIPaginator paginator) {
		
		PageHelper.startPage(paginator.getPage(), paginator.getRows());
		
		List<BuyVO> buyList = buyMapper.getBuyList(qryMap);
		
		int pageNum = paginator.getPage();
		
		long nowMS = new Date().getTime();
		
		for(BuyVO buyVO : buyList){
			
			Date createTime = buyVO.getCreateTime();
			long createTimeMS = createTime.getTime();
			
			//信息发布头3天，显示【紧急】标签
			if((nowMS-createTimeMS)>(3*24*60*60*1000)){
				buyVO.setIsUrgency("none");
			}else{
				buyVO.setIsUrgency("show");
			}
			
			//如果不是前点击量不是top20,则不显示热门
			if(pageNum>2){
				buyVO.setIsHot("none");
			}else{
				buyVO.setIsHot("show");
			}
		}
		
		return buyList;
	}
	
	/**
	 * 检查是否可以查看
	 * @return
	 */
	public boolean checkCanView(Buy buy,User user,ViewChance selectViewChance){
		
		//先查看是否有免费机会
		int freeCount = selectViewChance.getFreecount();		//免费查看的次数
		int forwardCount = selectViewChance.getForwardcount();	//转发查看的次数
		int mealCount = selectViewChance.getMealcount();		//套餐查看的次数
		
		String viewType = "";
		
		if(freeCount>0){
			freeCount=freeCount-1;
			viewType="free";
			selectViewChance.setFreecount(freeCount);
		}else if(forwardCount>0){
			forwardCount=forwardCount-1;
			viewType="forward";
			selectViewChance.setForwardcount(forwardCount);
		}else if(mealCount>0){
			mealCount=mealCount-1;
			viewType="meal";
			selectViewChance.setMealcount(mealCount);
		}else{
			return false;
		}
		
		Date now = new Date();
		
		View view = new View();
		view.setBuyid(buy.getId());
		view.setCreatetime(now);
		view.setUpdatetime(now);
		view.setUserid(user.getId());
		view.setViewtype(viewType);

		selectViewChance.setUpdatetime(now);
		
		try{
			viewMapper.insert(view);									//添加查看记录
			
			viewChanceMapper.updateByPrimaryKey(selectViewChance);		//更新机会
			
			return true;
		}catch(Exception e){
			//throw new RuntimeException(); 			事务回滚方法一
			TransactionAspectSupport.currentTransactionStatus().setRollbackOnly();			//事务回滚方法二
			return false;
		}
	}
	
	@Override
	public int addBuy(Buy buy,String[] tagIdArr){
		
		Date now = new Date();
		
		buy.setClicks(0);
		buy.setCreatetime(now);
		buy.setStatus("checking");
		buy.setUpdatetime(now);
		
		try{
			buyMapper.insert(buy);
			
			List<BuyTagTemp> buyTagTempList = new ArrayList<>();
			
			for(String tagIdStr : tagIdArr){
				BuyTagTemp buyTagTemp = new BuyTagTemp();
				buyTagTemp.setCreatetime(now);
				buyTagTemp.setBuyid(buy.getId());
				buyTagTemp.setTagid(Long.valueOf(tagIdStr));
				buyTagTempList.add(buyTagTemp);
			}
			
			buyTagTempMapper.addBuyTagTemp(buyTagTempList);
			
			return 2;
		}catch(Exception e){
			//throw new RuntimeException(); 			事务回滚方法一
			TransactionAspectSupport.currentTransactionStatus().setRollbackOnly();			//事务回滚方法二
			return 0;
		}
		
	}
	
	@Override
	public int updateBuy(Buy buy,String[] tagIdArr){
		
		Date now = new Date();
		
		buy.setClicks(0);
		buy.setCreatetime(now);
		buy.setStatus("checking");
		buy.setUpdatetime(now);
		
		try{
			buyMapper.updateByPrimaryKeySelective(buy);
			
			List<BuyTagTemp> buyTagTempList = new ArrayList<>();
			
			for(String tagIdStr : tagIdArr){
				BuyTagTemp buyTagTemp = new BuyTagTemp();
				buyTagTemp.setCreatetime(now);
				buyTagTemp.setBuyid(buy.getId());
				buyTagTemp.setTagid(Long.valueOf(tagIdStr));
				buyTagTempList.add(buyTagTemp);
			}
			
			buyTagTempMapper.addBuyTagTemp(buyTagTempList);
			
			return 2;
		}catch(Exception e){
			//throw new RuntimeException(); 			事务回滚方法一
			TransactionAspectSupport.currentTransactionStatus().setRollbackOnly();			//事务回滚方法二
			return 0;
		}
		
	}

	@Override
	public Mapper<Buy> getMapper() {
		// TODO Auto-generated method stub
		return null;
	}
	
}
