package com.god.service.zeus.constant;

public class ZeusConstants {
	
	// 系统参数
	public final static String SYS_NAME = "GOD";
	
	// 系统初始密码
	public final static String SYS_INIT_PASSWORD = "123456";
	
	// 登录地址
	public final static String LOGIN_URL = "/login/toLogin";
	
	// Session中存储的当前登陆用户的key
    public static final String SESSION_CURRENT_LOGIN_USER = "currentLoginUser";
    
    // Session中存储的当前登陆用户登录验证次数
    public static final String SESSION_CURRENT_LOGIN_CHECK_NUM = "currentLoginCheckNum";
    
    // Session中存储的当前登陆用户日志的key
    public static final String SESSION_CURRENT_LOGIN_USER_LOG = "currentLoginUserLog";
}
