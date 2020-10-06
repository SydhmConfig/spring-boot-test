package com.example.springboot.Service.impl;

import com.example.springboot.Entity.User;
import com.example.springboot.Service.IUserService;
import com.example.springboot.mapper.UserMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements IUserService {

    @Autowired
    private UserMapper userMapper;


    @Override
    public User getById(Integer id) {
        return userMapper.selectByPrimaryKey(id);
    }
}
