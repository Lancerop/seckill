package com.team.manager;

import com.team.dao.MemberTypeMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * @Classname MemberTypeManager
 * @Description TODO
 * @Date 2021/7/16 下午11:59
 * @Created by muyi
 */
@Component
public class MemberTypeManager {
    @Autowired
    private MemberTypeMapper memberTypeMapper;
}
