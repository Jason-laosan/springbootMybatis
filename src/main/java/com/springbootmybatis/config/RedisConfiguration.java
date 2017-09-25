//package com.springbootmybatis.config;
//
//import com.alibaba.fastjson.JSONObject;
//import org.springframework.context.annotation.Bean;
//import org.springframework.context.annotation.Configuration;
//import org.springframework.data.redis.connection.jedis.JedisConnectionFactory;
//import org.springframework.data.redis.core.StringRedisTemplate;
//
//
//@Configuration
//public class RedisConfiguration {
//    @Bean
//    JedisConnectionFactory jedisConnectionFactory() {
//        JedisConnectionFactory jedisConnectionFactory = new JedisConnectionFactory();
//        jedisConnectionFactory.set
//        System.out.println(JSONObject.toJSONString(jedisConnectionFactory));
//        return jedisConnectionFactory;
//    }
//
//    @Bean
//    public StringRedisTemplate redisTemplate(){
//        StringRedisTemplate template = new StringRedisTemplate();
//        template.setConnectionFactory(jedisConnectionFactory());
//        System.out.println(JSONObject.toJSONString(template));
//        return template;
//    }
//
//}
