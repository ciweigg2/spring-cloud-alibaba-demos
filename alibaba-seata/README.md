### 介绍

SpringCloudAlibaba集成nacos使用seata

### 安装seata并配置应用

参考：[安装seata并配置应用](springcloud-nacos-seata.md)

### 添加依赖

```xml
<dependencyManagement>
    <dependencies>
        <dependency>
            <groupId>org.springframework.cloud</groupId>
            <artifactId>spring-cloud-alibaba-dependencies</artifactId>
            <version>2.1.0.RELEASE</version>
            <type>pom</type>
            <scope>import</scope>
        </dependency>
    </dependencies>
</dependencyManagement>
<dependency>
	<groupId>com.alibaba.cloud</groupId>
	<artifactId>spring-cloud-starter-alibaba-seata</artifactId>
</dependency>
```

### 配置代理数据源

参考：[配置代理数据源](../alibaba-gift/src/main/java/com/ciwei/gift/config/MybatisPlusConfig.java)

如果使用的是 Hikari 数据源，需要修改数据源的配置，以及注入的 Bean 的配置前缀

```properties
spring.datasource.hikari.driver-class-name=com.mysql.cj.jdbc.Driver
spring.datasource.hikari.jdbc-url=jdbc:mysql://localhost:3306/seata?useUnicode=true&characterEncoding=utf8&allowMultiQueries=true&useSSL=false
spring.datasource.hikari.username=root
spring.datasource.hikari.password=123456
```

修改配置：

```java
@Bean
@ConfigurationProperties(prefix = "spring.datasource.hikari")
public DataSource dataSource() {
    return new HikariDataSource();
}
```

### 使用

* 在参与分布式事务的服务中添加注解

```java
@GlobalTransactional
```

* 手动回滚：

try catch或者熔断的逻辑分布式事务认为是不参与全局事务的 所以需要手动回滚

```java
String xid = GlobalTransactionContext.getCurrentOrCreate().getXid();
GlobalTransactionContext.reload(xid).rollback();
```