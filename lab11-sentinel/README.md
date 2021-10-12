
## 文档地址

[快速启动](https://github.com/alibaba/Sentinel/wiki/%E6%8E%A7%E5%88%B6%E5%8F%B0#2-%E5%90%AF%E5%8A%A8%E6%8E%A7%E5%88%B6%E5%8F%B0)

[dashboard控制台](https://github.com/alibaba/Sentinel/releases)

控制台账号密码默认为 sentinel


### 两种流量拦截方式
- url拦截方式
- resource拦截方式

### url 方式

直接在控制台配置ur的控制阈值

### resource方式

需要在controller接口方法上使用注解 ResourceSentinel