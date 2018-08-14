package com.earlyautumn.sso.sso;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.context.web.WebAppConfiguration;

@RunWith(SpringJUnit4ClassRunner.class)
@WebAppConfiguration
@SpringBootTest(classes = SsoApplicationTests.class, webEnvironment = SpringBootTest.WebEnvironment.MOCK)
public class SsoApplicationTests {

    @Test
    public void contextLoads() {
    }

}
