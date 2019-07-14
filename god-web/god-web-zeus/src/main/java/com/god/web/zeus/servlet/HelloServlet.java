package com.god.web.zeus.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class HelloServlet extends HttpServlet{

	final static  Logger logger  =  LoggerFactory.getLogger(HelloServlet.class );
	
	/**
	 * 初始化
	 */
	@Override
	public void init() throws ServletException {
		logger.info("HttpServlet---init------");
		super.init();
	}
	
	/**
	 * 服务
	 */
	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		logger.info("HttpServlet---service------");
		resp.setContentType("text/html; charset=utf-8");
		resp.getWriter().print("HelloServlet" + "---你好---");
		// super.service(req, resp);
	}
	
	/**
	 * Get方法
	 */
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		logger.info("HttpServlet---doGet------");
		// super.doGet(req, resp);
	}
	
	/**
	 * Post方法
	 */
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		logger.info("HttpServlet---doPost------");
		// super.doPost(req, resp);
	}
	
	/**
	 * 销毁
	 */
	@Override
	public void destroy() {
		logger.info("HttpServlet---destroy------");
		super.destroy();
	}
	
}
