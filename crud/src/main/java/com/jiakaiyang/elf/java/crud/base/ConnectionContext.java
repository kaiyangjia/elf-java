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

    private final ThreadLocal<Connection> connectionHolder = new ThreadLocal<Connection>();

    @Inject
    public ConnectionContext(DataSource dataSource) {
        this.dataSource = dataSource;
    }

    public Connection getConnection(boolean create) {
        Connection connection = connectionHolder.get();
        if (!create || connection != null) {
            return connection;
        }
        try {
            connection = dataSource.getConnection();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        connectionHolder.set(connection);
        return connection;
    }

    public Connection getConnection() {
        return connectionHolder.get();
    }

    public void removeConnection() {
        connectionHolder.remove();
    }
}
