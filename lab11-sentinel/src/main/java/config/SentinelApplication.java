package config;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * @author: qiu
 * 2021/10/6
 */
@SpringBootApplication
public class SentinelApplication {
    public static void main(String[] args) {
        SpringApplication.run(SentinelApplication.class, args);

        System.out.println("=================");
        System.out.println("1. 开启sentinel : java -jar sentinel-dashboard-1.8.2.jar ");
        System.out.println("sentinel dashboard: http://localhost:8080");
        System.out.println("默认账号密码都是 sentinel ");
        System.out.println("=================");
    }
}
