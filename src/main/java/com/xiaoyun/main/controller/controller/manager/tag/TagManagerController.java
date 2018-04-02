package com.xiaoyun.main.controller.controller.manager.tag;

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
import com.xiaoyun.main.model.Tag;
import com.xiaoyun.main.service.manager.TagService;
/**
 * 标签管理
 * @author Liar
 *
 */
@Controller
@RequestMapping("/tagManager")
public class TagManagerController extends AbstractBaseController {


	@Autowired
	private TagService tagService;
	/**
	 * 取得全部标签
	 * @param rquest
	 * @param content 判断是否传入标签类型type
	 * @param value type的值
	 * @return
	 */
	@RequestMapping("/getList")
	public JSONObject getList(HttpServletRequest rquest,String content ,String value,@ModelAttribute Paginator paginator){
		
		Map<String,Object> qryMap = new HashMap<>();
		List<Tag> list=null;
		if("null".equals(content)){
			list=tagService.getList(qryMap,paginator);
			return getJsonResult(list);
		}else{
			if("type".equals(content)){
				qryMap.put("type",value);
			}
			list=tagService.getList(qryMap,paginator);
			return getJsonResult(list);
		}
		
		
	}
	/**
	 * 标签添加
	 * @param rquest
	 * @param tag
	 * @return
	 */
	@RequestMapping("/add")
	public JSONObject add(HttpServletRequest rquest,Tag tag){
		int length= tagService.add(tag);
		return getJsonResult(length);
	}
	@RequestMapping("/delete")
	public JSONObject delete(HttpServletRequest rquest,long id){
		int length= tagService.delete(id);
		return getJsonResult(length);
	}
	@RequestMapping("/update")
	public JSONObject update(HttpServletRequest rquest,Tag tag){
		int length= tagService.update(tag);
		return getJsonResult(length);
	}
}
