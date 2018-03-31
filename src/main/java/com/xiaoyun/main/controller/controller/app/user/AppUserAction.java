package com.xiaoyun.main.controller.controller.app.user;

import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.alibaba.fastjson.JSONObject;
import com.xiaoyun.main.common.EasyUIPaginator;
import com.xiaoyun.main.controller.base.AbstractBaseController;
import com.xiaoyun.main.model.Address;
import com.xiaoyun.main.model.AuthCode;
import com.xiaoyun.main.model.Buy;
import com.xiaoyun.main.model.Supply;
import com.xiaoyun.main.model.vo.SupplyAndBuyVO;
import com.xiaoyun.main.model.User;
import com.xiaoyun.main.model.vo.UserVO;
import com.xiaoyun.main.service.app.AppAuthCodeService;
import com.xiaoyun.main.service.app.AppBuyService;
import com.xiaoyun.main.service.app.AppSupplyService;
import com.xiaoyun.main.service.app.AppUserService;

/**
 * 用户信息
 * @author Mr.LB
 *
 */

@Controller
@RequestMapping(value="/xiaochengxu")
public class AppUserAction extends AbstractBaseController{
	
	@Autowired
	private AppUserService userService;
	
	@Autowired
	private AppSupplyService appSupplyService ;
	
	@Autowired
	private AppBuyService buyService;
	
	@Autowired
	private AppAuthCodeService authCodeService;
	
	/**
	 * 修改用户信息
	 * @param user
	 * @param address
	 * @return
	 */
	@ResponseBody
	@RequestMapping(value="/update_user_info")
	public JSONObject updateUserInfo(User user,Address address,AuthCode authCode){
		
//		String mobile = authCode
		
		int m = userService.updateUserInfo(user, address);
		
		if(m==0){
			return getAppErrorJsonResult("1", "添加信息失败,请重新尝试!");
		}else{
			return getAppJsonResult();
		}
	}
	
	/**
	 * 获取用户信息
	 * @param userId
	 * @return
	 */
	@ResponseBody
	@RequestMapping(value="/get_user_info")
	public JSONObject getUserInfo(Long userId){
		
		Map<String,Object> qryMap = new HashMap<String,Object>();
		UserVO user = userService.getUserInfo(qryMap);
		
		return getAppJsonResult(user);
	}
	
	/**
	 * 获取供应和求购的联合信息(对应个人信息中的发布)
	 * @param request
	 * @param paginator
	 * @return
	 */
	@ResponseBody
	@RequestMapping(value="/get_supply_and_buy_list")
	public JSONObject getSupplyAndBuyList(Long userId,EasyUIPaginator paginator){
		
		Map<String,Object> qryMap = new HashMap<String,Object>();
		qryMap.put("userId", userId);
		
		List<SupplyAndBuyVO> supplyAndBuyList = userService.getSupplyAndBuyList(qryMap, paginator);
		
		return getAppJsonResult(supplyAndBuyList);
	}
	
	/**
	 * 刷新帖子(包含供应和转发,更新发布时间createTime)
	 * @param id
	 * @param type
	 * @return
	 */
	@RequestMapping({"/refresh_supply_or"})
	public JSONObject refreshSupplyOrBuy(Long id,String type){
		
		Date now = new Date();
		
		//供应帖子刷新
		if(type.equals("supply")){
			
			Supply supply = appSupplyService.selectByKey(id);
			
			supply.setCreatetime(now);
			supply.setUpdatetime(now);
			
			appSupplyService.updateNotNull(supply);
			
			
		}else if(type.equals("buy")){
			
			Buy buy = buyService.selectByKey(id);
			
			buy.setCreatetime(now);
			buy.setUpdatetime(now);
			
			buyService.updateNotNull(buy);
			
		}else{
			return getAppErrorJsonResult("1", "帖子刷新失败!");
		}
		
		return getAppJsonResult("刷新成功!");
	}

}
