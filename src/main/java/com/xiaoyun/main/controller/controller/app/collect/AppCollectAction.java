package com.xiaoyun.main.controller.controller.app.collect;

import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.alibaba.fastjson.JSONObject;
import com.xiaoyun.main.common.EasyUIPaginator;
import com.xiaoyun.main.controller.base.AbstractBaseController;
import com.xiaoyun.main.model.Collect;
import com.xiaoyun.main.model.vo.CollectVO;
import com.xiaoyun.main.service.app.AppCollectService;
import com.xiaoyun.main.service.app.AppUserService;

/**
 * 收藏
 * @author Mr.LB
 *
 */
@Controller
@RequestMapping(value="/xiaochengxu")
public class AppCollectAction extends AbstractBaseController {
	
	@Autowired
	private AppCollectService collectService;
	
	@Autowired
	private AppUserService userService;
	
	/**
	 * 收藏帖子
	 * @param request
	 * @return
	 */
	@RequestMapping(value="/add_collect")
	private JSONObject addCollect(HttpServletRequest request){
		
		String id = request.getParameter("id");
		
		String userId = request.getParameter("userId");
		
		String type = request.getParameter("type");			//类型   supply或者buy
		
		Collect collect = new Collect();
		collect.setUserid(Long.valueOf(userId));
		
		Date now = new Date();
		collect.setCreatetime(now);
		collect.setUpdatetime(now);
		
		if(type.equals("supply")){
			
			collect.setSupplyid(Long.valueOf(id));
			collect.setCollecttype("supply");
			
		}else if(type.equals("buy")){
			
			collect.setBuyid(Long.valueOf(id));
			collect.setCollecttype("buy");
			
		}else{
			return getAppErrorJsonResult("1", "收藏类型不正确");
		}
		
		collectService.save(collect);
		
		return getAppJsonResult("收藏成功!");
	}
	
	/**
	 * 获取收藏列表(包含供应和求购)
	 * @param request
	 * @return
	 */
	@RequestMapping(value="/get_collect_list")
	public JSONObject getCollectList(HttpServletRequest request,EasyUIPaginator paginator){
		
		Map<String,Object> qryMap = new HashMap<>();
		
		String userId = request.getParameter("userId");
		
		qryMap.put("userId", userId);
		
		List<CollectVO> collectList = userService.getCollectList(qryMap, paginator);
		
		return getAppJsonResult(collectList);
		
	}

}
