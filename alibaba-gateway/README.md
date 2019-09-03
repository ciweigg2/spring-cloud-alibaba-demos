nacos动态规则

* alibaba-gateway-consumer.yaml

* group：alibaba

```
spring:
  cloud:
    gateway:
     routes:
       - id: gift_route
         uri: lb://alibaba-gift-provider
         predicates:
           - Path=/api/gift/**
         filters:
           - StripPrefix=1
       - id: live_route
         uri: lb://alibaba-live-provider
         predicates:
           - Path=/api/live/**
         filters:
           - StripPrefix=1
       - id: user_route
         uri: lb://alibaba-user-provider
         predicates:
           - Path=/api/user/**
         filters:
           - StripPrefix=1
```