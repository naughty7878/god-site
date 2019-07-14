package com.god.manager.baidu.map.model;

import java.io.Serializable;
import java.util.List;

public class MapBaiduDrivingResult implements Serializable {
	
	// 限行结果提示信息
	private String restriction;
	
	// 返回方案的总数
	private Integer total;
	
	// 驾驶线路集合
	private List<MapBaiduDrivingRoute> routes;

	public String getRestriction() {
		return restriction;
	}

	public void setRestriction(String restriction) {
		this.restriction = restriction;
	}

	public Integer getTotal() {
		return total;
	}

	public void setTotal(Integer total) {
		this.total = total;
	}

	public List<MapBaiduDrivingRoute> getRoutes() {
		return routes;
	}

	public void setRoutes(List<MapBaiduDrivingRoute> routes) {
		this.routes = routes;
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "MapDrivingResult [restriction=" + restriction + ", total=" + total + ", routes=" + routes + "]";
	}
	
	
	
	
	
}
