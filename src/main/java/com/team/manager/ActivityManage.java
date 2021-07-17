package com.team.manager;

import com.team.common.constant.constant;
import org.apache.rocketmq.client.producer.DefaultMQProducer;
import org.redisson.api.RAtomicLong;
import org.redisson.api.RedissonClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * @Classname ActivityManage
 * @Description TODO
 * @Date 2021/7/16 下午11:56
 * @Created by muyi
 */
@Component
public class ActivityManage {
    @Autowired
    private SedissonManage sedissonManage;

    @Autowired
    private DefaultMQProducer defaultMQProducer;

    /**
     * 初始化库存
     * @param activityNum
     * @param num
     */
    public void initActivityInventory(Integer activityNum,Long num){
        RedissonClient redissonClient = sedissonManage.getRedissonClient();
        RAtomicLong atomicLong = redissonClient.getAtomicLong(getActivityNumKey(activityNum));
        atomicLong.set(num);
    }

    /**
     * 查询库存
     * @param activityNum
     * @return
     */
    public Long getActivityInventory(Integer activityNum){
        RedissonClient redissonClient = sedissonManage.getRedissonClient();
        RAtomicLong atomicLong = redissonClient.getAtomicLong(getActivityNumKey(activityNum));
        return atomicLong.get();
    }

    /**
     * 获取库存的key
     * @param activityNum
     * @return
     */
    private String getActivityNumKey(Integer activityNum){
        return constant.ACTIVITY_NUM.replace("${key}",activityNum.toString());
    }

}
