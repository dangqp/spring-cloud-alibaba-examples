package com.dangqp.springcloudalibabanacosconfig.config;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

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
@RefreshScope
public class HelloConfigController {

    @Value("${dangqp.title}")
    private String title;

    @GetMapping("/test")
    public String hello() {
        return title;
    }
}
