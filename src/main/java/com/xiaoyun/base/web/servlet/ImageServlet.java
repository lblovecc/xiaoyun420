package com.xiaoyun.base.web.servlet;

import javax.servlet.ServletException;
import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.xiaoyun.main.util.VerifyCodeCreatUtil;

import java.io.IOException;
import java.util.HashMap;

public class ImageServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;

    public void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        doPost(request, response);
    }

    public void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        /* 鍒涘缓浜岃繘鍒剁殑杈撳嚭娴� */
        ServletOutputStream sos = response.getOutputStream();
        HashMap<String, Object> map = VerifyCodeCreatUtil.getInstance().getVerifyCode();
        String sRand = (String) map.get("sRand");
        request.getSession().setAttribute("yzmCode", sRand);
        byte[] b = (byte[]) map.get("bImage");

        /* 灏嗙敓鎴愮殑瀛楃涓插瓨鍌ㄥ湪cookie涓� */
        // CookieUtils.fillRandomCode(request,response, sRand,
        // getCookiePath(request),CookieUtils.COOKIE_MAX_AGE_CURRENTSESSION);
        /* 绂佹鍥惧儚缂撳瓨 */

        response.setHeader("Pragma", "No-cache");
        response.setHeader("Cache-Control", "no-cache");
        response.setDateHeader("Expires", 0);
        response.setContentType("image/jpeg");

        sos.write(b);
        sos.flush();
        sos.close();
        return;
    }

    public String getCookiePath(HttpServletRequest request) {
        String path = request.getContextPath();
        // logger.info("path="+path);
        if ("".equals(path)) {
            path = "/";
        }
        return path;
    }
}
