package com.xiaoyun.main.controller.controller.app.banner;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.alibaba.fastjson.JSONObject;
import com.xiaoyun.main.controller.base.AbstractBaseController;
import com.xiaoyun.main.model.Banner;
import com.xiaoyun.main.service.app.AppBannerService;

/**
 * 
 * @author Mr.LB
 * 
 * 首页banner的信息
 *
 */

@Controller
@RequestMapping({"/xiaochengxu"})
public class AppBannerAction extends AbstractBaseController{
	
	@Autowired
	private AppBannerService bannerService;
	
	/**
	 * 获取banner图的列表,根据地图定位的城市来进行选择
	 * @param request
	 * @param response
	 * @return
	 */
	@ResponseBody
	@RequestMapping({"/get_banner_list.do"})
	public JSONObject getBannerInfo(HttpServletRequest request, HttpServletResponse response){
		
		Map<String,Object> qryMap = new HashMap<>();
		
		String city = request.getParameter("city");
		qryMap.put("city", city);
		
		List<Banner> advertList = bannerService.getBannerList(qryMap);
		
		return getAppJsonResult(advertList);
		
	}

}
