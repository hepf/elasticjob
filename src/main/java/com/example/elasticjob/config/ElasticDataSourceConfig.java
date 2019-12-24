package com.example.elasticjob.config;

import com.alibaba.druid.pool.DruidDataSource;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.sql.DataSource;
import java.sql.SQLException;

@Configuration
public class ElasticDataSourceConfig {

    @Value("${elastic-job.datasource.url}")
    private String dbUrl;

    @Value("${elastic-job.datasource.username}")
    private String username;

    @Value("${elastic-job.datasource.password}")
    private String password;

    @Value("${elastic-job.datasource.driver-class-name}")
    private String driverClassName;

    @Value("${elastic-job.datasource.initialSize}")
    private int initialSize;

    @Value("${elastic-job.datasource.minIdle}")
    private int minIdle;

    @Value("${elastic-job.datasource.maxActive}")
    private int maxActive;

    @Value("${elastic-job.datasource.maxWait}")
    private int maxWait;

    @Value("${elastic-job.datasource.timeBetweenEvictionRunsMillis}")
    private int timeBetweenEvictionRunsMillis;

    @Value("${elastic-job.datasource.minEvictableIdleTimeMillis}")
    private int minEvictableIdleTimeMillis;

    @Value("${elastic-job.datasource.validationQuery}")
    private String validationQuery;

    @Value("${elastic-job.datasource.testWhileIdle}")
    private boolean testWhileIdle;

    @Value("${elastic-job.datasource.testOnBorrow}")
    private boolean testOnBorrow;

    @Value("${elastic-job.datasource.testOnReturn}")
    private boolean testOnReturn;

    @Value("${elastic-job.datasource.filters}")
    private String filters;

    @Value("${elastic-job.datasource.logSlowSql}")
    private String logSlowSql;

    @Bean(name = "taskDataSource")
    public DataSource taskDataSource() {
        DruidDataSource datasource = new DruidDataSource();
        datasource.setUrl(dbUrl);
        datasource.setUsername(username);
        datasource.setPassword(password);
        datasource.setDriverClassName(driverClassName);
        datasource.setInitialSize(initialSize);
        datasource.setMinIdle(minIdle);
        datasource.setMaxActive(maxActive);
        datasource.setMaxWait(maxWait);
        datasource.setTimeBetweenEvictionRunsMillis(timeBetweenEvictionRunsMillis);
        datasource.setMinEvictableIdleTimeMillis(minEvictableIdleTimeMillis);
        datasource.setValidationQuery(validationQuery);
        datasource.setTestWhileIdle(testWhileIdle);
        datasource.setTestOnBorrow(testOnBorrow);
        datasource.setTestOnReturn(testOnReturn);
        try {
            datasource.setFilters(filters);
        } catch (SQLException e) {
//            log.error("druid configuration initialization filter", e);
        }
        return datasource;
    }
}

