package com.team.Service;

import com.team.DTO.ActivityInventoryDTO;
import com.team.DTO.BookActivityDTO;
import org.apache.rocketmq.common.message.Message;

/**
 * @Classname ActivityService
 * @Description TODO
 * @Date 2021/7/16 下午11:52
 * @Created by muyi
 */
public interface ActivityService {

    // 初始化库存
    void initActivityInventory(Integer activityNum,Long num);


    // 查询活动库存
    ActivityInventoryDTO getActivityInventory();

    // 抢票
    Integer bookActivity(BookActivityDTO activityDTO);

    // 查询抢票结果

    // 代替定时处理会员身份


    void dealMessage(Message message);
}
