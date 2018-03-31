package com.xiaoyun.base.web.interceptor;

import com.alibaba.fastjson.JSONObject;
import com.xiaoyun.base.excpetion.ExceptionMessage;
import com.xiaoyun.base.excpetion.ZjsException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.PrintWriter;
import java.util.HashSet;
import java.util.Set;

public class CommonInterceptor implements HandlerInterceptor {
    private static final Logger logger = LoggerFactory.getLogger(CommonInterceptor.class);
    private static Set<String> adminRoleIdSet  = new HashSet<>();
    private static Set<String> supplierRoleIdSet  = new HashSet<>();

    static {
        adminRoleIdSet.add("101");

        supplierRoleIdSet.add("201");
        supplierRoleIdSet.add("202");
        supplierRoleIdSet.add("203");
    }

    public boolean preHandle(HttpServletRequest request,
                             HttpServletResponse response, Object handler) throws Exception {
        return true;
    }


    public void postHandle(HttpServletRequest request,
                           HttpServletResponse response, Object handler,
                           ModelAndView modelAndView) throws Exception {

    }

    public void afterCompletion(HttpServletRequest request,
                                HttpServletResponse response, Object handler, Exception ex)
            throws Exception {
        JSONObject json = new JSONObject();
        if (ex != null) {
            json.put("flag", false);
            if (ex instanceof ZjsException) {
                json.put("result", "fail");
                String code = ((ZjsException) ex).getErrorCode();
                String message = ExceptionMessage.getMessage(code);
                json.put("errcode", code);
                json.put("errmsg", message);
            } else {
                json.put("errcode", "sys.error");
                json.put("errmsg", ExceptionMessage.getMessage("sys.error"));
                logger.error("系统异常：{}",ex);
            }
            response.setContentType("application/json;charset=UTF-8");
            response.setHeader("Pragma", "No-cache");
            response.setHeader("Cache-Control", "no-cache");
            response.setDateHeader("Expires", 0);
            PrintWriter out=null;
            try{
                out = response.getWriter();
                out.print(json.toJSONString());
                out.flush();
            }finally {
                out.close();
            }
        }
    }
}
