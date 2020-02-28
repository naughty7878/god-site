package com.god.manager.amap.model;

import java.util.List;
import java.util.Map;

public class AmapWeatherInfoResp extends AmapResponse {

    // 返回结果总数目
    private Integer count;
    // 返回状态说明,10000代表正确
    private String infocode;
    // 实况天气数据信息
    private List<AmapWeatherLive> lives;
    // 预报天气信息数据
    private Map<String, Object> forecast;

    public Integer getCount() {
        return count;
    }

    public void setCount(Integer count) {
        this.count = count;
    }

    public String getInfocode() {
        return infocode;
    }

    public void setInfocode(String infocode) {
        this.infocode = infocode;
    }

    public List<AmapWeatherLive> getLives() {
        return lives;
    }

    public void setLives(List<AmapWeatherLive> lives) {
        this.lives = lives;
    }

    public Map<String, Object> getForecast() {
        return forecast;
    }

    public void setForecast(Map<String, Object> forecast) {
        this.forecast = forecast;
    }

    @Override
    public String toString() {
        return "AmapWeatherInfoResp{" +
                "count=" + count +
                ", infocode='" + infocode + '\'' +
                ", lives=" + lives +
                ", forecast=" + forecast +
                '}';
    }
}
