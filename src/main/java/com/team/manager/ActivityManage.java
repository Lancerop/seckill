package com.team.manager;

import com.team.common.constant.constant;
import org.apache.rocketmq.client.producer.DefaultMQProducer;
import org.apache.rocketmq.common.message.Message;
import org.redisson.api.RAtomicLong;
import org.redisson.api.RedissonClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.concurrent.TimeUnit;

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
     * 添加库存
     * @param activityNum
     * @return
     */
    public Long addActivityInventory(Integer activityNum){
        RedissonClient redissonClient = sedissonManage.getRedissonClient();
        RAtomicLong atomicLong = redissonClient.getAtomicLong(getActivityNumKey(activityNum));
        return atomicLong.incrementAndGet();
    }

    /**
     * 扣减库存
     * @param activityNum
     * @return
     */
    public Long decrementActivityInventory(Integer activityNum){
        RedissonClient redissonClient = sedissonManage.getRedissonClient();
        RAtomicLong atomicLong = redissonClient.getAtomicLong(getActivityNumKey(activityNum));
        return atomicLong.decrementAndGet();
    }

    /**
     * 保存用户key one/two
     * @param memberId
     * @param activityNum
     * @param keyNum
     */
    public void saveActivityKey(Long memberId,Integer activityNum,Integer keyNum){
        if(keyNum == 1){
            sedissonManage.set(getMemberActivityKey(memberId,activityNum),keyNum,30, TimeUnit.MINUTES);
        }else if(keyNum == 2){
            sedissonManage.set(getMemberActivityKey(memberId,activityNum),keyNum);
        }
    }

    /**
     * 获取用户的key one/two
     * @param memberId
     * @param activityNum
     * @return
     */
    public Integer getActivityKey(Long memberId,Integer activityNum) {
        return sedissonManage.get(getMemberActivityKey(memberId,activityNum));
    }

    /**
     * 删除用户key one/two
     * @param memberId
     * @param activityNum
     * @param keyNum
     * @return
     */
    public boolean deleteActivityKey(Long memberId,Integer activityNum,Integer keyNum){
        if(keyNum == getActivityKey(memberId,activityNum)){
            return sedissonManage.delete(getMemberActivityKey(memberId,activityNum));
        }
        return false;
    }

    /**
     * 删除用户所有的key
     * @param memberId
     * @param activityNum
     * @return
     */
    public boolean deleteAllActivityKey(Long memberId,Integer activityNum){
        return sedissonManage.delete(getMemberActivityKey(memberId,activityNum));
    }

    /**
     * 获取库存的key
     * @param activityNum
     * @return
     */
    private String getActivityNumKey(Integer activityNum){
        return constant.ACTIVITY_NUM.replace("${key}",activityNum.toString());
    }

    /**
     * 获取用户对应活动的key
     * @param memberId
     * @param activityNum
     * @return
     */
    private String getMemberActivityKey(Long memberId,Integer activityNum){
        return constant.MEMBER_ACTIVITY_NUM.replace("${memberId}",memberId.toString())
                .replace("${activityNum}",activityNum.toString());
    }

    /**
     * 发送预订成功的消息
     * @param memberId
     */
    public void sendSuccessMessage(Long memberId){
        try {

            Message message = new Message();
            message.setTopic("seckill");
            message.setTags("keytwo");
            message.setBody(message.toString().getBytes());
            defaultMQProducer.send(message);
        }catch (Exception e){

        }
    }

    /**
     * 发送延迟消息
     * @param memberId
     */
    public void sendDelayMessage(Long memberId){
        try {
            Message message = new Message();
            message.setTopic("seckill");
            message.setTags("keyone");
            message.setBody(message.toString().getBytes());
            defaultMQProducer.send(message,30*60*60);
        }catch (Exception e){

        }
    }
}
