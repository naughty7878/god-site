package com.god.web.zeus.interceptor;

import javax.servlet.http.HttpServletRequest;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.aspectj.lang.reflect.MethodSignature;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import com.fasterxml.jackson.databind.ObjectMapper;

/**
 * 统一请求响应切面
 * 
 * @author H__D
 * @date 2019-07-13 11:18:10
 *
 */
@Aspect
@Component
public class LogParamAspect {

	private static Logger log = LoggerFactory.getLogger("ParamInfo-Log");

	@Autowired
	private ObjectMapper objectMapper;
	
	// controller层的切面
	public static final String POINT_CONTROLLER = "@annotation(org.springframework.web.bind.annotation.RequestMapping)";

	
	/**
	 * Around环绕通知
	 * @param pjp
	 * @return
	 */
	@Around(POINT_CONTROLLER)
	public Object paremInfoAround(ProceedingJoinPoint pjp) throws Throwable {
		
		// String methodName = pjp.getSignature().getName();
		Object result = null;
		Object[] args = pjp.getArgs();
		
		HttpServletRequest request = ((ServletRequestAttributes) RequestContextHolder.getRequestAttributes()).getRequest();

		// 记录入参
		// 解析参数，可能异常
		try {
        	log.info(request.getServletPath() + "\nRequest Params：\n" + objectMapper.writerWithDefaultPrettyPrinter().writeValueAsString(args));
		} catch (Exception e) {
			log.info(request.getServletPath() + "\ntRequest Params：\n" + args);
		}
		result = pjp.proceed(args);
		
		// 记录出参
		log.info(request.getServletPath() + "\nResponse Result：\n" + objectMapper.writerWithDefaultPrettyPrinter().writeValueAsString(result));
		
		return result;
	}

	
}
