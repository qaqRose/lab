package io.github.qaqrose.nacos.discovery.consumer.service;

import io.github.qaqrose.nacos.discovery.consumer.config.FeignConfiguration;
import io.github.qaqrose.nacos.discovery.consumer.service.fallback.EchoServiceFallback;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * @author: qiu
 * 2021/10/3
 */
@FeignClient(name = "qaq-provider", fallback = EchoServiceFallback.class,
        configuration = FeignConfiguration.class)
public interface EchoService {

    @GetMapping("/echo/{str}")
    String echo(@PathVariable("str") String str);

    @GetMapping("/divide")
    String divide(@RequestParam("a") Integer a, @RequestParam("b") Integer b);

    default String divide(Integer a) {
        return divide(a, 0);
    }

    @GetMapping("/notFound")
    String notFound();

}




