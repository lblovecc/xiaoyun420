package com.xiaoyun.main.controller.controller.manager.buy;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

import com.alibaba.fastjson.JSONObject;
import com.xiaoyun.main.common.Paginator;
import com.xiaoyun.main.controller.base.AbstractBaseController;
import com.xiaoyun.main.model.vo.BuyVO;
import com.xiaoyun.main.service.manager.BuyService;

@Controller
@RequestMapping("/buyManager")
public class BuyManagerController extends AbstractBaseController {

	@Autowired
	private BuyService buyService;
	
	/**
	 * 取得求购列表
	 * @param request
	 * @param paginator
	 * @return
	 */
	@RequestMapping("/getList")
	public JSONObject getList(HttpServletRequest request,@ModelAttribute  Paginator paginator){
		Map<String,Object> qryMap=new HashMap<>();
		
		List<BuyVO> buyList=buyService.getList(qryMap, paginator);
		
		return getJsonResult(buyList);
	}
	/**
	 * 删除求购
	 * @param request
	 * @param id
	 * @return
	 */
	@RequestMapping("/delete")
	public  JSONObject delete(HttpServletRequest request,long id){
		
		int length=	buyService.delete(id);
		
		return getJsonResult(length);
	}
	
}
