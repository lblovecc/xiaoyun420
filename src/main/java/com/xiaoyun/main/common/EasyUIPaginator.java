package com.xiaoyun.main.common;

import java.io.Serializable;

public class EasyUIPaginator implements Serializable, Cloneable {
    private static final long serialVersionUID = 3688506614705500725L;
    private String orderBy;
    private int page = 1;//当前页数
    private int rows = 10;//每页记录数

    public String getOrderBy() {
        return orderBy;
    }

    public EasyUIPaginator setOrderBy(String orderBy) {
        this.orderBy = orderBy;
        return this;
    }

    public int getPage() {
        return page;
    }

    public void setPage(int page) {
        this.page = page;
    }

    public int getRows() {
        return rows;
    }

    public void setRows(int rows) {
        this.rows = rows;
    }
}
