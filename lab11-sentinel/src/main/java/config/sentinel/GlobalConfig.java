package config.sentinel;

import org.springframework.context.annotation.Configuration;

import javax.annotation.PostConstruct;

/**
 * @author: qiu
 * 2021/10/6
 */
@Configuration
public class GlobalConfig {

    @PostConstruct
    public void init() {
        System.out.println("init sentinel url block handler config");
        // 1.8 不用 UrlBlockHandler了
//        WebCallbackManager.setUrlBlockHandler(new DemoUrlBlockHandler());

    }
}
