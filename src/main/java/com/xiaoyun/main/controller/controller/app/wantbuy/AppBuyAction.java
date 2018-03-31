package com.xiaoyun.main.controller.controller.app.wantbuy;

import java.util.Date;
import java.util.HashMap;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.alibaba.fastjson.JSONObject;
import com.xiaoyun.main.common.EasyUIPaginator;
import com.xiaoyun.main.controller.base.AbstractBaseController;
import com.xiaoyun.main.model.Address;
import com.xiaoyun.main.model.Buy;
import com.xiaoyun.main.model.User;
import com.xiaoyun.main.model.ViewChance;
import com.xiaoyun.main.model.vo.BuyVO;
import com.xiaoyun.main.service.app.AppBuyService;
import com.xiaoyun.main.service.app.AppUserService;
import com.xiaoyun.main.service.app.AppViewChanceService;

/**
 * 
 * @author Mr.LB
 * 
 * 获取求购帖子的信息
 *
 */

@Controller
@RequestMapping({"/xiaochengxu"})
public class AppBuyAction extends AbstractBaseController{
	
	@Autowired
	private AppBuyService buyService;
	
	@Autowired
	private AppViewChanceService viewChanceService;
	
	@Autowired
	private AppUserService userService;
	
	/**
	 * 获取求购帖子列表
	 * @param request
	 * @param response
	 * @param paginator
	 * @return
	 */
	@ResponseBody
	@RequestMapping({"/get_buy_list.do"})
	public JSONObject getBuyList(HttpServletRequest request, HttpServletResponse response,EasyUIPaginator paginator){
		
		List<BuyVO> buyVOList = buyService.getBuyList(new HashMap<String,Object>(), paginator);
		
		return getAppJsonResult(buyVOList);
		
	}
	
	/**
	 * 获取求购帖子列表
	 * @param request
	 * @param response
	 * @param paginator
	 * @return
	 */
//	@ResponseBody
//	@RequestMapping({"/get_buy_info.do"})
//	public JSONObject getBuyInfo(Long buyId,EasyUIPaginator paginator){
//		
//		List<BuyVO> buyVOList = buyService.getBuyList(new HashMap<String,Object>());
//		
//		return getAppJsonResult(buyVOList);
//		
//	}
	
	/**
	 * 点击免费查看按钮
	 * @param userId
	 * @return
	 */
	@ResponseBody
	@RequestMapping({"/click_free_view.do"})
	public JSONObject clickFreeView(Long userId,Long buyId){
		
		ViewChance viewChance = new ViewChance();
		
		viewChance.setUserid(userId);
		ViewChance selectViewChance = viewChanceService.selectOne(viewChance);
		
		if(null == selectViewChance){
			return getAppErrorJsonResult("1","您暂时没有免费查看的机会!");
		}else{
			
			Buy buy = buyService.selectByKey(buyId);
			
			User user = userService.selectByKey(buy.getUserid());
			
			boolean flag = buyService.checkCanView(buy, user, selectViewChance);
			
			if(!flag){				//不可以查看
				return getAppErrorJsonResult("1", "您暂时没有免费查看的机会!");
			}else{					//可以查看
				//获取手机号码
				String phone = user.getPhone();
				return getAppJsonResult(phone);
			}
		}
	}
	
	/**
	 * 
	 */
	@RequestMapping({"/add_buy.do"})
	public JSONObject addBuy(Buy buy,Address address){
		
		if(null == buy.getCategoryid1()){
			return getAppErrorJsonResult("1", "一级类目未选择");
		}
		
		if(null == buy.getCategoryid2()){
			return getAppErrorJsonResult("1", "二级类目未选择");
		}
		
		String title = buy.getTitle();
		if(null == title || title.equals("")){
			return getAppErrorJsonResult("1", "帖子标题未填写");
		}
		
		String detile = buy.getDetile();
		if(null == detile || detile.equals("")){
			return getAppErrorJsonResult("1", "帖子详细说明未填写");
		}
		
		Integer count = buy.getCount();
		if(null == count){
			return getAppErrorJsonResult("1", "数量未填写");
		}
		
		String unit = buy.getUnit();
		if(null == unit || unit.equals("")){
			return getAppErrorJsonResult("1", "规格未填写");
		}
		
		Date endTime = buy.getEndtime();
		if(null == endTime){
			return getAppErrorJsonResult("1", "截止时间未填写");
		}
		
		Long userId = buy.getUserid();
		if(null == userId){
			return getAppErrorJsonResult("1", "帖子发布人未知");
		}
		
		String tagIds = buy.getTagids();
		if(null == tagIds || tagIds.equals("")){
			return getAppErrorJsonResult("1", "未选择标签");
		}
		
		String[] tagIdArr = tagIds.split(",");
		
		int m = buyService.addBuy(buy, tagIdArr);
		
		if(m==0){
			return getAppErrorJsonResult("1", "帖子发布失败");
		}else{
			return getAppJsonResult("帖子发布成功!");
		}
		
	}

}
