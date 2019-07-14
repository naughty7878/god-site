package com.god.common.bean;

import java.io.Serializable;

/***
 * 基本输出结果
 * 
 * @param <T>
 */
public class BaseOutput<T> implements Serializable{

	/**
	 * 成功返回
	 * 
	 * @param data
	 * @param      <T1>
	 * @return
	 */
	public static <T1> BaseOutput OK(T1 data) {
		return new BaseOutput<T1>(data);
	}

	/**
	 * 错误返回
	 * 
	 * @param code
	 * @param msg
	 * @return
	 */
	public static BaseOutput ERROR(int code, String msg) {
		return new BaseOutput(code, msg);
	}

	/**
	 * 响应编码
	 */
	private int code;

	/**
	 * 响应消息
	 */
	private String msg;

	/**
	 * 泛型数据
	 */
	private T data;

	public BaseOutput() {

	}

	public BaseOutput(T data) {
		this.code = 0;
		this.msg = "ok";
		this.data = data;
	}

	public BaseOutput(int code, String msg) {
		this.code = code;
		this.msg = msg;
		this.data = null;
	}

	public BaseOutput(int code, String msg, T data) {
		this.code = code;
		this.msg = msg;
		this.data = data;
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

	public T getData() {
		return data;
	}

	public void setData(T data) {
		this.data = data;
	}

}
