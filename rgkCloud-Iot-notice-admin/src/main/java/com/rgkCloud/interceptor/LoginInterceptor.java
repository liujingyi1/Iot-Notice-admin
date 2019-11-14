package com.rgkCloud.interceptor;

import java.io.IOException;
import java.util.Objects;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContext;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import com.alibaba.fastjson.JSON;
import com.rgkCloud.model.MUser;
import com.rgkCloud.service.IUserService;

/**
 *	 登录拦截器
 * 
 * @author xiaoke.xu
 *
 */
public class LoginInterceptor implements HandlerInterceptor {
	private Logger logger = LoggerFactory.getLogger(this.getClass());

	@Autowired
	private IUserService userService;
//	@Autowired
//	private RedisUtils<String> redisUtils;
	
	
	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws IOException {
		logger.info("----------LoginInterceptor------------");
		String uri = request.getRequestURI();
		logger.info("uri  : " + uri);
		
		// 从session中获取vId,如果没有，从oss获取
		HttpSession session = request.getSession();
		String vId = Objects.toString(session.getAttribute("vId"),"");
		
		if (StringUtils.isBlank(vId)) {
			SecurityContext context = SecurityContextHolder.getContext();
			logger.info(JSON.toJSONString(context));
			
			Authentication authentication = context.getAuthentication();
			String userName = Objects.toString(authentication.getPrincipal());
			logger.info("user name : "+userName);
			
			if (StringUtils.isNotBlank(userName) && !StringUtils.equalsAnyIgnoreCase(userName, "anonymousUser")) {
				MUser user = userService.getUserByName(userName);
				logger.info(JSON.toJSONString(user));
				if (user != null) {
					session.setAttribute("vId", user.getvId());
				}
			}
		}
		
		return true;
	}

	@Override
	public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler,
			ModelAndView modelAndView) throws Exception {
		HandlerInterceptor.super.postHandle(request, response, handler, modelAndView);
	}

	@Override
	public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex)
			throws Exception {
		// TODO Auto-generated method stub
		HandlerInterceptor.super.afterCompletion(request, response, handler, ex);
	}

//	private void writeResult(HttpServletResponse response, ReturnObject ro) {
//        try(OutputStream stream = response.getOutputStream();) {
//            stream.write(JSON.toJSONString(ro).getBytes("UTF-8"));
//        } catch (Exception e) {
//            e.printStackTrace();
//        }
//    }

}
