package com.xiaoyun.main.controller.controller.app.yunzhixun;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.Random;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.google.gson.Gson;
import com.xiaoyun.main.controller.base.AbstractBaseController;
import com.xiaoyun.main.model.AuthCode;
import com.xiaoyun.main.service.app.AppAuthCodeService;
import com.xiaoyun.main.util.HttpTool;
import com.xiaoyun.main.util.InitSystem;

/**
 * 手机验证码
 * @author Mr.LB
 *
 */
@Controller
@RequestMapping(value="/xiaochengxu")
public class MobileVerificationCodeAction extends AbstractBaseController {
	
	Logger logger = Logger.getLogger(MobileVerificationCodeAction.class);
	
	@Autowired
	private AppAuthCodeService authCodeService;
	
	/**
	 * 获取短信验证码
	 * @param tele
	 * @param request
	 * @throws Exception
	 */
	@RequestMapping("/get_mobile_verificationCode")
	public void getMobileVerificationCode(String tele,HttpServletRequest request) throws Exception{
		
		Random random = new Random();
		int num = random.nextInt(8999);
		num = num+1000;
		logger.info("您的验证码为=======>"+num);
		
		Map<String, String> map=new HashMap<String, String> ();
		map.put("phoneNum",tele);
		map.put("code", num+"");
		map.put("modelId","21997");
		HttpTool.sendPost(InitSystem.getProperties("messageUrl")+"/call/sendSMS.do", new Gson().toJson(map).toString());

        final HttpSession session = request.getSession(true); 
        session.setAttribute("yanzhnum", num+"");//手机验证码
        
        AuthCode authCode = new AuthCode();
        
        authCode.setCode(String.valueOf(num));
        authCode.setCreatetime(new Date());
        authCode.setMobile(tele);
        
        authCodeService.save(authCode);
	}

}
