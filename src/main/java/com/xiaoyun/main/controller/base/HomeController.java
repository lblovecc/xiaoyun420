package com.xiaoyun.main.controller.base;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class HomeController {
	
	@RequestMapping(value="/index")
	public String toIndex(){
		return "/xiaoyun/tag/mng";
	}

}
