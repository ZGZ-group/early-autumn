package com.earlyautumn.ruaiter;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;

@RunWith(SpringJUnit4ClassRunner.class)
@WebAppConfiguration
@SpringBootTest(classes = BaseRuaiterTests.class, webEnvironment = SpringBootTest.WebEnvironment.MOCK)
public class BaseRuaiterTests {

    @Test
    public void contextLoads() {
    }

//    private UserMapper userMapper;


//    @Test
//    public void testDataSource() {
//        User userById = userMapper.getUserById(1L);
//        System.out.println(userById);
//    }

//    @Autowired
//    public void setUserMapper(UserMapper userMapper) {
//        this.userMapper = userMapper;
//    }

}
