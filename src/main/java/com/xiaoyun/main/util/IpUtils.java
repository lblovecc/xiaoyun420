package com.xiaoyun.main.util;

import javax.servlet.http.HttpServletRequest;

import org.apache.commons.lang3.StringUtils;

public class IpUtils {
	
	public static ThreadLocal<String> ipHolder=new ThreadLocal<String>();
	
	public static String getRemortIP(HttpServletRequest request) {
		String ip = request.getHeader("x-forwarded-for");
		if (ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)) {
			ip = request.getHeader("Proxy-Client-IP");
		}
		if (ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)) {
			ip = request.getHeader("WL-Proxy-Client-IP");
		}
		if (ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)) {
			ip = request.getRemoteAddr();
		}
		if(ip != null && ip.length() > 0){
			String[] ipArray = ip.split(",");
			if (ipArray != null && ipArray.length > 1) {
				return ipArray[0];
			}
			return ip;
		}
		
		return "";
	}
	
	public static String get() {
        return ipHolder.get();
    }

	public static void clear(){
		ipHolder.remove();
	}

    public static void set(HttpServletRequest request) {
		String ip=getRemortIP(request);
        ipHolder.set(ip);
    }
    
    /** 
     * IpUtils工具类方法 
     * 获取真实的ip地址 
     * @param request 
     * @return 
     */  
    public static String getIpAddr(HttpServletRequest request) {  
        String ip = request.getHeader("X-Forwarded-For");  
        if(StringUtils.isNotEmpty(ip) && !"unKnown".equalsIgnoreCase(ip)){  
             //多次反向代理后会有多个ip值，第一个ip才是真实ip  
            int index = ip.indexOf(",");  
            if(index != -1){  
                return ip.substring(0,index);  
            }else{  
                return ip;  
            }  
        }  
        ip = request.getHeader("X-Real-IP");  
        if(StringUtils.isNotEmpty(ip) && !"unKnown".equalsIgnoreCase(ip)){  
           return ip;  
        }  
        return request.getRemoteAddr();  
    } 
	
}

