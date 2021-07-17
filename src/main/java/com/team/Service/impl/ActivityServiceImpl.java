package com.team.Service.impl;

import com.team.Service.ActivityService;
import com.team.dao.MemberTicketMapper;
import com.team.manager.ActivityManage;
import com.team.manager.MemberManager;
import com.team.manager.MemberTicketManager;
import com.team.manager.MemberTypeManager;
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


}
