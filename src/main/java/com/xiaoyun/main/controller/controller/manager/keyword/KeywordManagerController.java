package com.xiaoyun.main.controller.controller.manager.keyword;


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
import com.xiaoyun.main.model.Keyword;
import com.xiaoyun.main.service.manager.KeywordService;
/**
 * keyword关键字
 * @author Liar
 *
 */
@Controller
@RequestMapping("/keywordManager")
public class KeywordManagerController extends AbstractBaseController {

	
	@Autowired
	private KeywordService keywordService;
	/**
	 * 查询所有的关键字,包含模糊查询
	 * @param request
	 * @return
	 */
	@RequestMapping("/getList")
	public JSONObject getKeywordList(HttpServletRequest request,String name,String value ,@ModelAttribute Paginator paginator){
		Map<String,Object> qryMap = new HashMap<>();
		List<Keyword> keywordList=null;
		if("null".equals(name)){
			keywordList=keywordService.getList(qryMap,paginator);
			return getJsonResult(keywordList);
		}else{
			qryMap.put("name", value);
			keywordService.getList(qryMap,paginator);
			return getJsonResult(keywordList);
		}
	}

	/**
	 * 更新keyword
	 * @param request
	 * @param 
	 * @return
	 */
	@RequestMapping("/update")
	public JSONObject update(HttpServletRequest request,Keyword keyword){
		
		int length=keywordService.update(keyword);
		return getJsonResult(length);
		
	}
	/**
	 * 删除关键字
	 * @param request
	 * @param id
	 * @return
	 */
	@RequestMapping("/delete")
	public JSONObject delete(HttpServletRequest request,long id){
		
		int length=keywordService.delete(id);
		return getJsonResult(length);
	}
	/**
	 *新增关键字
	 * @param request
	 * @param keyword
	 * @return
	 */
	@RequestMapping("/add")
	public JSONObject add(HttpServletRequest request,Keyword keyword){
		int length=keywordService.add(keyword);
		return getJsonResult(length);
	}
	
}
