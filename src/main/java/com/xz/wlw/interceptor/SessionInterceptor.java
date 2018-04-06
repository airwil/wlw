package com.xz.wlw.interceptor;

import com.xz.wlw.entity.Admin;
import com.xz.wlw.util.StringUtil;
import org.apache.log4j.Logger;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;


/**
 * 登录拦截器   springmvc
 *
 * @author ThinkPad
 */
public class SessionInterceptor extends HandlerInterceptorAdapter {
	private static final Logger logger = Logger.getLogger(SessionInterceptor.class);

	@Override
	public boolean preHandle(HttpServletRequest request,HttpServletResponse response, Object handler) throws Exception {
		try {
			logger.info("--------拦截器启动-------");
			//1、请求到登录页面 放行  
		    if(request.getServletPath().contains("/login")) { 
		    	logger.info("用户登录");
		        return true;  
		    }
		    
		    //2、检查session
			HttpSession session = request.getSession();
			Admin admin=(Admin) session.getAttribute("admin");
			if(admin!=null){
				//session中存在用户信息  放行
				if(!StringUtil.isEmpty(admin.getName())){
					return true;
				}
			}
			logger.info("拦截器----------用户未登录，无法操作，跳转至登录页面");
			response.sendRedirect(request.getContextPath()+"/login.jsp");
		}catch (Exception ex) {
			logger.info("------拦截器出错-----");
			return false;
		}
		return false;
	}
}
