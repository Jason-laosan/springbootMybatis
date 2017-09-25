package com.springbootmybatis.config;

import com.alibaba.druid.filter.Filter;
import com.alibaba.druid.filter.stat.StatFilter;
import com.alibaba.druid.pool.DruidDataSource;
import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.SqlSessionFactoryBean;
import org.mybatis.spring.annotation.MapperScan;
import org.mybatis.spring.boot.autoconfigure.MybatisProperties;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.support.PathMatchingResourcePatternResolver;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by jinkai on 17/06/2017.
 */
@Configuration
//@MapperScan("com.springbootmybatis.mapper")
public class DBConfiguration {

    private static final Logger log = LoggerFactory.getLogger(DBConfiguration.class);


    @Autowired
    private DBProperties dbProperties;

    @Autowired
    private MybatisProperties mybatisProperties;


    @Bean(initMethod = "init", destroyMethod = "close")
    public DruidDataSource dataSource() throws SQLException {
        DruidDataSource dataSource = new DruidDataSource();
        dataSource.setDriverClassName(dbProperties.getDriverClassName());
        dataSource.setUrl(dbProperties.getUrl());
        dataSource.setUsername(dbProperties.getUsername());
        dataSource.setPassword(dbProperties.getPassword());
        dataSource.setInitialSize(Integer.parseInt(dbProperties.getInitialSize()));
        dataSource.setMinIdle(Integer.parseInt(dbProperties.getMinIdle()));
        dataSource.setMaxActive(Integer.parseInt(dbProperties.getMaxActive()));
        dataSource.setMaxWait(Long.parseLong(dbProperties.getMaxWait()));
        dataSource.setTimeBetweenEvictionRunsMillis(Long.parseLong(dbProperties.getTimeBetweenEvictionRunsMillis()));
        dataSource.setMinEvictableIdleTimeMillis(Long.parseLong(dbProperties.getMinEvictableIdleTimeMillis()));
        dataSource.setValidationQuery(dbProperties.getValidationQuery());
        dataSource.setTestWhileIdle(Boolean.parseBoolean(dbProperties.getTestWhileIdle()));
        dataSource.setTestOnBorrow(Boolean.parseBoolean(dbProperties.getTestOnBorrow()));
        dataSource.setTestOnReturn(Boolean.parseBoolean(dbProperties.getTestOnReturn()));
        dataSource.setPoolPreparedStatements(Boolean.parseBoolean(dbProperties.getPoolPreparedStatements()));
        dataSource.setMaxPoolPreparedStatementPerConnectionSize(Integer.parseInt(dbProperties.getMaxPoolPreparedStatementPerConnectionSize()));
        dataSource.setFilters(dbProperties.getFilters());

        //别名配置是通过filters属性配置的，filters属性的类型是String
        List<Filter> filters = new ArrayList<Filter>();
        filters.add(statFilter());
        dataSource.setProxyFilters(filters);

        return dataSource;
    }


    @Bean
    public SqlSessionFactory sqlSessionFactory() throws Exception {
        SqlSessionFactoryBean sqlSessionFactoryBean = new SqlSessionFactoryBean();
        sqlSessionFactoryBean.setDataSource(dataSource());
        PathMatchingResourcePatternResolver resolver = new PathMatchingResourcePatternResolver();
//        sqlSessionFactoryBean.setMapperLocations(resolver.getResources(dbProperties.getMapperLocations()));
        sqlSessionFactoryBean.setConfigLocation(resolver.getResource(mybatisProperties.getConfigLocation()));
        sqlSessionFactoryBean.setTypeAliasesPackage(dbProperties.getTypeAliasesPackage());
        return sqlSessionFactoryBean.getObject();
    }

    @Bean
    public PlatformTransactionManager platformTransactionManager() throws SQLException {
        return new DataSourceTransactionManager(dataSource());
    }

    //别名配置是通过filters属性配置的，filters属性的类型是String
    @Bean("stat-filter")
    public StatFilter statFilter(){
        StatFilter statFilter = new StatFilter();
        statFilter.setSlowSqlMillis(10000l);
        statFilter.setLogSlowSql(true);
        return statFilter;
    }

    @Bean("baseDao")
    public BaseDao getBaseDao() throws Exception {
        SqlSessionFactory sqlSessionFactory = null;
        try {
            sqlSessionFactory = sqlSessionFactory();
        } catch (Exception e) {
            log.error(e.getMessage());
            throw e;
        }
        return new BaseDao(sqlSessionFactory);
    }

}