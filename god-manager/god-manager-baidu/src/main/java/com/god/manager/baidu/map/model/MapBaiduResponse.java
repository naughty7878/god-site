package com.god.manager.baidu.map.model;

import java.io.Serializable;

public class MapBaiduResponse<T> implements Serializable{
	
	// 返回结果状态值， 成功返回0，其他值请查看下方返回码状态表。
	private Integer status;
	
	// 信息
	private String message;
	
	// 返回的结果
	private T result;

	public Integer getStatus() {
		return status;
	}

	public void setStatus(Integer status) {
		this.status = status;
	}

	public T getResult() {
		return result;
	}

	public void setResult(T result) {
		this.result = result;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "MapResponse [status=" + status + ", message=" + message + ", result=" + result + "]";
	}


	
}
