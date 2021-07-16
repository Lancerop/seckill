package com.team.controller;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.team.Service.UserService;
import com.team.dao.UserMapper;
import com.team.pojo.User;
import com.team.utils.UserUtils;
import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import java.util.Map;


@Controller
@RequestMapping("/user")
public class UserController {


    @RequestMapping("/list")
    @ResponseBody
    public List<User> getUserList(){
        //第一步：获取SqlSession对象
        SqlSession sqlSession = UserUtils.getSqlSession();

        //方式一:getMapper
        UserMapper userDao = sqlSession.getMapper(UserMapper.class);
        List<User> userList = userDao.getUserList();
        for (User user :userList){
            System.out.println(user);
        }
        //关闭SqlSession
        sqlSession.close();
        return userList;

    }

}



