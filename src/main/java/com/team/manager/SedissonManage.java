package com.team.manager;

import org.redisson.api.RedissonClient;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.data.redis.core.RedisTemplate;

/**
 * @Classname SedissonManage
 * @Description TODO
 * @Date 2021/7/16 下午9:59
 * @Created by muyi
 */
public class SedissonManage  extends RedisTemplate {
    private static final Logger log = LoggerFactory.getLogger(SedissonManage.class);
    private RedissonClient redissonClient;
    private String PREFIX = "RDS_LOCK:" + System.getenv("project.name") + ":";

    public SedissonManage(RedissonClient redissonClient) {
        this.redissonClient = redissonClient;
    }

    public RedissonClient getRedissonClient() {
        return this.redissonClient;
    }
}
