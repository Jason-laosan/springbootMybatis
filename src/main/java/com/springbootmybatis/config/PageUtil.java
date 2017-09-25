package com.springbootmybatis.config;

/**
 * Created by jinkai on 09/07/2017.
 */
public class PageUtil {
    public PageUtil() {
    }

    public static int getOffset(int toPage, int pageSize) {
        if(toPage < 1) {
            toPage = 1;
        }

        if(pageSize < 0) {
            pageSize = 10;
        }

        return (toPage - 1) * pageSize;
    }
}
