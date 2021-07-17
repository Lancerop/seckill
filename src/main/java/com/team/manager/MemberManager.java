package com.team.manager;

import com.team.dao.MemberMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * @Classname MemberManager
 * @Description TODO
 * @Date 2021/7/16 下午11:59
 * @Created by muyi
 */
@Component
public class MemberManager {
    @Autowired
    private MemberMapper memberMapper;
}
