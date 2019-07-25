package com.dangqp.springcloudalibabahelloworld;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@EnableDiscoveryClient
@SpringBootApplication
public class SpringCloudAlibabaHelloworldApplication {

    private static final Logger log = LoggerFactory.getLogger(SpringCloudAlibabaHelloworldApplication.class);

    public static void main(String[] args) {
        SpringApplication.run(SpringCloudAlibabaHelloworldApplication.class, args);
    }

    @RestController
    static class TestController {
        @GetMapping("/hello")
        public String hello(@RequestParam String name) {
            log.info("invoked name = " + name);
            return "hello " + name;
        }
    }

}
