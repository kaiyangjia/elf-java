package com.jiakaiyang.elf.java.crud;

import com.google.inject.Guice;
import com.google.inject.Injector;
import com.jiakaiyang.elf.java.crud.base.ConnectionContext;
import com.jiakaiyang.elf.java.crud.base.GuiceServiceMoudle;
import org.junit.Test;

import static org.junit.Assert.assertTrue;

/**
 *
 */
public class ConnectionUnitTest {
    private static final Injector injector = Guice
            .createInjector(new GuiceServiceMoudle());

    @Test
    public void ConnCreateTest(){
        ConnectionContext connectionContext = injector.getInstance(ConnectionContext.class);
        assertTrue(connectionContext != null);
    }
}
