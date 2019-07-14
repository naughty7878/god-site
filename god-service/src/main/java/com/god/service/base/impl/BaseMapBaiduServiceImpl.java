package com.god.service.base.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.god.manager.baidu.map.model.MapBaiduLocationResp;
import com.god.manager.baidu.map.service.MapBaiduService;
import com.god.service.base.BaseMapBaiduService;

@Service
public class BaseMapBaiduServiceImpl implements BaseMapBaiduService{
	
	@Autowired
	private MapBaiduService mapBaiduService;
	
	public String getCityByIp(String ip) {
		MapBaiduLocationResp locationByIp = mapBaiduService.getLocationByIp(ip);
		if(locationByIp == null || locationByIp.getStatus() != 0) {
			return null;
		}
		return locationByIp.getContent().getAddress_detail().getCity();
	}
	

}
