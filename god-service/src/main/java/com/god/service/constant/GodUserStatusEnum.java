package com.god.service.constant;

public enum GodUserStatusEnum {
	

	USER_UNAVAILABLE(0, "禁用"),
	USER_AVAILABLE(1, "可用");
	
	private int code;
	private String msg;
	
	
	private GodUserStatusEnum(int code, String msg){
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
		for (GodUserStatusEnum type : GodUserStatusEnum.values()) {
			if (code == type.getCode()) {
				return type.msg;
			}
		}
		return null;
	}
	
	public static GodUserStatusEnum getGodUserStatusCode(int code) {
		for (GodUserStatusEnum type : GodUserStatusEnum.values()) {
			if (code == type.getCode()) {
				return type;
			}
		}
		return null;
	}

}
