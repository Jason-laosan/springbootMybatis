package com.springbootmybatis.config;

import lombok.Data;
import org.springframework.boot.autoconfigure.AutoConfigureBefore;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

/**
 * Created by jinkai on 17/06/2017.
 */
@Component
@ConfigurationProperties(prefix = "spring.datasource")
@Data
public class DBProperties {
    private String url;
    private String username;
    private String password;
    private String driver;
    private String initialSize;
    private String minIdle;
    private String maxActive;
    private String maxWait;
    private String timeBetweenEvictionRunsMillis;
    private String minEvictableIdleTimeMillis;
    private String validationQuery;
    private String testWhileIdle;
    private String testOnBorrow;
    private String testOnReturn;
    private String poolPreparedStatements;
    private String maxPoolPreparedStatementPerConnectionSize;
    private String filters;
    private String typeAliasesPackage;
    private String mapperLocations;


    private String driverClassName;


}
