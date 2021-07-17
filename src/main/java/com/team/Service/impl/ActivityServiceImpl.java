package com.team.Service.impl;

import com.team.DTO.ActivityInventoryDTO;
import com.team.DTO.BookActivityDTO;
import com.team.Service.ActivityService;
import com.team.dao.MemberTicketMapper;
import com.team.manager.ActivityManage;
import com.team.manager.MemberManager;
import com.team.manager.MemberTicketManager;
import com.team.manager.MemberTypeManager;
import org.apache.rocketmq.common.message.Message;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @Classname ActivityServiceImpl
 * @Description TODO
 * @Date 2021/7/16 下午11:52
 * @Created by muyi
 */
@Service
public class ActivityServiceImpl implements ActivityService {

    @Autowired
    private ActivityManage activityManage;

    @Autowired
    private MemberManager memberManager;

    @Autowired
    private MemberTypeManager memberTypeManager;

    @Autowired
    private MemberTicketManager memberTicketManager;

    @Override
    public void initActivityInventory(Integer activityNum, Long num) {
        activityManage.initActivityInventory(activityNum,num);
    }

    @Override
    public ActivityInventoryDTO getActivityInventory() {
        ActivityInventoryDTO activityInventoryDTO = new ActivityInventoryDTO();
        // 查询活动一库存
        Long activityOneNum = activityManage.getActivityInventory(1);
        // 查询活动二库存
        Long activityTwoNum = activityManage.getActivityInventory(2);

        activityInventoryDTO.setNumberOne(activityOneNum);
        activityInventoryDTO.setNumberTwo(activityTwoNum);

        return activityInventoryDTO;
    }

    @Override
    public Integer bookActivity(BookActivityDTO activityDTO) {
        // 校验活动时间

        //
        return null;
    }


    @Override
    public void dealMessage(Message message) {
        String tag = message.getTags();
        if("keyone".equals(tag)) {

        }
        if("keytwo".equals(tag)){

        }
    }
}
