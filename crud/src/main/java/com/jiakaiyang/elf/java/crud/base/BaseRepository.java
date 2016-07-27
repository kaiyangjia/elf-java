package com.jiakaiyang.elf.java.crud.base;

import com.google.inject.Inject;
import com.querydsl.core.types.Expression;
import com.querydsl.sql.Configuration;
import com.querydsl.sql.RelationalPath;
import com.querydsl.sql.SQLQuery;
import com.querydsl.sql.dml.SQLDeleteClause;
import com.querydsl.sql.dml.SQLInsertClause;
import com.querydsl.sql.dml.SQLUpdateClause;

import javax.sql.DataSource;
import java.sql.Connection;

/**
 * 数据的基本管理类
 */
public class BaseRepository<T> {
    @Inject
    private Configuration configuration;

    @Inject
    private ConnectionContext context;

    @Inject
    private DataSource datasource;

    private Connection getConnection() {
        return context.getConnection();
    }

    protected <T> SQLQuery<T> selectFrom(RelationalPath<T> entity) {
        return select(entity).from(entity);
    }

    protected <T> SQLQuery<T> select(Expression<T> entity) {
        return new SQLQuery<Void>(getConnection(), configuration).select(entity);
    }

    protected SQLInsertClause insert(RelationalPath<?> path) {
        return new SQLInsertClause(getConnection(), configuration, path);
    }

    protected SQLUpdateClause update(RelationalPath<?> path) {
        return new SQLUpdateClause(getConnection(), configuration, path);
    }

    protected SQLDeleteClause delete(RelationalPath<?> path) {
        return new SQLDeleteClause(getConnection(), configuration, path);
    }
}