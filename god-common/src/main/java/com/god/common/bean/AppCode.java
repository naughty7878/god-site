package com.god.common.bean;

public interface AppCode {

	public int getCode();

	public void setCode(int code);

	public String getMsg();

	public void setMsg(String msg);
	
	default boolean isSuccess(){
		return this.getCode() == 0;
	}
}
