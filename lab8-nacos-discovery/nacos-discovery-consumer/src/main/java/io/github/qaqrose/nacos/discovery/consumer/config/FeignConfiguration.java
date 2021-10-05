package io.github.qaqrose.nacos.discovery.consumer.config;

import io.github.qaqrose.nacos.discovery.consumer.service.fallback.EchoServiceFallback;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;


@Configuration
public class FeignConfiguration {

    @Bean
    public EchoServiceFallback echoServiceFallback() {
        return new EchoServiceFallback();
    }

}