package com.springbootmybatis;

import java.util.Date;

/**
 * Created by jinkai on 07/07/2017.
 */
public class Mytest {
    public static void main(String[] args) {
        Date now = new Date();
        long exp = (now.getTime() + 129600000L) / 1000L;
        System.out.println(129600000L/(1000*60*60*24));
    }
}
