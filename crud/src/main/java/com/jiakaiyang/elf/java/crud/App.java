package com.jiakaiyang.elf.java.crud;

import com.google.inject.Guice;
import com.google.inject.Injector;
import com.jiakaiyang.elf.java.crud.base.ConnectionContext;
import com.jiakaiyang.elf.java.crud.base.GuiceServiceMoudle;

import java.sql.Connection;

/**
 * Created by admin on 2016/7/26.
 */
public class App {
    private static final Injector injector = Guice
            .createInjector(new GuiceServiceMoudle());

    public static void main(String[] args){
        ConnectionContext connectionContext = injector.getInstance(ConnectionContext.class);
        Connection connection = connectionContext.getConnection();
        boolean isNull = connection == null;

    }
}
