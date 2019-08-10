package com.god.web.zeus.aspect;

import java.lang.reflect.Method;

import org.springframework.aop.AfterReturningAdvice;
import org.springframework.aop.MethodBeforeAdvice;

import com.god.dao.datasource.DataSourceHolder;
import com.god.dao.datasource.TargetDataSource;

public class DataSourceAspect implements MethodBeforeAdvice, AfterReturningAdvice {

	@Override
	public void afterReturning(Object returnValue, Method method, Object[] args, Object target) throws Throwable {
		DataSourceHolder.clearDataSource();
	}

	@Override
	public void before(Method method, Object[] args, Object target) throws Throwable {
		if (method.isAnnotationPresent(TargetDataSource.class)) {
			TargetDataSource datasource = method.getAnnotation(TargetDataSource.class);
			DataSourceHolder.setDataSource(datasource.name());
		} else {
			if(target.getClass().isAnnotationPresent(TargetDataSource.class))
            {
				TargetDataSource datasource = target.getClass().getAnnotation(TargetDataSource.class);
				DataSourceHolder.setDataSource(datasource.name());
            }
		}
	}
}
