package com.god.manager.amap.service.impl;

import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.god.manager.amap.config.AmapConfig;
import com.god.manager.amap.model.AmapWeatherInfoResp;
import com.god.manager.amap.service.AmapService;
import com.god.manager.amap.util.AmapConnectUtils;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

public class AmapServiceImpl implements AmapService {

    //记录器
//    private Logger logger = LoggerFactory.getLogger(getClass());

    private final String KEY = "key";

    private final String OUTPUT= "output";

    private final String QUESTION_MARK = "?";

    // json 解析类
    private ObjectMapper objectMapper;


    public AmapServiceImpl() {
        objectMapper = new ObjectMapper();
        // 设置在反序列化时忽略在JSON字符串中存在，而在Java中不存在的属性
        objectMapper.disable(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES);
    }


    @Override
    public AmapWeatherInfoResp getWeatherInfo(String adcode) {

        Map<String, String> requestMap = new HashMap<String, String>();
        requestMap.put("city", adcode);
        requestMap.put(KEY, AmapConfig.KEY);
        requestMap.put(OUTPUT, AmapConfig.JSON);
        String resultStr = AmapConnectUtils.getMethod(AmapConfig.AMAP_WEATHER_INFO_URL + QUESTION_MARK + AmapConnectUtils.convertStringParamter(requestMap));

        AmapWeatherInfoResp weatherInfo = null;
        try {
            weatherInfo = objectMapper.readValue(resultStr,  AmapWeatherInfoResp.class);
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
//        System.out.println(resultStr);

        return weatherInfo;
    }

    public static void main(String[] args) {
        AmapServiceImpl amapService = new AmapServiceImpl();
        AmapWeatherInfoResp weatherInfo = amapService.getWeatherInfo("110000");
        System.out.println(weatherInfo);
    }
}
