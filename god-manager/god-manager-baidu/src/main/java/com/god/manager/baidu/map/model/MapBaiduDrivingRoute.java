package com.god.manager.baidu.map.model;

import java.io.Serializable;

/**
 * 驾驶路线对象
 * @author H__D
 * @date 2018-09-07 17:42:38
 *
 */
public class MapBaiduDrivingRoute implements Serializable{
	
	// 起点
	private MapBaiduLongLat origin;
	// 终点
	private MapBaiduLongLat destination;
	// 方案标签
	private String tag;
	// 方案距离，单位：米
	private Double distance;
	// 线路耗时，单位：秒
	private Integer duration;
	public MapBaiduLongLat getOrigin() {
		return origin;
	}
	public void setOrigin(MapBaiduLongLat origin) {
		this.origin = origin;
	}
	public MapBaiduLongLat getDestination() {
		return destination;
	}
	public void setDestination(MapBaiduLongLat destination) {
		this.destination = destination;
	}
	public String getTag() {
		return tag;
	}
	public void setTag(String tag) {
		this.tag = tag;
	}
	public Double getDistance() {
		return distance;
	}
	public void setDistance(Double distance) {
		this.distance = distance;
	}
	public Integer getDuration() {
		return duration;
	}
	public void setDuration(Integer duration) {
		this.duration = duration;
	}
	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "MapDrivingRoute [origin=" + origin + ", destination=" + destination + ", tag=" + tag + ", distance="
				+ distance + ", duration=" + duration + "]";
	}
	
	
}
