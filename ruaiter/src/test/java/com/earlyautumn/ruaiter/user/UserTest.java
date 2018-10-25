package com.earlyautumn.ruaiter.user;

import com.earlyautumn.ruaiter.BaseRuaiterTests;
import com.earlyautumn.ruaiter.user.domain.User;
import com.google.gson.Gson;
import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.MediaType;
import org.springframework.mock.web.MockHttpServletResponse;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.RequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import java.util.Date;

public class UserTest extends BaseRuaiterTests {

    private static Logger logger = LoggerFactory.getLogger(UserTest.class);

    @Test
    public void test() throws Exception {
        Gson gson = new Gson();
        User user = new User();
        user.setCityId(12);
        user.setCreateTime(new Date());
        user.setId(3250925L);

        RequestBuilder request = MockMvcRequestBuilders.post("/test")
                .contentType(MediaType.APPLICATION_JSON_UTF8)
                .content(gson.toJson(user));

        MvcResult mvcResult = mockMvc.perform(request).andReturn();
        MockHttpServletResponse response = mvcResult.getResponse();
        String contentAsString = response.getContentAsString();
        System.out.println(contentAsString);

    }

}
