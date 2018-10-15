package com.earlyautumn.ruaiter.user.service.impl;

import com.earlyautumn.ruaiter.user.dao.earlyautumn.UserMapper;
import com.earlyautumn.ruaiter.user.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {

    private UserMapper userMapper;




    @Autowired
    public void setUserMapper(UserMapper userMapper) {
        this.userMapper = userMapper;
    }
}
