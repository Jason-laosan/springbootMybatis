package com.springbootmybatis.controller;

import com.alibaba.fastjson.JSONObject;
import com.springbootmybatis.common.CommonJsonResult;
import com.springbootmybatis.config.PageList;
import com.springbootmybatis.entity.User;
import com.springbootmybatis.service.DemoService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.stereotype.Controller;
import org.springframework.util.Assert;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * Created by jinkai on 17/06/2017.
 */
@Controller
public class TestController {
    private static final Logger log = LoggerFactory.getLogger(TestController.class);


    private static int i = 1;

    @Autowired
    private DemoService demoService;



    @RequestMapping("/")
    @ResponseBody
    public String test(@RequestParam(required = false, defaultValue = "1") int pageIndex,
                       @RequestParam(required = false, defaultValue = "5") int pagesize) {
        CommonJsonResult result = new CommonJsonResult();
        log.info("TestController / start: parameter:{pageIndex:   "+pageIndex+"pagesize:  "+pagesize+"}");
        PageList<User> userPageList =demoService.getUserPage(pageIndex,pagesize);
        result.addResultList(userPageList.getRecords());
        result.setPaging(userPageList.getTotalCount(),userPageList.getPageSize(),userPageList.getNextPage(),userPageList.hashNextPage());
//        return JSONObject.toJSONString(demoService.getUser());

        return JSONObject.toJSONString(result);
    }


    @RequestMapping("/add")
    @ResponseBody
    public String add() {
        User user = new User();
        user.setUsername("金凯"+i);
        i++;
        demoService.addUser(user);
        return "add";
    }

    @PostMapping("/redis/add")
    @ResponseBody
    public String redisAdd() {

        return demoService.redisDemo();
    }
}
