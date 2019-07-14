package com.god.manager.baidu.map.model;

import java.io.Serializable;

public class MapBaiduLocationResp implements Serializable{
	
	// 返回结果状态值， 成功返回0，其他值请查看下方返回码状态表。
	private Integer status;
	
	// 地址信息
	private String address;
	
	// 返回的结果
	private MapBaiduLocationContent content;

	public Integer getStatus() {
		return status;
	}

	public void setStatus(Integer status) {
		this.status = status;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public MapBaiduLocationContent getContent() {
		return content;
	}

	public void setContent(MapBaiduLocationContent content) {
		this.content = content;
	}

	@Override
	public String toString() {
		return "MapBaiduLocationResp [status=" + status + ", address=" + address + ", content=" + content + "]";
	}
	
	

}
