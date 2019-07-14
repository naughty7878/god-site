package com.god.common.util;


/**
 * 位置工具类
 * @author H__D
 * @date 2018-09-06 16:12:20
 *
 */
public class LocationUtils {

	// 地球半径
	private static double EARTH_RADIUS = 6378.137; 
    
	// 将用角度表示的角转换为近似相等的用弧度表示的角 
    private static double rad(double d) { 
        return d * Math.PI / 180.0; 
    }
      
    /** 
     * 通过经纬度获取距离(单位：千米) 
     * @param lng1  经度1 
     * @param lat1  纬度1 
     * @param lng2  经度2 
     * @param lat2  纬度2 
     * @return 
     */  
    public static double getLinearDistance(double lng1, double lat1, double lng2, double lat2)  
    {  
        double radLat1 = Math.toRadians(lat1);  
        double radLat2 = Math.toRadians(lat2);  
        double a = radLat1 - radLat2;  
        double b = Math.toRadians(lng1) - Math.toRadians(lng2);  
        double s = 2 * Math.asin(Math.sqrt(Math.pow(Math.sin(a/2),2) +   
         Math.cos(radLat1)*Math.cos(radLat2)*Math.pow(Math.sin(b/2),2)));  
        s = s * EARTH_RADIUS;  
        s = Math.round(s * 10000) / 10000d;  
        return s;  
    } 
    
    


      
    public static void main(String[] args) {
        //测试经纬度：117.11811  36.68484
        //测试经纬度2：117.00999000000002  36.66123
        System.out.println(getLinearDistance(117.11811,36.68484,127.00999,36.66123));
          
    }
      
}
