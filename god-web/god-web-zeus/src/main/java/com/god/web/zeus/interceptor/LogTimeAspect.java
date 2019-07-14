package com.god.web.zeus.interceptor;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.reflect.MethodSignature;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

/**
 * 执行方法时间切面
 * 基于SpringAOP 来监控各层中每个方法的执行时间 
 * 1、记录service层每个方法的执行时间 
 * 2、记录dao层每个方法的执行时间
 * 
 * @author H__D
 * @date 2019-07-09 23:52:41
 *
 */
@Aspect
@Component
public class LogTimeAspect {

	private static Logger log = LoggerFactory.getLogger("Excutor-InfoTime-Log");

	// service层的统计耗时切面，类型必须为final String类型的,注解里要使用的变量只能是静态常量类型的
	public static final String POINT_SERVICE = "execution(* com..service.*.*.*Impl.*(..))";
	
	// dao层的统计耗时切面
	public static final String POINT_DAO = "execution(* com..dao..*Dao.*(..))";
	
	/**
	 * 统计方法执行耗时Around环绕通知
	 * @param joinPoint
	 * @return
	 */
	@Around(POINT_SERVICE)
	public Object timeAroundService(ProceedingJoinPoint joinPoint) throws Throwable{
		return printExecTime(joinPoint);
	}
	
	@Around(POINT_DAO)
	public Object timeAroundDao(ProceedingJoinPoint joinPoint) throws Throwable{
		return printExecTime(joinPoint);
	}

	/**
	 * 打印方法执行耗时的信息
	 * @param methodName
	 * @param startTime
	 * @param endTime
	 * @throws Throwable 
	 */
	private Object printExecTime(ProceedingJoinPoint joinPoint) throws Throwable {
		// 定义返回对象、得到方法需要的参数
		Object obj = null;
		Object[] args = joinPoint.getArgs();
		long startTime = System.currentTimeMillis();

		obj = joinPoint.proceed(args);
		
		// 获取执行的方法名
		long endTime = System.currentTimeMillis();
		MethodSignature signature = (MethodSignature) joinPoint.getSignature();
		String methodName = signature.getDeclaringTypeName() + "." + signature.getName();

		long diffTime = endTime - startTime;
		log.info(methodName + "\t" + diffTime + "ms");
		
		return obj;
	}
}
