package com.xiaoyun.main.controller.controller.app.scheduled;

import java.util.Date;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import com.xiaoyun.main.mapper.ViewChanceMapper;
import com.xiaoyun.main.model.ViewChance;

@Component
public class ViewChanceInfoUpdateScheduled {
	
	@Autowired
	private ViewChanceMapper viewChanceMapper;
	
	Logger logger = Logger.getLogger(getClass());
	
	
	/**
	 * 每天00:00:00更新view_chance表中的freeCount=3
	 */
	@Scheduled(cron="0 0 0 * * ?")
	public void updateFreeCount(){
		
		logger.info("每天00:00:00更新view_chance表中的freeCount=3,start.........");
		
		viewChanceMapper.updateViewChanceForFreeCount();
		
		logger.info("每天00:00:00更新view_chance表中的freeCount=3,end.........");
	}
	
	
	/**
	 * 每天23:59:59更新view_chance表中的forwardCount=0
	 */
	@Scheduled(cron="59 59 23 * * ?")
	public void updateForwardCount(){
		
		logger.info("每天23:59:59更新view_chance表中的forwardCount=0,start.........");
		
		viewChanceMapper.updateViewChanceForForwardCount();
		
		logger.info("每天23:59:59更新view_chance表中的forwardCount=0,end.........");
	}
	
	/**
	 * 测试用的     每5秒执行一次   
	 */
//	@Scheduled(cron="0/5 * * * * ?")       
    public void actionTask(){     
		System.out.println("每5秒执行一次...............start");  
          
        ViewChance viewChance = new ViewChance();
        viewChance.setCreatetime(new Date());
        viewChance.setUserid((long)1);
        viewChance.setUpdatetime(new Date());
        
        viewChanceMapper.insert(viewChance);
        
        System.out.println("每5秒执行一次...............start");
    }

}
