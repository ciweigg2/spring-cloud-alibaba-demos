# springcloud-nacos-seata

**分布式事务组件seata的使用demo，AT模式，集成nacos、springboot、springcloud、mybatis-plus，数据库采用mysql**

这里为什么把seata放在本地了呢 因为放在外网机器他会绑定外网机器的内网ip
所以我本地没法调试 其实生产也应该是内网部署的

----------

## 1. 服务端配置

### 1.1 Nacos-server

版本为nacos-server-1.1.3，demo采用本地单机部署方式，请参考 [Nacos 快速开始](https://nacos.io/zh-cn/docs/quick-start.html)

### 1.2 Seata-server

seata-server为release版本0.8.0，demo采用本地单机部署，从此处下载 [https://github.com/seata/seata/releases](https://github.com/seata/seata/releases) 并解压

#### 1.2.1 修改conf/registry.conf 配置

设置type、设置serverAddr为你的nacos节点地址。

**注意这里有一个坑，serverAddr不能带‘http://’前缀**

~~~java
registry {
  # file 、nacos 、eureka、redis、zk、consul、etcd3、sofa
  type = "nacos"

  nacos {
    serverAddr = "192.168.21.89:8848"
    namespace = "public"
    cluster = "default"
  }
}
config {
  # file、nacos 、apollo、zk、consul、etcd3
  type = "nacos"
  nacos {
    serverAddr = "192.168.21.89:8848"
    namespace = "public"
    cluster = "default"
  }
}

~~~

#### 1.2.2 修改conf/nacos-config.txt 配置

service.vgroup_mapping.${your-service-gruop}=default，中间的${your-service-gruop}为自己定义的服务组名称，服务中的application.properties文件里配置服务组名称。

demo中有三个服务，分别是alibaba-gift-group，alibaba-user-group和alibaba-live-group，所以配置如下

~~~properties
service.vgroup_mapping.alibaba-gift-group=default
service.vgroup_mapping.alibaba-user-group=default
service.vgroup_mapping.alibaba-live-group=default
~~~

#### 1.3 启动seata-server

* 分两步，如下

~~~shell
# 初始化seata 的nacos配置(nacos-config.sh中端口固定了8848如果不是此端口请修改脚本)
cd conf
sh nacos-config.sh 192.168.21.89

# 启动seata-server(如果机器有多个ip可以使用-h指定ip地址)
cd bin
sh seata-server.sh -p 8091 -m file
~~~

* 如果部署生产Linux环境的话 有个小技巧 守护进程启动

在nacos根目录创建startup.sh

```shell
#!/bin/bash
sh /root/seata0.8/bin/seata-server.sh -p 8091 -m file
```

安装pm2

```
npm install pm2 -g
pm2 start <sh文件路径>.sh --interpreter bash --name seata
pm2 start seata
查看日志^ ^
pm2 logs -f seata
```

----------

## 2. 应用配置

### 2.1 数据库初始化

~~~SQL
-- 创建undo_log表(如果每个服务有自己的数据库每个库都需要创建)
CREATE TABLE `undo_log`
(
  `id`            BIGINT(20)   NOT NULL AUTO_INCREMENT,
  `branch_id`     BIGINT(20)   NOT NULL,
  `xid`           VARCHAR(100) NOT NULL,
  `context`       VARCHAR(128) NOT NULL,
  `rollback_info` LONGBLOB     NOT NULL,
  `log_status`    INT(11)      NOT NULL,
  `log_created`   DATETIME     NOT NULL,
  `log_modified`  DATETIME     NOT NULL,
  `ext`           VARCHAR(100) DEFAULT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `ux_undo_log` (`xid`, `branch_id`)
) ENGINE = InnoDB
  AUTO_INCREMENT = 1
  DEFAULT CHARSET = utf8;
~~~

### 2.2 应用配置

见代码

几个重要的配置

1. 每个应用的resource里需要配置一个registry.conf ，demo中与seata-server里的配置相同
2. application.propeties 的各个配置项，注意spring.cloud.alibaba.seata.tx-service-group 是服务组名称，与nacos-config.txt 配置的service.vgroup_mapping.${your-service-gruop}具有对应关系

----------

## 3. 测试

启动gift user gateway服务调用接口

http://localhost:8080/api/user/insertUser