package com.example.elasticjob;

import com.dangdang.ddframe.job.api.ShardingContext;
import com.dangdang.ddframe.job.api.simple.SimpleJob;
import org.springframework.stereotype.Component;

@Component
public class TestJobDemo implements SimpleJob {
    @Override
    public void execute(ShardingContext shardingContext) {
        System.out.println("aaaaa" + shardingContext.getShardingItem());
    }
}
