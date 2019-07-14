package com.god.web.zeus.interceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.god.common.bean.BaseOutput;
import com.god.common.constant.ResponseCode;
import com.god.model.zeus.entity.GodUser;
import com.god.service.zeus.constant.ZeusConstants;

/**
 * 登录校验拦截器
 * @author H__D
 *
 */
public class LoginInterceptor implements HandlerInterceptor {
	
	@Autowired 
	private ObjectMapper objectMapper;

	private static final Logger log = LoggerFactory.getLogger(LoginInterceptor.class);

	/** 
     * preHandle方法是进行处理器拦截用的，顾名思义，该方法将在Controller处理之前进行调用，
     * SpringMVC中的Interceptor拦截器是链式的，可以同时存在多个Interceptor，
     * 然后SpringMVC会根据声明的前后顺序一个接一个的执行，而且所有的Interceptor中的preHandle方法都会在 
     * Controller方法调用之前调用。SpringMVC的这种Interceptor链式结构也是可以进行中断的，
     * 这种中断方式是令preHandle的返回值为false，
     * 当preHandle的返回值为false的时候整个请求就结束了。 
     */  
	@Override
	public boolean preHandle(HttpServletRequest request,
			HttpServletResponse response, Object arg2) throws Exception {

		log.info("User-Agent:" + request.getHeader("User-Agent"));
		response.setHeader("Content-Type", "text/html;charset=UTF-8");
		request.setCharacterEncoding("UTF-8");
		
		// 登录校验 标识
		boolean chk = true;
		String methodType = request.getMethod();;
		if("GET".equals(methodType)){
			log.info("GET 请求：" + request.getContextPath() + request.getServletPath());
		}else if("POST".equals(methodType)){
			log.info("POST 请求：" + request.getContextPath() + request.getServletPath());
		}
		
		// 登录信息
		GodUser godUser = (GodUser) request.getSession().getAttribute(ZeusConstants.SESSION_CURRENT_LOGIN_USER);
		
		if (godUser == null ) {
			chk = false;
			// 未登录 跳转到对应页面
			if("GET".equals(methodType)){
				StringBuffer redirectUrl = new StringBuffer();
				redirectUrl.append(request.getContextPath());
				redirectUrl.append(ZeusConstants.LOGIN_URL);
				// 跳转到登陆地址
				response.sendRedirect(redirectUrl.toString());
			}else if("POST".equals(methodType)){
				BaseOutput error = BaseOutput.ERROR(ResponseCode.AUTHORITY_NO_LOGIN.getCode(), ResponseCode.AUTHORITY_NO_LOGIN.getMsg());
				String str = objectMapper.writeValueAsString(error);
				// System.out.println(str);
		    	response.getWriter().print(str);
			}
		}
		return chk;
	}
	
	/** 
     * 这个方法只会在当前这个Interceptor的preHandle方法返回值为true的时候才会执行。
     * postHandle是进行处理器拦截用的，它的执行时间是在处理器进行处理之后，
     * 也就是在Controller的方法调用之后执行，但是它会在DispatcherServlet进行视图的渲染之前执行，
     * 也就是说在这个方法中你可以对ModelAndView进行操作。
     */ 
	@Override
	public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler,
			ModelAndView modelAndView) throws Exception {
		// TODO Auto-generated method stub
		
	}
	
	/** 
     * 该方法也是需要当前对应的Interceptor的preHandle方法的返回值为true时才会执行。
     * 该方法将在整个请求完成之后，也就是DispatcherServlet渲染了视图执行， 
     * 这个方法的主要作用是用于清理资源的
     * 当然这个方法也只能在当前这个Interceptor的preHandle方法的返回值为true时才会执行。 
     */  
	@Override
	public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex)
			throws Exception {
		// TODO Auto-generated method stub
		
	}

}
