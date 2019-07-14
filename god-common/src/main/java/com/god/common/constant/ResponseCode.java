package com.god.common.constant;

import com.god.common.bean.AppCode;

/**
 * 响应码
 * 类别划分			code		msg		data		描述说明		编辑日期		编辑人	
正常响应        	0                                
用户权限问题    	100～200    权限问题
数据权限问题    	200～400    数据权限问题  
程序异常问题    	400～500    程序异常问题   
参数异常问题    	500～700    参数异常问题 
 * @author H__D
 * @date 2019-07-03 01:41:21
 *
 */
public enum ResponseCode implements AppCode{
	
	AUTHORITY_NO_LOGIN(101, "未登录"),
	AUTHORITY_USER_ERROR_PWD(102, "用户名或密码错误"),
	AUTHORITY_USER_UNAVAILABLE(103, "用户已禁用"),
	DATA_NO_AUTHORITY(2011, "无数据权限");
	
	private int code;
	private String msg;
	
	
	private ResponseCode(int code, String msg){
		this.code = code;
		this.msg = msg;
	}

	public int getCode() {
		return code;
	}

	public void setCode(int code) {
		this.code = code;
	}

	public String getMsg() {
		return msg;
	}

	public void setMsg(String msg) {
		this.msg = msg;
	}
	
	public String toString() {
		return Integer.toString(this.code);
	}

	public static String getMsg(int code) {
		for (ResponseCode type : ResponseCode.values()) {
			if (code == type.getCode()) {
				return type.msg;
			}
		}
		return null;
	}
	
	public static ResponseCode getResponseCode(int code) {
		for (ResponseCode type : ResponseCode.values()) {
			if (code == type.getCode()) {
				return type;
			}
		}
		return null;
	}
	
}
