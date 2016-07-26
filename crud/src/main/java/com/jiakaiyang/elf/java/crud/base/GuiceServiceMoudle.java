package com.jiakaiyang.elf.java.crud.base;

import com.alibaba.druid.pool.DruidDataSource;
import com.google.inject.AbstractModule;
import com.google.inject.Provides;
import com.google.inject.Scopes;
import com.google.inject.Singleton;
import com.google.inject.name.Named;
import com.google.inject.name.Names;
import com.jiakaiyang.elf.java.crud.utils.DruidUtils;

import javax.sql.DataSource;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Map;
import java.util.Properties;

/**
 * guice module
 */
public class GuiceServiceMoudle extends AbstractModule {
    @Override
    protected void configure() {
        Properties properties = new Properties();
        try {
            String userDir = System.getProperty("user.dir");
            String jdbcPath = userDir + File.separator + "crud" + File.separator + "jdbc.properties";
            properties.load(new FileInputStream(jdbcPath));
            bind(Properties.class).annotatedWith(Names.named("properties")).toInstance(properties);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
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
}
