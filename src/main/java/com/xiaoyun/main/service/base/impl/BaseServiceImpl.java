package com.xiaoyun.main.service.base.impl;

import com.github.pagehelper.PageHelper;
import com.xiaoyun.main.common.EasyUIPaginator;
import com.xiaoyun.main.common.Paginator;
import com.xiaoyun.main.service.base.BaseService;

import tk.mybatis.mapper.common.Mapper;

import java.util.List;

/**
 * 
 * @author Mr.LB
 *
 * @param <T>
 */
public abstract class BaseServiceImpl<T> implements BaseService<T> {

    public abstract Mapper<T> getMapper();

    @Override
    public T selectByKey(Object key) {
        return getMapper().selectByPrimaryKey(key);
    }

    @Override
    public T selectOne(T entity){
    	return getMapper().selectOne(entity);
    }

    @Override
    public int save(T entity) {
        return getMapper().insert(entity);
    }

    @Override
    public int delete(Object key) {
        return getMapper().deleteByPrimaryKey(key);
    }

    @Override
    public int updateAll(T entity) {
        return getMapper().updateByPrimaryKey(entity);
    }

    @Override
    public int updateNotNull(T entity) {
        return getMapper().updateByPrimaryKeySelective(entity);
    }

    @Override
    public List<T> selectPage(Paginator paginator) {
        PageHelper.startPage(paginator.getPageNumber(), paginator.getPageSize());
        return getMapper().selectAll();
    }

    @Override
    public List<T> selectPage(EasyUIPaginator paginator) {
        PageHelper.startPage(paginator.getPage(), paginator.getRows());
        return getMapper().selectAll();
    }

    @Override
    public List<T> selectPage(int pageNum,int pageSize) {
        PageHelper.startPage(pageNum, pageSize);
        return getMapper().selectAll();
    }

    @Override
    public List<T> selectPage(Paginator paginator, T entity) {
        PageHelper.startPage(paginator.getPageNumber(), paginator.getPageSize());
        return getMapper().select(entity);
    }

    @Override
    public List<T> selectPage(EasyUIPaginator paginator, T entity) {
        PageHelper.startPage(paginator.getPage(), paginator.getRows());
        return getMapper().select(entity);
    }

    @Override
    public List<T> selectPage(int pageNum, int pageSize, T entity) {
        PageHelper.startPage(pageNum, pageSize);
        return getMapper().select(entity);
    }
    
}
