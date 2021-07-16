package com.team.manager;

import org.apache.rocketmq.client.producer.DefaultMQProducer;
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


}
