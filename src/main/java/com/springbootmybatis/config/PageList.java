package com.springbootmybatis.config;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by jinkai on 09/07/2017.
 */
public class PageList<T> implements Serializable{
    private static final long serialVersionUID = -2949497622293336316L;
    private int start;
    private int currentPage;
    private int totalCount;
    private int pageSize;
    private List<T> records;

    public PageList() {
        this(0, 1, 0, 20, new ArrayList());
    }

    public PageList(int start, int currentPage, int totalCount, int pageSize, List<T> records) {
        this.start = 0;
        this.currentPage = 1;
        this.pageSize = 20;
        this.records = new ArrayList();
        this.start = start;
        this.currentPage = currentPage;
        this.totalCount = totalCount;
        this.pageSize = pageSize;
        this.records = records;
    }

    public int getStart() {
        return this.start;
    }

    public void setStart(int start) {
        this.start = start;
    }

    public List<T> getRecords() {
        return this.records;
    }

    public void setRecords(List<T> records) {
        this.records = records;
    }

    public void setCurrentPage(int currentPage) {
        if(currentPage < 1) {
            currentPage = 1;
        }

        this.currentPage = currentPage;
    }

    public int getCurrentPageNo() {
        return this.start / this.pageSize + 1;
    }

    public boolean hashNextPage() {
        return this.getCurrentPageNo() < this.getTotalPage();
    }

    public boolean hasPreviousPage() {
        return this.getCurrentPageNo() > 1;
    }

    public int getTotalPage() {
        return this.totalCount % this.pageSize == 0?this.totalCount / this.pageSize:this.totalCount / this.pageSize + 1;
    }

    public int getPageSize() {
        return this.pageSize;
    }

    public void setPageSize(int pageSize) {
        this.pageSize = pageSize;
    }

    public int getTotalCount() {
        return this.totalCount;
    }

    public void setTotalCount(int totalCount) {
        this.totalCount = totalCount;
    }

    public static int getStartOfPage(int pageNo, int pageSize) {
        return (pageNo - 1) * pageSize;
    }

    public int getPreviousPage() {
        return this.currentPage > 1?this.currentPage - 1:this.currentPage;
    }

    public int getNextPage() {
        return this.currentPage < this.getTotalPage()?this.currentPage + 1:-1;
    }

    public String toString() {
        return "PageList [start=" + this.start + ", currentPage=" + this.currentPage + ", totalCount=" + this.totalCount + ", pageSize=" + this.pageSize + ", records=" + this.records + "]";
    }
}
