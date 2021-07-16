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
public class SedissonManage{
    private RedissonClient redissonClient;

    public SedissonManage(RedissonClient redissonClient) {
        this.redissonClient = redissonClient;
    }

    public RedissonClient getRedissonClient() {
        return this.redissonClient;
    }
}
