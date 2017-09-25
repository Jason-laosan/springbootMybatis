package com.springbootmybatis.service;

import com.springbootmybatis.config.PageList;
import com.springbootmybatis.entity.User;

public interface DemoService {
    User getUser();

    boolean addUser(User use);

    PageList<User> getUserPage(int pageIndex, int pageSize);
    String redisDemo();
}
