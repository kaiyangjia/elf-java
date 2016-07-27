package com.jiakaiyang.elf.java.crud;

import com.google.inject.Guice;
import com.google.inject.Injector;
import com.jiakaiyang.elf.java.crud.base.ConnectionContext;
import com.jiakaiyang.elf.java.crud.base.DBConfig;
import com.jiakaiyang.elf.java.crud.base.GuiceServiceMoudle;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.sql.Connection;
import java.util.Properties;

/**
 * Created by admin on 2016/7/26.
 */
public class App {
    public static void main(String[] args){
//        getConnection("jdbc.properties");
        getConnection("jdbcpostgres.properties");

    }

    private static Connection getConnection(String propertiesName){
        Properties properties = new Properties();
        String userDir = System.getProperty("user.dir");
        String jdbcPath = userDir + File.separator + "crud" + File.separator + propertiesName;
        try {
            properties.load(new FileInputStream(jdbcPath));
            DBConfig.dbProperties = properties;
        } catch (IOException e) {
            e.printStackTrace();
        }

        Injector injector = Guice
                .createInjector(new GuiceServiceMoudle());
        ConnectionContext connectionContext = injector.getInstance(ConnectionContext.class);
        Connection connection = connectionContext.getConnection();
        return connection;
    }
}
