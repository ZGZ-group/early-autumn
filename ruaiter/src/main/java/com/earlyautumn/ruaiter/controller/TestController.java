package com.earlyautumn.ruaiter.controller;

import com.earlyautumn.ruaiter.dao.test.UserMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TestController {

    private UserMapper userMapper;

    @GetMapping("/get-user/{id}")
    public String test(@PathVariable("id") long id) {

        System.out.println("test");

        System.out.println(userMapper.getUserById(id));
        return "hello";
    }

    @Autowired
    public void setUserMapper(UserMapper userMapper) {
        this.userMapper = userMapper;
    }
}
