package com.god.web.zeus.interceptor;

import java.lang.reflect.Method;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.method.HandlerMethod;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.god.common.annotation.AuthValidate;
import com.god.common.bean.BaseOutput;
import com.god.common.constant.ResponseCode;
import com.god.dao.datasource.DataSourceHolder;
import com.god.dao.datasource.TargetDataSource;
import com.god.model.zeus.entity.GodResource;
import com.god.model.zeus.entity.GodUser;
import com.god.service.zeus.constant.ZeusConstants;

/**
 * 权限认证 拦截器
 * 
 * @author H__D
 *
 */
public class AuthInterceptor implements HandlerInterceptor {

	@Autowired
	private ObjectMapper objectMapper;

	private static final Logger log = LoggerFactory.getLogger(AuthInterceptor.class);

	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
			throws Exception {

		response.setHeader("Content-Type", "text/html;charset=UTF-8");
		request.setCharacterEncoding("UTF-8");

		if (handler instanceof HandlerMethod) {
			HandlerMethod myHandlerMethod = (HandlerMethod) handler;
			Object bean = myHandlerMethod.getBean();
			Method method = myHandlerMethod.getMethod();
			AuthValidate authValidate = null;
			if (method.isAnnotationPresent(AuthValidate.class)) {
				authValidate = method.getAnnotation(AuthValidate.class);
			} else if (bean.getClass().isAnnotationPresent(AuthValidate.class)){
				authValidate = bean.getClass().getAnnotation(AuthValidate.class);
			}
			if (authValidate != null) {
				String value = authValidate.value();
				List<GodResource> resourceList = ((List<GodResource>) request.getSession()
						.getAttribute(ZeusConstants.SESSION_CURRENT_RESOURCES));
				if (resourceList != null && resourceList.size() > 0) {
					for (GodResource resource : resourceList) {
						if (value.equals(resource.getUrl())) {
							return true;
						}
					}
				}
				// 无权限访问，请联系管理员
				if (isAjax(request)) {
					BaseOutput error = BaseOutput.ERROR(ResponseCode.AUTHORITY_NO_ACCESS.getCode(),
							ResponseCode.AUTHORITY_NO_ACCESS.getMsg());
					String str = objectMapper.writeValueAsString(error);
					// System.out.println(str);
					response.getWriter().print(str);
				} else {
					response.getWriter().print("<script>alert(\"无权限访问，请联系管理员\");</script>");
				}
				return false;
			}
		}
		return true;
	}

	private boolean isAjax(HttpServletRequest request) {
		String requestType = request.getHeader("X-Requested-With");
		if (requestType != null && requestType.equals("XMLHttpRequest")) {
			return true;
		}
		return false;
	}

	@Override
	public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler,
			ModelAndView modelAndView) throws Exception {
		// TODO Auto-generated method stub

	}

	@Override
	public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex)
			throws Exception {
		// TODO Auto-generated method stub

	}

}
