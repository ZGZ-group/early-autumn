package com.earlyautumn.eureka.one;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

@EnableEurekaServer
@SpringBootApplication
public class NodeOneApplication {

    public static void main(String[] args) {
        SpringApplication.run(NodeOneApplication.class, args);
    }
}
