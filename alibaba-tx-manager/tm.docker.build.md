### 构建镜像到本地

#### 下载源码

我的github也有备份 备份版本是5.0.2.RELEASE

```
git clone https://github.com/codingapi/tx-lcn.git
```

#### 修改txlcn-tm打包build

删除原有build 添加下面的

```
    <build>
        <plugins>
            <plugin>
                <groupId>org.springframework.boot</groupId>
                <artifactId>spring-boot-maven-plugin</artifactId>
                <configuration>
                    <executable>true</executable>
                </configuration>
                <executions>
                    <execution>
                        <goals>
                            <goal>repackage</goal>
                        </goals>
                    </execution>
                </executions>
            </plugin>

            <!--docker 构建-->
            <plugin>
                <groupId>com.spotify</groupId>
                <artifactId>docker-maven-plugin</artifactId>
                <version>1.0.0</version>
                <configuration>
                    <imageName>codingapi/txlcn-tm</imageName>
                    <dockerDirectory>${project.basedir}/src/main/docker</dockerDirectory>
                    <resources>
                        <resource>
                            <targetPath>/</targetPath>
                            <directory>${project.build.directory}</directory>
                            <include>${project.build.finalName}.jar</include>
                        </resource>
                    </resources>
                    <imageTags>
                        <imageTag>5.0.2</imageTag>
                    </imageTags>

                    <serverId>docker-hub</serverId>
                    <registryUrl>https://index.docker.io/v1/</registryUrl>
                </configuration>
            </plugin>
        </plugins>
    </build>
```

#### 构建docker镜像

如果下面执行执行报错 先在根目录 mvn clean package -DskipTests

```
# 当前路径 tx-lcn/txlcn-tm
mvn clean package -DskipTests docker:build
```

打包后的镜像版本是codingapi/txlcn-tm:5.0.2

> 如果要自己编写Dockerfile

将编译完的txlcn-tm-5.0.2.RELEASE.jar 和 Dockerfile放在一个目录

vi Dockerfile

```
###指定java8环境镜像
FROM java:8

###复制文件到容器app-springboot
ADD txlcn-tm-5.0.2.RELEASE.jar /lcn.jar

###声明启动端口号
EXPOSE 7970
EXPOSE 8070

###配置容器启动后执行的命令
ENTRYPOINT [ "bash", "-c", "java -jar /lcn.jar" ]
```

构建镜像：

```
docker build ciwei-lcn:5.0.2 .
```

#### 运行说明

- 可以不用构建,在有docker环境的机器上直接运行下面命令(官方版本是5.0.2.dev)

最好别用官方的版本除非他升级了 maven版本是5.0.2.RELEASE官方镜像是5.0.2.dev 连接失败的会

1. 命令行传参数运行

```
docker run -p 7970:7970 -p 8070:8070 \
--restart always --name tm \
-e spring.datasource.url=jdbc:mysql://127.0.0.1:3306/tx_manager \
-e spring.datasource.username=root \
-e spring.datasource.password=123456 \
-e spring.redis.host=127.0.0.1 \
-e spring.redis.port=6379 \
-e spring.redis.password= \
-e tx-lcn.manager.admin-key=123456 \
-e tx-lcn.logger.enabled=true \
-e tx-lcn.manager.host=0.0.0.0 \
-d codingapi/txlcn-tm
```

- 说明
- -p 端口映射 宿主机器端口:容器内端口
- --name : 容器别名
-  --restart always : 容器伴随docker服务启动(如果docker是开机启动,那么这个容器就是开机启动的)
- -d : 放入后台运行
- -e 相当于 java -jar tm.jar 后面的参数,
- spring.datasource.url 这个配置里面如果有特殊符号 命令行不支持,建议使用第二种方式

2. 增加外部配置文件运行. 需要在宿主机器上有文件 /opt/data/lcntm/application-dev.properties

```
spring.application.name=tx-manager
server.port=7970
spring.datasource.driver-class-name=com.mysql.jdbc.Driver
spring.datasource.url=jdbc:mysql://127.0.0.1:3306/tx-manager?characterEncoding=UTF-8
spring.datasource.username=root
spring.datasource.password=root
mybatis.configuration.map-underscore-to-camel-case=true
mybatis.configuration.use-generated-keys=true
spring.jpa.database-platform=org.hibernate.dialect.MySQL5InnoDBDialect
spring.jpa.hibernate.ddl-auto=none
# TxManager Host Ip
#注意：如果是Linux环境用docker发布，此处一定不能更改，只能使用0.0.0.0
#注意：如果是Linux环境用jar包运行，此处修改为自己的Linux IP地址，例如192.168.1.81
tx-lcn.manager.host=0.0.0.0
# TxClient连接请求端口
tx-lcn.manager.port=8070
tx-lcn.manager.admin-key=123456

# 心跳检测时间(ms)
#tx-lcn.manager.heart-time=15000
# 分布式事务执行总时间
#tx-lcn.manager.dtx-time=30000
#参数延迟删除时间单位ms
#tx-lcn.message.netty.attr-delay-time=10000
#tx-lcn.manager.concurrent-level=128
# 开启日志
tx-lcn.logger.enabled=true
logging.level.com.codingapi=debug
logging.level.com.codingapi=debug
tx-lcn.logger.driver-class-name=${spring.datasource.driver-class-name}
tx-lcn.logger.jdbc-url=${spring.datasource.url}
tx-lcn.logger.username=${spring.datasource.username}
tx-lcn.logger.password=${spring.datasource.password}
#redisIp
spring.redis.host=127.0.0.1
#redis 端口
spring.redis.port=6379
#redis 密码
#spring.redis.password=
##发生异常发送邮件给管理员
#spring.mail.host=smtp.126.com
#spring.mail.port=25
#spring.mail.username=pw1914109147@126.com
#spring.mail.password=
# 异常回调开关。开启时请制定ex-url
#tx-lcn.manager.ex-url-enabled=true
# 事务异常通知（任何http协议地址。未指定协议时，为TM提供内置功能接口）。默认是邮件通知
#tx-lcn.manager.ex-url=/provider/email-to/1914109147@qq.com
#tx-lcn.manager.ex-url=http://192.168.25.1:8002/api-cu/test/findAll
```

执行命令

```
docker run -p 7970:7970 -p 8070:8070 \
--restart always \
--name tm -v /opt/data/lcntm:/opt/data/lcntm \
-e spring.profiles.active=dev \
-e spring.config.additional-location=/opt/data/lcntm/application-dev.properties \
-d codingapi/txlcn-tm
```

- 说明
- -v : 文件挂载
