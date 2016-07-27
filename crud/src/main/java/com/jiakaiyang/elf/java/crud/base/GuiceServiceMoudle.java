package com.jiakaiyang.elf.java.crud.base;

import com.alibaba.druid.pool.DruidDataSource;
import com.google.inject.AbstractModule;
import com.google.inject.Provides;
import com.google.inject.Scopes;
import com.google.inject.Singleton;
import com.google.inject.name.Named;
import com.google.inject.name.Names;
import com.jiakaiyang.elf.java.crud.utils.DruidUtils;
import com.querydsl.sql.Configuration;
import com.querydsl.sql.MySQLTemplates;
import com.querydsl.sql.PostgreSQLTemplates;
import com.querydsl.sql.SQLTemplates;
import com.sun.org.glassfish.external.probe.provider.annotations.ProbeProvider;

import javax.sql.DataSource;
import java.util.Map;
import java.util.Properties;

/**
 * guice module
 */
public class GuiceServiceMoudle extends AbstractModule {
    @Override
    protected void configure() {
        Properties properties;
        properties = DBConfig.dbProperties;
        bind(Properties.class).annotatedWith(Names.named("properties")).toInstance(properties);
        bind(String.class).annotatedWith(Names.named("url")).toInstance(properties.getProperty("url"));
        for (Map.Entry<Object, Object> entry : properties.entrySet()) {
            bind(String.class).annotatedWith(Names.named((String)entry.getKey()))
                    .toInstance((String) entry.getValue());
        }

        bind(ConnectionContext.class).in(Scopes.SINGLETON);
    }

    @Provides
    @Singleton
    public DataSource dataSource(@Named("properties") Properties properties) {
        DruidDataSource druidDataSource = new DruidDataSource();
        druidDataSource.setConnectProperties(properties);
        DruidUtils.setConfigToDataSource(properties, druidDataSource);
        return druidDataSource;
    }

    @Provides
    @Singleton
    public Configuration dbConf(@Named("url") String url){
        if(url.contains("mysql")){
            return new Configuration(new MySQLTemplates());
        }else if(url.contains("postgresql")){
            return new Configuration(new PostgreSQLTemplates());
        }
        return new Configuration(new MySQLTemplates());
    }
}
