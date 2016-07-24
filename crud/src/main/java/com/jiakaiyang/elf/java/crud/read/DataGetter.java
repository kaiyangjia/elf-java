package com.jiakaiyang.elf.java.crud.read;

import java.util.List;

/**
 * 获取数据库数据接口，定义标准的数据库获取操作
 */
public interface DataGetter<T> {

    /**
     * 以一个T对象作为查询条件，返回所有匹配的T对象
     * @param condition
     * @return
     */
    public List<T> get(T condition);


    /**
     * 返回T数据源中字段名为fieldName值为fieldValue的数据列表
     * @param fieldName
     * @param fieldValue
     * @return
     */
    public List<T> get(String fieldName, Object fieldValue);



    /**
     * 根据条件获取一个T的对象
     * @param condition
     * @return
     */
    public T getOne(T condition);
}
