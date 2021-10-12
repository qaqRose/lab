package config.controller;

import com.alibaba.csp.sentinel.annotation.SentinelResource;
import com.alibaba.csp.sentinel.slots.block.BlockException;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author: qiu
 * 2021/10/6
 */
@RestController
public class DemoController {


    @GetMapping("hello")
    public String hello() {
        return "hello sentinel";
    }

    @GetMapping("resource")
    @SentinelResource(value = "helloResource", blockHandler = "helloResourceHandler")
    public String helloResource() {
        return "hello sentinel resource";
    }


    /**
     * 流量控制
     * @param e
     * @return
     */
    public String helloResourceHandler(BlockException e) {
        return "flow limit";
    }
}
