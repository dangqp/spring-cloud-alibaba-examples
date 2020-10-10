package com.dangqp.springcloudalibabanacosconfig.config;

import com.dangqp.springcloudalibabanacosconfig.service.TestService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Date;

/**
 * Title:com.dangqp.springcloudalibabanacosconfig.config
 * Description:
 * Copyright: Copyright (c) 2019
 *
 * @author dangqp
 * @version 1.0
 * @created 2019/07/24  21:52
 */
@RestController
@Slf4j
//@RefreshScope
public class HelloConfigController {

    @Value("${dangqp.title}")
    private String title;

    @Autowired
    private TestService testService;

    @GetMapping("/test")
    public String hello() {
        testService.doSomeThing("测试下限流");
        return title;
    }

    @GetMapping("/test1")
    public String hello1() {
        testService.doSomeThing2("hello2 " + new Date());
        return title;
    }
}
