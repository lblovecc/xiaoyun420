package com.xiaoyun.main.controller.controller.app.tag;

import java.util.HashMap;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.alibaba.fastjson.JSONObject;
import com.xiaoyun.main.controller.base.AbstractBaseController;
import com.xiaoyun.main.model.Tag;
import com.xiaoyun.main.service.app.AppTagService;

/**
 * 标签信息
 * @author Mr.LB
 *
 */
@Controller
@RequestMapping(value="/xiaochengxu")
public class AppTagAction extends AbstractBaseController {
	
	@Autowired
	private AppTagService tagService;
	
	/**
	 * 获取标签列表
	 * @param request
	 * @return
	 */
	@ResponseBody
	@RequestMapping(value="/get_tag_list")
	public JSONObject getTagList(HttpServletRequest request){
		
		List<Tag> tagList = tagService.getTagList(new HashMap<String,Object>());
		
		Tag tag = new Tag();
		tag.setName("标签1");
		
		Tag tag1 = tagService.selectOne(tag);
		
		return getAppJsonResult(tag1);
	}

}
