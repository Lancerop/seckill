package com.team.manager;

import com.team.dao.MemberTicketMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * @Classname MemberTicketManager
 * @Description TODO
 * @Date 2021/7/16 下午11:59
 * @Created by muyi
 */
@Component
public class MemberTicketManager {

    @Autowired
    private MemberTicketMapper memberTicketMapper;

}
