package com.jiakaiyang.elf.java.crud.utils;

import com.alibaba.druid.pool.DruidDataSource;

import java.sql.SQLException;
import java.util.Properties;

/**
 * Druid utils
 */
public class DruidUtils {

    public static void setConfigToDataSource(Properties properties, DruidDataSource druidDataSource){
        druidDataSource.setUrl(properties.getProperty("url"));
        druidDataSource.setDriverClassName(properties.getProperty("driverClassName"));
        druidDataSource.setUsername(properties.getProperty("username"));
        druidDataSource.setPassword(properties.getProperty("password"));
        druidDataSource.setMaxActive(Integer.valueOf(properties.getProperty("maxActive")));
        druidDataSource.setInitialSize(Integer.valueOf(properties.getProperty("initialSize")));
        druidDataSource.setMaxWait(Long.valueOf(properties.getProperty("maxWait")));
        druidDataSource.setMinIdle(Integer.valueOf(properties.getProperty("minIdle")));
        druidDataSource.setValidationQuery(properties.getProperty("validationQuery"));
        druidDataSource.setMaxOpenPreparedStatements(Integer.valueOf(properties.getProperty("maxOpenPreparedStatements")));
    }
}
