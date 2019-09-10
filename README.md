![](img/logo.png)

> LOGO制作网站：http://www.uugai.com/

### 开发规范

SpringCloud架构开发规范

* 模块之间不能存在任何依赖 比如User模块不能依赖Live
* 模块之间使用feign调用服务返回的对象需要自己定义可以cory提供者的类
* 请求使用request对象 返回使用dto对象 请严格遵循

### 模块介绍

| 模块  | 描述 |端口|
|---|---|---|
| alibaba-gateway  |  服务入口层       | 8080  |
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
* Seata
* Wii (解决通过Spring Cloud调用非Spring Cloud项目 源码地址：https://gitee.com/itmuch/spring-cloud-wii)

### 工具

* Lombok
* 【IDEA插件】MyBatisCodeHelperPro(mybatis plus generator)
* docker-compose(服务编排暂未做实现)
* 【IDEA插件】YapiUpload(注释生成yapi文档)
* yapi [crazy-api个性化定制](https://github.com/xian-crazy/yapi)
* 【IDEA插件】MapStruct Support(字段映射跳转)

### nacos配置中心介绍

spring.profiles.active=dev的话默认读取${spring.application.name}.${file-extension}和${spring.application.name}-${spring.profiles.active}.${file-extension}

刷新配置操作：在需要刷新的类中添加@RefreshScope 或者 spring.cloud.refresh.enabled=true (默认不需要配置)

* dataId 对应 ${spring.application.name}-${spring.profiles.active}.${file-extension}
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

#### 配置的优先级

Spring Cloud Alibaba Nacos Config 目前提供了三种配置能力从 Nacos 拉取相关的配置。

* A: 通过 spring.cloud.nacos.config.shared-dataids 支持多个共享 Data Id 的配置

```java
spring.cloud.nacos.config.shared-dataids=bootstrap-common.properties,all-common.properties
spring.cloud.nacos.config.refreshable-dataids=bootstrap-common.properties
```

* B: 通过 spring.cloud.nacos.config.ext-config[n].data-id 的方式支持多个扩展 Data Id 的配置

```
Data Id 既不在默认的组，也支持动态刷新
spring.cloud.nacos.config.ext-config[0].data-id=ext-config-common03.properties
spring.cloud.nacos.config.ext-config[0].group=REFRESH_GROUP
spring.cloud.nacos.config.ext-config[0].refresh=true
```

* C: 通过内部相关规则(应用名、应用名+ Profile )自动生成相关的 Data Id 配置

```java
${spring.application.name}-${profile}.${file-extension:properties}
```

当三种方式共同使用时，他们的一个优先级关系是:A < B < C

### yapi文档

使用YapiUpload(该项目需要使用多模块配置)插件根据规范的javadoc注释生成文档

YapiUpload配置例子(.idea->misc.xml)：

```
<component name="yapi">
  <option name="moduleList">moduleName1,moduleName2</option>
</component>

<component name="moduleName1">
  <option name="moduleName1.Token">yapi中项目token</option>
  <option name="moduleName1.Id">yapi中项目id</option>
  <option name="moduleName1.Url">http://127.0.0.1:3000</option>
  <option name="moduleName1.Type">api</option>
  <option name="moduleName1.AttachUploadUrl">http://localhost/fileupload</option>
</component>
```

工具使用参考我的博客(可以设置方法注释模板)

类级别分类注释

```java
/**
 * @NAME UserController
 * @USER Ciwei
 * @DATE 2019/8/26/026 11:02
 * @menu 礼物服务接口
 **/
```

方法级别注释：

```java
/**
 * @author 如果没有你
 * @date 2019/8/29 16:01
 * @description 查询所有用户
 * @param alibabaUser: 用户查询条件
 * @return {@link ResponseMessage< List< AlibabaUser>>}
 **/
```

### 动态路由

根据Spring Cloud alibaba Nacos Config的动态刷新特性自动刷新Bean和配置

首先会读取Nacos配置中心配置的dataId为alibaba-gateway-consumer.yaml的配置规则

如果没有读取到会读取本地application.yml的配置规则 都存在的话Nacos配置中心的配置会覆盖本地的配置

[Nacos配置参考](alibaba-gateway/README.md)

### 动态数据源

和动态路由原理一样 只需要在Nacos配置中心配置 更新配置会自动刷新bean和配置

### 协同开发

开发中可能会遇到公用一个注册中心 那么服务就会混乱 所以添加了版本控制各自使用自己的版本开发

应用服务都需要添加注解 依赖 版本

添加注解：

```java
@EnableServerVersionRule
```

添加starter依赖：

```
<dependency>
    <groupId>com.ciwei</groupId>
    <artifactId>alibaba-ribbon-spring-boot-starter</artifactId>
</dependency>
```

添加版本：

```yaml
spring:
  cloud:
    nacos:
      discovery:
        metadata:
          version: ciwei
```

网关添加开启版本控制

```yaml
alibaba:
  lb:
    gateway:
      enable: true
```

网关添加开启版本规则

```java
@EnableGateWayVersionRule
```

#### 测试

postman请求中添加hearders为spring-cloud-version值为ciwei的就可以了

不传版本使用默认的负载均衡规则

#### 原理

每次请求会在拦截器中获取header为spring-cloud-version的版本 然后去CustomIsolationRule.java中匹配返回对应的服务

#### 为什么使用TransmittableThreadLoca？

答：因为可以子线程中传递值而且异步可以获取传递 虽然这边没用到 但是如果用到了呢

### 分布式事务seata

使用：[分布式事务seata](alibaba-seata/README.md)

参考：

* Spring Cloud Alibaba Seata 快速集成 https://github.com/seata/seata-samples/blob/master/doc/quick-integration-with-spring-cloud.md

* Spring Cloud Alibaba Nacos Seata 快速集成 https://github.com/seata/seata-samples/blob/master/springcloud-nacos-seata/README.md

### Spring Cloud Wii

异构微服务框架(可选) 主要解决使用微服务后调用以前项目的接口 需要也通过Nacos注册中心调用的

解决通过Spring Cloud调用非Spring Cloud项目

源码地址：https://gitee.com/itmuch/spring-cloud-wii