package com.team.manager;

import org.redisson.api.RBucket;
import org.redisson.api.RedissonClient;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.data.redis.core.RedisTemplate;

import java.util.concurrent.TimeUnit;

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

    public void set(String key, Object value) {
        RBucket<Object> re = this.redissonClient.getBucket(key);
        re.set(value);
    }

    public void set(String key, Object value, long expire) {
        this.set(key, value, expire, TimeUnit.SECONDS);
    }

    public void set(String key, Object value, long expire, TimeUnit timeUnit) {
        RBucket<Object> re = this.redissonClient.getBucket(key);
        re.set(value, expire, timeUnit);
    }

    public <T> T get(String key) {
        RBucket<Object> re = this.redissonClient.getBucket(key);
        Object o = re.get();
        return o == null ? null : (T) o;
    }

    public Boolean delete(String k) {
        return this.redissonClient.getBucket(k).delete();
    }

}
