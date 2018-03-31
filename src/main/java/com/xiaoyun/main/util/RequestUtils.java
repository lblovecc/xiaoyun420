package com.xiaoyun.main.util;

import org.springframework.web.util.WebUtils;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class RequestUtils
{
	public static Cookie getCookie(HttpServletRequest request, String cookieName)
	{
		return WebUtils.getCookie(request, cookieName);
	}
	
	public static void removeCookie(HttpServletResponse response, String cookieName)
	{
		Cookie cookie = new Cookie(cookieName, null);
		cookie.setMaxAge(0);
		cookie.setPath("/");
		response.addCookie(cookie);
	}
	
	public static String getRemoteAddr(HttpServletRequest request)
	{
		
		//对于nginx 适用
		String ip = request.getHeader("x-real-ip");
		
		
		if(ip == null || ip.equals(""))
		{
			ip = request.getRemoteAddr();
		}
		return ip ;
	}
	
	/**
	 * 设置cookie
	 * @param response
	 * @param name  cookie名字
	 * @param value cookie值
	 * @param maxAge cookie生命周期  以秒为单位
	 */
	public static void addCookie(HttpServletResponse response,String name,String value,int maxAge){
	    Cookie cookie = new Cookie(name,value);
	    cookie.setPath("/");
	    cookie.getPath();
	    if(maxAge>0)  cookie.setMaxAge(maxAge);
	    response.addCookie(cookie);
	}
}
