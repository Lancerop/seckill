package com.team.Service.impl;

import com.team.Service.UserService;
import com.team.pojo.User;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;
import java.util.Map;

public class UserServiceImpl implements UserService {
    @Autowired
    private User user;

    @Override
    public List<User> getUserList() {
        return getUserList();
    }
}
