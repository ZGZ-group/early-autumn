package com.earlyautumn.ruaiter.user.controller;

import com.earlyautumn.ruaiter.redis.RedisCache;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TestRedisController {

    private RedisCache redisCacheService;

    @GetMapping("get-name")
    public String getName() {
        redisCacheService.set("name", "zhangjialu");
        String name = redisCacheService.get("name");
        System.out.println("-------------" + name + "---------------");
        return name;
    }

    @Autowired
    public void setRedisService(RedisCache redisCacheService) {
        this.redisCacheService = redisCacheService;
    }

}
