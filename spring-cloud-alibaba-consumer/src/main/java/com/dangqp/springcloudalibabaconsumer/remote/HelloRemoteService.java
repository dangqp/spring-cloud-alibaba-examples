package com.dangqp.springcloudalibabaconsumer.remote;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * Title:com.dangqp.springcloudalibabaconsumer.remote
 * Description:
 * Copyright: Copyright (c) 2019
 *
 * @author dangqp
 * @version 1.0
 * @created 2019/07/24  21:27
 */
@FeignClient("alibaba-nacos-discovery-server")
public interface HelloRemoteService {
    @GetMapping("/hello")
    String hello(@RequestParam("name") String name);
}
