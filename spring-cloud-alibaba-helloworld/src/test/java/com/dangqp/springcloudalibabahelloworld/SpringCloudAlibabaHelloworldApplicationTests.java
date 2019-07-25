package com.dangqp.springcloudalibabahelloworld;

import org.apache.commons.lang3.StringUtils;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.HashMap;
import java.util.Map;

@RunWith(SpringRunner.class)
@SpringBootTest
public class SpringCloudAlibabaHelloworldApplicationTests {

    @Test
    public void contextLoads() {
        Map<String, Object> out = new HashMap<>();
        Object obj = out.get("a");
        System.out.println(String.valueOf(obj));
        System.out.println(StringUtils.isNotEmpty((String)obj));
    }

}
