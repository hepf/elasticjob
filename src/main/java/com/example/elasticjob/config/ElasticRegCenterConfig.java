package com.example.elasticjob.config;

import com.dangdang.ddframe.job.reg.zookeeper.ZookeeperConfiguration;
import com.dangdang.ddframe.job.reg.zookeeper.ZookeeperRegistryCenter;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ElasticRegCenterConfig {

    /**
     * 配置zookeeper
     *
     * @param serverList
     * @param namespace
     * @return
     */
    @Bean(initMethod = "init")
    public ZookeeperRegistryCenter regCenter(
            @Value("${elastic-job.registry-center.address}") final String serverList,
            @Value("${elastic-job.registry-center.namespace}") final String namespace) {
        return new ZookeeperRegistryCenter(new ZookeeperConfiguration(serverList, namespace));
    }
}

