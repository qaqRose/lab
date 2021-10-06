package io.github.qaqrose.nacos.config.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.core.env.Environment;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author: qiu
 * 2021/10/6
 */
@RefreshScope
@RestController
public class DemoController {

    @Value("${test:default_test}")
    private String test;

    @RequestMapping("test")
    public String config() {
        return test;
    }

    @Autowired
    Environment environment;

    @RequestMapping("getConfig")
    public String getConfig(String key) {
       return environment.getProperty(key);
    }


}
