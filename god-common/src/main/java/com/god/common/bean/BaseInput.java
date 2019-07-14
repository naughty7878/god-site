package com.god.common.bean;

import java.io.Serializable;
import java.util.Map;

/**
 * 基本输入参数
 */
public class BaseInput<T> implements Serializable{

	/**
	 * 泛型数据
	 */
	private T data;

	/**
	 * 扩展数据，字典类型key-value结构
	 */
	private Map<String, Object> extra;

	public T getData() {
		return data;
	}

	public void setData(T data) {
		this.data = data;
	}

	public Map<String, Object> getExtra() {
		return extra;
	}

	public void setExtra(Map<String, Object> extra) {
		this.extra = extra;
	}

}
