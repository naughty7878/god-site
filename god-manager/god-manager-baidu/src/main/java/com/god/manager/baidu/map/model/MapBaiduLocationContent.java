package com.god.manager.baidu.map.model;

import java.io.Serializable;

public class MapBaiduLocationContent implements Serializable{
	
	// 地址详情
	private MapBaiduAddressDetail address_detail;
	
	// 地址信息
	private String address;
	
	// 经纬度
	private MapBaiduLongLat point;

	public MapBaiduAddressDetail getAddress_detail() {
		return address_detail;
	}

	public void setAddress_detail(MapBaiduAddressDetail address_detail) {
		this.address_detail = address_detail;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public MapBaiduLongLat getPoint() {
		return point;
	}

	public void setPoint(MapBaiduLongLat point) {
		this.point = point;
	}

	@Override
	public String toString() {
		return "MapBaiduLocationContent [address_detail=" + address_detail + ", address=" + address + ", point=" + point
				+ "]";
	}

	
	
}
