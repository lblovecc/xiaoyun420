package com.xiaoyun.main.service.base;

import java.util.List;

import com.xiaoyun.main.common.EasyUIPaginator;
import com.xiaoyun.main.common.Paginator;

/**
 * Created by Mr.LB
 */
public interface BaseService<T> {

    T selectByKey(Object key);
    
    T selectOne(T entity);

    int save(T entity);

    int delete(Object key);

    int updateAll(T entity);

    int updateNotNull(T entity);

    List<T> selectPage(Paginator paginator);

    List<T> selectPage(EasyUIPaginator paginator);

    List<T> selectPage(int pageNum, int pageSize);

    List<T> selectPage(Paginator paginator, T entity);

    List<T> selectPage(EasyUIPaginator paginator, T entity);

    List<T> selectPage(int pageNum, int pageSize, T entity);

}