### 模块介绍

| 模块  | 描述 |端口|
|---|---|---|
| alibaba-root  |  服务入口层       | 8080  |
| alibaba-user      | 用户服务      | 8083  |
| alibaba-user-api  | 用户服务Api   | 无    |
| alibaba-gift      |  礼物服务     | 8081  |
| alibaba-gift-api  | 礼物服务Api   | 无    |
| alibaba-live      | 直播服务      | 8082  |
| alibaba-live-api  |  直播服务Api  | 无    |

### 使用介绍

本架构使用gateway作为服务统一入口 访问接口统一带上/api

why gateway ? 生产全部服务应该是内网的 所以需要nginx将gateway挂载出去实现统一的入口

### 框架技术

* MybatisPlus
* SpringBoot
* SpringCloud
* SpringCloudAlibaba
* Nacos (注册中心兼配置中心)
* Mysql

### 工具

* Lombok
* MyBatisCodeHelperPro(mybatis plus generator)
* docker-compose(服务编排暂未做实现)

### nacos配置中心介绍

spring.profiles.active=dev的话默认读取${spring.application.name}.yaml和${spring.application.name}-${spring.profiles.active}.yaml

刷新配置操作：在需要刷新的类中添加@RefreshScope

* dataId 对应 ${spring.application.name}-${spring.profiles.active}.yaml
* groupId 代码中配置对应就行
* 内容

```java
spring:
  datasource:
    url: jdbc:mysql://127.0.0.1:3306/alibaba?useUnicode=true&characterEncoding=utf8
    driver-class-name: com.mysql.cj.jdbc.Driver
    username: root
    password: 123456
```

![详细配置内容](img/nacos-config.png)