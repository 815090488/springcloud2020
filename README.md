# cloud2020
尚硅谷周阳老师springcloud学习、代码摘录

#### cloud-api-commons 实体类module和公共依赖包引入


#### cloud-consumer-order80 消费者module连接eureka注册中心 加 Ribbon负载均衡
#### cloud-comsumerzk-order80 消费者module连接zookeeper注册中心 
#### cloud-consumerconsul-order80 消费者module连接consul注册中心 
#### cloud-consumer-feign-order80 消费者module通过eureka和feign实现客户端连接服务端
#### cloud-consumer-feign-hystrix-order80 消费者module通过eureka和feign、hystrix实现服务降级


#### cloud-provider-payment8001 实现支付8001端口 连接eureka服务端
#### cloud-provider-payment8002 实现支付8002端口 连接eureka服务端
#### cloud-provider-payment8004 实现支付8004端口 连接zookeeper服务端
#### cloud-providerconsul-payment8006 实现支付8006端口 连接consul服务端
#### cloud-provider-hystrix-payment8001 实现支付8001端口 使用hystrix实现服务降级和服务熔断


#### cloud-eureka-server7001 Eureka服务层
#### cloud-eureka-server7002 Eureka服务层


#### cloud-consumer-hystrix-dashboard9001 端口9001 连接hystrix图形化界面


#### cloud-gateway-gateway9527 端口9527 gateway服务网关


#### cloud-config-center3344 端口3344 Spring-Cloud-Config服务端配置
#### cloud-config-center3355 端口3355 Spring-Cloud-Config客户端配置
#### cloud-config-center3366 端口3366 Spring-Cloud-Config客户端配置


#### cloud-stream-rabbitmq-provider8801 端口8801 stream消息驱动生产者配置
#### cloud-stream-rabbitmq-consumer8802 端口8802 stream消息驱动消费者配置


#### cloudalibaba-provider-payment9001 端口9001 Spring Cloud Alibaba注册中心服务端
#### cloudalibaba-provider-payment9002 端口9002 Spring Cloud Alibaba注册中心服务端
#### cloudalibaba-provider-payment9003 端口9004 Spring Cloud Alibaba注册中心服务端
#### cloudalibaba-provider-payment9004 端口9005 Spring Cloud Alibaba注册中心服务端
#### cloudalibaba-consumer-nacos-order83 端口83 Spring Cloud Alibaba消费者中心
#### cloudalibaba-consumer-nacos-order84 端口84 Spring Cloud Alibaba消费者中心 添加sentinel、OpenFeigh、nacos、ribbon



#### seata-order-service2001 端口2001 seata 集成分布式事务
#### seata-order-service2002 端口2002 seata 集成分布式事务
#### seata-order-service2003 端口2003 seata 集成分布式事务

###### 现在已经注释掉DataSourceProxyConfig.java 和 @SpringBootApplication(exclude = DataSourceAutoConfiguration.class) 将seata版本从0.9.0 升级到1.0.0

###### 修改 file.conf  和  registry.conf 为1.0.0版本