package com.xiaoyun.main.controller.base;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class HomeController {
	
	@RequestMapping(value="/login")
	public String login(){
		return "/login";
	}
	@RequestMapping(value="/index")
	public String toIndex(){
		return "/xiaoyun/index/mng";
	}
	@RequestMapping(value="/xiaoyun/user/mng")
	public String user(){
		return "/xiaoyun/user/mng";
	}
	@RequestMapping(value="/xiaoyun/role/mng")
	public String role(){
		return "/xiaoyun/role/mng";
	}
	@RequestMapping(value="/xiaoyun/menu/mng")
	public String menu(){
		return "/xiaoyun/menu/mng";
	}
	@RequestMapping(value="/xiaoyun/log/mng")
	public String log(){
		return "/xiaoyun/log/mng";
	}
	@RequestMapping(value="/xiaoyun/company/mng")
	public String company(){
		return "/xiaoyun/company/mng";
	}
	@RequestMapping(value="/xiaoyun/category/mng")
	public String category(){
		return "/xiaoyun/category/mng";
	}
	@RequestMapping(value="/xiaoyun/supply/mng")
	public String supply(){
		return "/xiaoyun/supply/mng";
	}@RequestMapping(value="/xiaoyun/buy/mng")
	public String buy(){
		return "/xiaoyun/buy/mng";
	}
	@RequestMapping(value="/xiaoyun/banner/mng")
	public String banner(){
		return "/xiaoyun/banner/mng";
	}
	@RequestMapping(value="/xiaoyun/order/mng")
	public String order(){
		return "/xiaoyun/order/mng";
	}
	@RequestMapping(value="/xiaoyun/tag/mng")
	public String tag(){
		return "/xiaoyun/tag/mng";
	}
	@RequestMapping(value="/xiaoyun/keyword/mng")
	public String keyword(){
		return "/xiaoyun/keyword/mng";
	}
	@RequestMapping(value="/xiaoyun/browse/mng")
	public String browse(){
		return "/xiaoyun/browse/mng";
	}
	@RequestMapping(value="/xiaoyun/collection/mng")
	public String collection(){
		return "/xiaoyun/collection/mng";
	}@RequestMapping(value="/xiaoyun/forward/mng")
	public String forward(){
		return "/xiaoyun/forward/mng";
	}
	@RequestMapping(value="/xiaoyun/click/mng")
	public String click(){
		return "/xiaoyun/click/mng";
	}

}
