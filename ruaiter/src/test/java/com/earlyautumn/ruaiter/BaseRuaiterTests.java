package com.earlyautumn.ruaiter;

import org.junit.Before;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

/**
 * Spring 测试基类，新建测试类继承该抽象类
 */
@RunWith(SpringRunner.class)
@SpringBootTest
//@WebAppConfiguration
//@SpringBootTest(classes = BaseRuaiterTests.class, webEnvironment = SpringBootTest.WebEnvironment.NONE)
public abstract class BaseRuaiterTests {

    protected MockMvc mockMvc;

    private WebApplicationContext webApplicationContext;

    @Before
    public void init() {
        this.mockMvc = MockMvcBuilders.webAppContextSetup(this.webApplicationContext).build();
    }

    @Autowired
    public void setWebApplicationContext(WebApplicationContext webApplicationContext) {
        this.webApplicationContext = webApplicationContext;
    }

}
