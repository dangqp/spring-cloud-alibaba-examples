package com.dangqp.springcloudalibabaconsumer.controller;

import com.dangqp.springcloudalibabaconsumer.remote.HelloRemoteService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.cloud.client.loadbalancer.LoadBalancerClient;
import org.springframework.context.annotation.Bean;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

/**
 * Title:com.dangqp.springcloudalibabaconsumer.controller
 * Description:
 * Copyright: Copyright (c) 2019
 *
 * @author dangqp
 * @version 1.0
 * @created 2019/07/24  21:17
 */
@RestController
@Slf4j
public class HelloWorldController {

    @GetMapping("/hello")
    public String hello(@RequestParam String name) {
        log.info("invoked name = " + name);
        return "hello " + name;
    }

    @Autowired
    LoadBalancerClient loadBalancerClient;

    @GetMapping("/test")
    public String test() {
        // 通过spring cloud common中的负载均衡接口选取服务提供节点实现接口调用
        ServiceInstance serviceInstance = loadBalancerClient.choose("alibaba-nacos-discovery-server");
        String url = serviceInstance.getUri() + "/hello?name=" + "dangdang";
        RestTemplate restTemplate = new RestTemplate();
        String result = restTemplate.getForObject(url, String.class);
        return "Invoke : " + url + ", return : " + result;
    }

    @Autowired
    HelloRemoteService helloRemoteService;

    @GetMapping("/test1")
    public String hello1(@RequestParam String name) {
        log.info("invoked name = " + name);
        return helloRemoteService.hello(name);
    }

//    @Autowired
//    private WebClient.Builder webClientBuilder;
//
//    @GetMapping("/test")
//    public Mono<String> test() {
//        Mono<String> result = webClientBuilder.build()
//                .get()
//                .uri("http://alibaba-nacos-discovery-server/hello?name=didi")
//                .retrieve()
//                .bodyToMono(String.class);
//        return result;
//    }
//
//    @Bean
//    @LoadBalanced
//    public WebClient.Builder loadBalancedWebClientBuilder() {
//        return WebClient.builder();
//    }
}
