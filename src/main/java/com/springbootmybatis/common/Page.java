package com.springbootmybatis.common;

import java.io.Serializable;

public class Page <T> implements Serializable {
    private static final long serialVersionUID = 1006196379923093860L;
    public static final int TOTAL_DEFAULT = 0;
    public static final int LENGTH_DEFAULT = 10;
    public static final int PAGENUM_DEFAULT = 1;
    private long total = 0L;
    private long offset = 0L;
    private long length = 10L;
    private int page_num = 1;
    private T data;

    public Page() {
    }

    public long getTotal() {
        return this.total;
    }

    public void setTotal(long total) {
        this.total = total;
    }

    public long getOffset() {
        this.offset = (long)(this.page_num - 1) * this.length;
        return this.offset;
    }

    public long getLength() {
        return this.length;
    }

    public void setLength(long length) {
        this.length = length;
    }

    public int getPage_num() {
        return this.page_num;
    }

    public void setPage_num(int page_num) {
        this.page_num = page_num;
    }

    public T getData() {
        return this.data;
    }

    public void setData(T data) {
        this.data = data;
    }
}
