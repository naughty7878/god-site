package com.god.web.zeus.aspect;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

import com.god.common.bean.BaseOutput;

/**
 * 登录业务 切面
 * @author H__D
 * @date 2019-08-07 23:31:42
 *
 */
@Aspect
@Component
public class LoginBusiAspect {
	
//	// login service 层的切面
//	public static final String POINT_LOGIN_SERVICE_SUCCESS = "execution(* com.god.service.zeus.impl.LoginServiceImpl.doLogin(..))";
//
//	
//	/**
//     * 在切点方法之后执行
//     * @param joinPoint
//     */
//    @AfterReturning(pointcut=POINT_LOGIN_SERVICE_SUCCESS, returning = "result")
//    public void afterReturning(JoinPoint joinPoint, BaseOutput result){
////    	System.out.println(result);
////        System.out.println("@After：切点方法之后执行.....");
//    }
}
