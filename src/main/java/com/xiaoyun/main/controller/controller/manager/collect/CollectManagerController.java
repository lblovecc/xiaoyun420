package com.xiaoyun.main.controller.controller.manager.collect;


import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.alibaba.fastjson.JSONObject;
import com.xiaoyun.main.controller.base.AbstractBaseController;
import com.xiaoyun.main.model.Collect;
import com.xiaoyun.main.service.manager.CollectService;
/**
 * 收藏
 * @author Liar
 *
 */
@Controller
@RequestMapping("/collectManager")
public class CollectManagerController extends AbstractBaseController {

	@Autowired
	private CollectService collectService;
	
	
	@RequestMapping("/getList")
	public JSONObject getTagList(HttpServletRequest request, HttpServletResponse response){
		
		List<Collect> collectlist=collectService.getCollectList();
		return getJsonResult(collectlist);
	}

}
