package com.earlyautumn.ruaiter.sourcetest;

import com.earlyautumn.ruaiter.BaseRuaiterTests;
import com.earlyautumn.ruaiter.user.service.UserService;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Qualifier;

import javax.annotation.Resource;

public class DataSourceTest extends BaseRuaiterTests {

    @Qualifier("userServiceImpl")
    @Resource
    private UserService userService;

    @Test
    public void contextLoads() {
        System.out.println(userService);
    }

}
