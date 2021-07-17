package com.team.controller;

import com.team.Service.ActivityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Classname ActivityController
 * @Description TODO
 * @Date 2021/7/16 下午11:52
 * @Created by muyi
 */

@RestController
@RequestMapping("/activity/")
public class ActivityController {

    @Autowired
    private ActivityService activityService;

    // 查询活动库存

    // 抢票

    // 查询抢票结果

    // 代替定时处理会员身份
}
