package com.jiakaiyang.elf.java.crud.base;

import javax.inject.Inject;
import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.SQLException;

/**
 * 数据库连接
 */
public class ConnectionContext {
    private final DataSource dataSource;

    @Inject
    public ConnectionContext(DataSource dataSource) {
        this.dataSource = dataSource;
    }

    public Connection getConnection() {
        try {
            return dataSource.getConnection();
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return null;
    }
}
