package com.xiaoyun.main.controller.controller.app.forward;

import java.util.Date;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.alibaba.fastjson.JSONObject;
import com.xiaoyun.main.controller.base.AbstractBaseController;
import com.xiaoyun.main.model.Forward;
import com.xiaoyun.main.service.app.AppForwardService;

/**
 * 转发
 * @author Mr.LB
 *
 */
@Controller
@RequestMapping(value="/xiaochengxu")
public class AppForwardAction extends AbstractBaseController {
	
	@Autowired
	private AppForwardService forwardService;
	
	@RequestMapping(value="/forward_supply_or_buy")
	public JSONObject forwardSupplyOrBuy(HttpServletRequest request){
		
		String userId = request.getParameter("userId");
		
		String type = request.getParameter("type");
		
		String id = request.getParameter("id");
		
		Forward forward = new Forward();
		
		Date now = new Date();
		
		forward.setCreatetime(now);
		forward.setUserid(Long.valueOf(userId));
		forward.setUpdatetime(now);
		
		if(type.equals("supply")){
			
			forward.setSupplyid(Long.valueOf(id));
			forward.setType("supply");
			
		}else if(type.equals("buy")){
			
			forward.setBuyid(Long.valueOf(id));
			forward.setType("buy");
			
		}else{
			return getAppErrorJsonResult("1", "转发失败!");
		}
		
		int m = forwardService.forwardSupplyOrBuy(forward);
		
		if(m == 0){
			return getAppErrorJsonResult("1", "转发失败!"); 
		}else{
			return getAppJsonResult("转发成功!");
		}
	}

}
