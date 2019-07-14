package com.god.manager.baidu.map.model;

import java.io.Serializable;

public class MapBaiduGeocodeResult implements Serializable {

	
	// 经纬度坐标
	private MapBaiduLongLat location;
	
	// 位置的附加信息，是否精确查找。1为精确查找，即准确打点；0为不精确，即模糊打点
	private Integer precise;
	
	// 可信度，描述打点准确度，大于80表示误差小于100m。该字段仅作参考，返回结果准确度主要参考precise参数
	private Integer confidence;
	
	// 能精确理解的地址类型
	private String level;


	public MapBaiduLongLat getLocation() {
		return location;
	}

	public void setLocation(MapBaiduLongLat location) {
		this.location = location;
	}

	public Integer getPrecise() {
		return precise;
	}

	public void setPrecise(Integer precise) {
		this.precise = precise;
	}

	public Integer getConfidence() {
		return confidence;
	}

	public void setConfidence(Integer confidence) {
		this.confidence = confidence;
	}

	public String getLevel() {
		return level;
	}

	public void setLevel(String level) {
		this.level = level;
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "MapGeocodeResponse [location=" + location + ", precise=" + precise
				+ ", confidence=" + confidence + ", level=" + level + "]";
	}
	
	
	
}
