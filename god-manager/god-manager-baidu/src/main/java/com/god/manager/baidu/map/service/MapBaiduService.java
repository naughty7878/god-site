package com.god.manager.baidu.map.service;


import com.god.manager.baidu.map.model.MapBaiduDrivingResult;
import com.god.manager.baidu.map.model.MapBaiduGeocodeResult;
import com.god.manager.baidu.map.model.MapBaiduLocationResp;
import com.god.manager.baidu.map.model.MapBaiduLongLat;
import com.god.manager.baidu.map.model.MapBaiduResponse;



/**
 * 百度地图服务类接口
 * @author H__D
 * @date 2018-09-09 23:51:23
 *
 */
public interface MapBaiduService {
	
	
	/**
	 * 根据地址的地理编码
	 * 注意：
	 * 1、地址长度不能超过84个字节，及42个汉字
	 * 2、地址采用urlencode编码
	 * @param address 地址
	 * @return
	 */
	public abstract MapBaiduLocationResp getLocationByIp(String ip);
	
	
	/**
	 * 根据地址的地理编码
	 * 注意：
	 * 1、地址长度不能超过84个字节，及42个汉字
	 * 2、地址采用urlencode编码
	 * @param address 地址
	 * @return
	 */
	public abstract MapBaiduResponse<MapBaiduGeocodeResult> getGeocode(String address);
	
	
	
	/**
	 * 驾车路线规划
	 * @param originLng 起点经度
	 * @param originLat 起点纬度
	 * @param destinationLng 终点经度
	 * @param destinationLat 终点纬度
	 * @return
	 */
	public abstract MapBaiduResponse<MapBaiduDrivingResult> getDriving(double originLng, double originLat, double destinationLng, double destinationLat  );
	
	/**
	 * 驾车路线规划
	 * @param origin
	 * @param destination
	 * @return
	 */
	public abstract MapBaiduResponse<MapBaiduDrivingResult> getDriving(MapBaiduLongLat origin, MapBaiduLongLat destination );
	
	
}
