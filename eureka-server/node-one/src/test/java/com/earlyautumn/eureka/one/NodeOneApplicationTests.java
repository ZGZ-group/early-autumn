package com.earlyautumn.eureka.one;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;

@RunWith(SpringJUnit4ClassRunner.class)
@WebAppConfiguration
@SpringBootTest(classes = NodeOneApplicationTests.class, webEnvironment = SpringBootTest.WebEnvironment.MOCK)
public abstract class NodeOneApplicationTests {

    @Test
    public void contextLoads() {

    }

}
