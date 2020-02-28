package com.god.manager.amap.service;

import com.god.manager.amap.model.AmapWeatherInfoResp;

/**
 * 高德地图服务类接口
 * @author H__D
 * @date 2019-12-14 08:36:00
 */
public interface AmapService {

    /**
     * 天气查询是一个简单的HTTP接口，根据用户输入的adcode，查询目标区域当前/未来的天气情况。
     * @param adcode
     */
    public abstract AmapWeatherInfoResp getWeatherInfo(String adcode);
}
