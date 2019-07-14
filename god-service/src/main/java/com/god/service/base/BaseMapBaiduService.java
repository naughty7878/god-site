package com.god.service.base;

/**
 * 地图接口服务类
 * @author H__D
 * @date 2019-07-06 00:47:24
 *
 */
public interface BaseMapBaiduService {
	
	/**
	 * 根据IP获取城市名称
	 * @param ip
	 * @return
	 */
	public abstract String getCityByIp(String ip);
	

}
