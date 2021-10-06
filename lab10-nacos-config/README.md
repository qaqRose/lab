# nacos 整合spring cloud

[官网中文文档](https://nacos.io/zh-cn/docs/quick-start-spring-cloud.html)

[github wiki文档](https://github.com/alibaba/spring-cloud-alibaba/blob/master/spring-cloud-alibaba-examples/nacos-example/nacos-config-example/readme-zh.md)

## 配置类
com.alibaba.cloud.nacos.NacosConfigProperties
是nacos配置中心的配置实体类

## 配置文件 bootstrap.yml [.properties] 
配置文件需要写在 bootstrap.yml  
因为 bootstrap的生命周期比application更早

nacos的配置前缀为`spring.cloud.nacos.config`

## 自动注入
Nacos Config Starter 实现了 `org.springframework.cloud.bootstrap.config.PropertySourceLocator`接口，  
并将优先级设置成了最高。

在 Spring Cloud 应用启动阶段，会主动从 Nacos Server 端获取对应的数据，   
并将获取到的数据转换成 PropertySource 且注入到 Environment 的 PropertySources 属性中，   
所以使用 @Value 注解也能直接获取 Nacos Server 端配置的内容。

### 动态刷新

Nacos Config Starter 默认为所有获取数据成功的 Nacos 的配置项添加了监听功能，   
在监听到服务端配置发生变化时会实时触发 `org.springframework.cloud.context.refresh.ContextRefresher` 的 refresh 方法 。

如果需要对 Bean 进行动态刷新，请参照 Spring 和 Spring Cloud 规范。   
推荐给类添加 `@RefreshScope` 或 `@ConfigurationProperties` 注解，

### dataid
在spring cloud starter中  
dataid的拼接方式为
```
${prefix} - ${spring.profiles.active} . ${file-extension}
```

### namespace 命名空间
一般用于分隔不同的环境
例如: 预发布环境 生产环境
      开发环境  测试环境

### group 分组
group默认为 DEFAULT_GROUP   
可以通过`spring.cloud.nacos.config.group`修改

### file-extension 文件后缀
可以配置文件的后缀
默认为 properties
