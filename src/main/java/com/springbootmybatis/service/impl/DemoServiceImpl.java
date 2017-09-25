package com.springbootmybatis.service.impl;

import com.alibaba.fastjson.JSONObject;
import com.springbootmybatis.config.BaseDao;
import com.springbootmybatis.config.PageList;
import com.springbootmybatis.entity.User;
import com.springbootmybatis.service.DemoService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional(readOnly = true)
public class DemoServiceImpl implements DemoService {
    private static final Logger log = LoggerFactory.getLogger(DemoServiceImpl.class);

    @Autowired
    private BaseDao baseDao;

    @Autowired
    private StringRedisTemplate redisTemplate;


    @Override
    public User getUser() {
        log.info("get user start");
        return baseDao.selectOne("UserMapper.getUser");

    }

    @Transactional(readOnly = false, propagation = Propagation.REQUIRED)
    @Override
    public boolean addUser(User user) {

        log.info("add user start");
        baseDao.insert("UserMapper.addUser", user);
        return true;
    }
    @Override
    public PageList<User> getUserPage(int pageIndex,int pageSize){
        log.info("getUserPage  start");
        return baseDao.queryForPageList("UserMapper.getUserPage", null, pageIndex, pageSize);
    }

    @Override
    public String redisDemo() {
        String value = null;
        value = redisTemplate.opsForValue().get("jinkai");
        return value;
    }
}
