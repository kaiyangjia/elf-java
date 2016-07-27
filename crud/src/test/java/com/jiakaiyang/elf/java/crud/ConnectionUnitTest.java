package com.jiakaiyang.elf.java.crud;

import com.google.inject.Guice;
import com.google.inject.Injector;
import com.jiakaiyang.elf.java.crud.base.ConnectionContext;
import com.jiakaiyang.elf.java.crud.base.DBConfig;
import com.jiakaiyang.elf.java.crud.base.GuiceServiceMoudle;
import org.junit.Test;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.sql.Connection;
import java.util.Properties;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

/**
 *
 */
public class ConnectionUnitTest {
    @Test
    public void ConnCreateTest(){
        try {
            //在测试的环境中需要先加载类，否则会报ClassNotFound的异常
            getClass().getClassLoader().loadClass("org.postgresql.Driver");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        Properties properties = new Properties();
        String userDir = System.getProperty("user.dir");
        String jdbcPath = userDir + File.separator + File.separator + "jdbcpostgres.properties";
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
        boolean isNull = connection == null;
        assertFalse(isNull);
    }
}
