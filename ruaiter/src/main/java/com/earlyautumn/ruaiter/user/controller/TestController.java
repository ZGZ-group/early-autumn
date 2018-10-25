package com.earlyautumn.ruaiter.user.controller;

import com.earlyautumn.ruaiter.user.domain.User;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TestController {

    @PostMapping("/test")
    public String test(User user) {
        System.out.println(user);

        return "success";
    }

}
