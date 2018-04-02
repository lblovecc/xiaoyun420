package com.xiaoyun.main.controller.controller.manager.banner;


import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.alibaba.fastjson.JSONObject;
import com.xiaoyun.main.common.Paginator;
import com.xiaoyun.main.controller.base.AbstractBaseController;
import com.xiaoyun.main.model.Banner;
import com.xiaoyun.main.service.manager.BannerService;

@Controller
@RequestMapping("/bannerManager")
public class BannerManagerController extends AbstractBaseController {

	@Autowired
	private BannerService bannerService;
	
	
	
	/**
	 * 获取banner图的列表
	 * @param request
	 * @param response
	 * @return
	 */
	@ResponseBody
	@RequestMapping({"/getBannerList"})
	public JSONObject getBannerList(HttpServletRequest request, HttpServletResponse response,@ModelAttribute Paginator paginator){
		
		Map<String,Object> qryMap = new HashMap<>();
		List<Banner> advertList = bannerService.getBannerList(qryMap,paginator);
		return getJsonResult(advertList);
		
	}
	/**
	 * 更新bannner图
	 * @param request
	 * @param response
	 * @param banner
	 * @return
	 */
	@RequestMapping({"/update"})
	public JSONObject updateBanner(HttpServletRequest request, HttpServletResponse response,Banner banner){
		
		int length = bannerService.update(banner);
		return getJsonResult(length);
	}
	/**
	 *根据id 删除bannner图
	 * @param request
	 * @param response
	 * @param id
	 * @return
	 */
	@RequestMapping({"/delete"})
	public JSONObject deleteBanner(HttpServletRequest request, HttpServletResponse response,long id){
		
		int length = bannerService.delete(id);
		return getJsonResult(length);
	}
	
	/**
	 *添加bannner图
	 * @param request
	 * @param response
	 * @param id
	 * @return
	 */
	@RequestMapping({"/add"})
	public JSONObject addBanner(HttpServletRequest request, HttpServletResponse response,Banner banner){
		
		int length = bannerService.add(banner);
		return getJsonResult(length);
	}
	
	
}
