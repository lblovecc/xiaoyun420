package com.xiaoyun.main.common;

public class Paginator {
    private int pageSize = 10;
    private int pageNumber = 1;
    private String sortName;
    private String sortOrder;

    public int getPageSize() {
        return pageSize;
    }

    public Paginator setPageSize(int pageSize) {
        this.pageSize = pageSize;
        return this;
    }

    public int getPageNumber() {
        return pageNumber;
    }

    public Paginator setPageNumber(int pageNumber) {
        this.pageNumber = pageNumber;
        return this;
    }

    public String getSortName() {
        return sortName;
    }

    public Paginator setSortName(String sortName) {
        this.sortName = sortName;
        return this;
    }

    public String getSortOrder() {
        return sortOrder;
    }

    public Paginator setSortOrder(String sortOrder) {
        this.sortOrder = sortOrder;
        return this;
    }
}
