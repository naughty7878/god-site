package com.god.web.zeus.listen;

import java.io.File;

import javax.servlet.ServletContext;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;

import org.slf4j.LoggerFactory;

import ch.qos.logback.classic.LoggerContext;
import ch.qos.logback.classic.joran.JoranConfigurator;
import ch.qos.logback.core.joran.spi.JoranException;
import ch.qos.logback.core.util.StatusPrinter;
import ch.qos.logback.ext.spring.web.LogbackConfigListener;
import ch.qos.logback.ext.spring.web.WebLogbackConfigurer;

public class LogbackInitListener implements ServletContextListener{
	
	/**
	 *  当Servlet 容器启动Web 应用时调用该方法。在调用完该方法之后，容器再对Filter 初始化，
	 * 	并且对那些在Web 应用启动时就需要被初始化的Servlet 进行初始化。
	 */
	@Override
	public void contextInitialized(ServletContextEvent sce) {
		
		// 此值配置在tomcat的catalina.bat(catalina.sh)的JAVA_OPTS参数值(-Dconf=xxx)
		String systemConfigPath = System.getProperty("sys.conf.path");
		//如果为空设置为默认的
		if (systemConfigPath != null && systemConfigPath.trim().length() > 0) {

			String systemName = sce.getServletContext().getInitParameter("systemName");
			systemConfigPath = systemConfigPath + File.separatorChar + systemName;
		}
		// 设置系统配置文件
		setSysConfigLocation(systemConfigPath);
		// 设置日志配置文件
		setLogConfigLocation(sce.getServletContext(),systemConfigPath);
		
		//设置系统扩展文件路径
		setSystemExtendConfigLocation(sce.getServletContext(),systemConfigPath);
		
	}

	/**
	 * 当Servlet 容器终止Web 应用时调用该方法。在调用该方法之前，容器会先销毁所有的Servlet 和Filter 过滤器。
	 */
	@Override
	public void contextDestroyed(ServletContextEvent sce) {
		String systemConfigHome = System.getProperty("conf");// 此值配置在tomcat的catalina.bat(catalina.sh)的JAVA_OPTS参数值(-Dconf=xxx)
		
	}
	
	private void setSysConfigLocation(String systemConfigPath){
		String sysConfigFileName = "system.config.properties";
		
		//读取项目中classpath下的配置
		if((systemConfigPath != null && systemConfigPath.trim().length() > 0)){
			//读取外部的配置
			String systemConfigPropertiesLocation = systemConfigPath + File.separatorChar + sysConfigFileName;
			File configFile = new File(systemConfigPropertiesLocation);
			if(configFile != null && configFile.exists()){
				System.out.println("系统参数配置文件路径：" + systemConfigPropertiesLocation);
				// 绝对路径要加file: 前缀
				System.setProperty("SystemConfigPropertiesLocation",  "file:" + systemConfigPropertiesLocation);
				return;
			}
		}
		//读取默认的配置
		String defaultLocation = "classpath:zeus" + File.separatorChar + sysConfigFileName;
		System.out.println("系统参数配置文件路径：" + defaultLocation);
		System.setProperty("SystemConfigPropertiesLocation",defaultLocation);
	}
	
	/**
	 * 设置日志配置文件读取路径
	 * @param context
	 * @param systemConfigHome
	 */
	private void setLogConfigLocation(ServletContext context,String systemConfigPath){
		String logConfigFileName = "logback.xml";
		
		//读取项目中classpath下的配置
		if((systemConfigPath != null && systemConfigPath.trim().length() > 0)){
			//读取外部的配置
			String logConfigFile = systemConfigPath + File.separatorChar + logConfigFileName;
			File configFile = new File(logConfigFile);
			if(configFile != null && configFile.exists()){
				System.out.println("系统日志配置文件路径："+logConfigFile);
				initLogByOuterFile(logConfigFile);
				return;
			}
		}
		//读取默认的配置
		String defaultLocation = "classpath:zeus" + File.separatorChar + logConfigFileName;
		System.out.println("系统日志配置文件路径："+defaultLocation);
		initLogByDefaultConfig(context, defaultLocation);
	}
	/**
	 * 获取classpath下的日志文件
	 * @param context
	 * @param filePath
	 */
	private void initLogByDefaultConfig(ServletContext context,String filePath){
		context.setInitParameter(WebLogbackConfigurer.CONFIG_LOCATION_PARAM, filePath);
		WebLogbackConfigurer.initLogging(context);
	}
	/**
	 * 通过读取外部文件的方式初始化日志
	 * @param filePath
	 */
	private void initLogByOuterFile(String filePath){
		
		LoggerContext loggerContext = (LoggerContext) LoggerFactory.getILoggerFactory();
		JoranConfigurator configurator = new JoranConfigurator();
		configurator.setContext(loggerContext);
		loggerContext.reset();
		try {
			configurator.doConfigure(filePath);
		} catch (JoranException e) {
			System.out.println(String.format("Load logback config file error. Message: ", e.getMessage()));    
		}
		StatusPrinter.printInCaseOfErrorsOrWarnings(loggerContext);
	}
	
	/**
	 * 设置系统扩展的配置文件路径
	 * 具体实现由子类根据自己的业务逻辑
	 */
	protected void setSystemExtendConfigLocation(ServletContext context,String systemConfigHome){
		
	}
	

}
