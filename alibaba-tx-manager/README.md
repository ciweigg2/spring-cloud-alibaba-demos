### LCN分布式事务

官网地址：http://www.txlcn.org/zh-cn/docs/demo/env.html

部署tx-manager有两种方式

### 创建数据库

```
docker run -p 3306:3306 --name mymysql -v $PWD/conf:/etc/mysql/conf.d -v $PWD/logs:/logs -v $PWD/data:/var/lib/mysql -e MYSQL_ROOT_PASSWORD=123456 -d mysql:5.7
```

创建MySQL数据库, 名称为: tx-manager

创建数据表

```
CREATE TABLE `t_tx_exception`  (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `group_id` varchar(64) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL,
  `unit_id` varchar(32) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL,
  `mod_id` varchar(128) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL,
  `transaction_state` tinyint(4) NULL DEFAULT NULL,
  `registrar` tinyint(4) NULL DEFAULT NULL,
  `remark` varchar(4096) NULL DEFAULT  NULL,
  `ex_state` tinyint(4) NULL DEFAULT NULL COMMENT '0 未解决 1已解决',
  `create_time` datetime(0) NULL DEFAULT NULL,
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 1 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_general_ci ROW_FORMAT = Dynamic;
```

### 创建redis

首先去redis获取对应版本的配置文件redis.conf

将 bind 127.0.0.1注释，daemonize yes注释掉，如果需要redis密码则找到 requirepass  并填上你的密码

并建立好对应文件夹， usr/redis. usr/redis/data,将redis.conf放入 usr/redis中

```
docker run -d --privileged=true -p 6379:6379 -v /usr/redis/redis.conf:/etc/redis/redis.conf -v /usr/redis/data:/data --name redis1 redis:4.0 redis-server /etc/redis/redis.conf --appendonly yes
```

### docker部署(二选一)

如果使用docker部署 alibaba-tx-manager模块不需要启动了

参考：[docker部署](tm.docker.build.md)

### 本地部署(二选一)

如果使用本地alibaba-tx-manager模块 那么docker就不需要部署了

为什么本地加这个模块 为了更直观的调试 可以直接使用本地tx-manager服务

### 客户端集成

添加依赖：

```java
<!--lcn事务客户端-->
<dependency>
    <groupId>com.codingapi.txlcn</groupId>
    <artifactId>txlcn-tc</artifactId>
    <version>5.0.2.RELEASE</version>
</dependency>

<dependency>
    <groupId>com.codingapi.txlcn</groupId>
    <artifactId>txlcn-txmsg-netty</artifactId>
    <version>5.0.2.RELEASE</version>
</dependency>
```

启动类Application添加注解：

```java
@EnableDistributedTransaction
```

添加配置：

```properties
# lcn事务地址
tx-lcn.client.manager-address=114.67.104.142:8070
# 是否启动LCN负载均衡策略(优化选项，开启与否，功能不受影响) 为什么这边关闭因为我实现了版本路由所以冲突了
tx-lcn.ribbon.loadbalancer.dtx.enabled=false
# 微服务集群且用到 LCN事务模式时，为保证性能请开启TX-LCN重写的负载策略
tx-lcn.springcloud.loadbalance.enabled=true
# 关闭Ribbon的重试机制
ribbon.MaxAutoRetriesNextServer=0
```

事务发起方A调用了事务参与方B，那么两者都需要加上

```java
@LcnTransaction//分布式事务
@Transactional//本地事务注解
```

注意：

1. service层里面一定不要用一个try把几个db操作都给包起来，可以把try放到controller里面去。要不然会造成事务不回滚，框架会认为没有抛出事务
2. 配置的事务管理器ip一定要和tm的一致，端口是事务消息端口，并不是服务端口
3. 集群配置在配置文件里面有详细说明
