package com.god.dao.datasource;

import java.lang.annotation.*;

@Target({ElementType.METHOD, ElementType.TYPE})
@Retention(RetentionPolicy.RUNTIME)
@Documented
public @interface TargetDataSource {
    
    String name() default TargetDataSource.GOD;
 
    public static String GOD = "dataSourceGod";
 
    public static String BASE = "dataSourceBase";
 
}
