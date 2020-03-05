# springboot-rocketmq-docker

Docker Compose 是用于定义和运行多个 Docker Container 的工具。Docker 官方在 [《Get started with Docker Compose》](https://docs.docker.com/compose/gettingstarted/) 文档中，以创建一个基于 [Flask](https://palletsprojects.com/p/flask/) 和 [Redis](https://redis.io/) 的 Python web 应用，为 Docker 新手提供了一个用于学习和实践 Docker Compose 的简单案例。

SpringBoot-RocketMQ-Docker 使用 Docker Compose，创建了一个基于 [Spring Boot](https://spring.io/projects/spring-boot) 和 [Apache RocketMQ](https://rocketmq.apache.org/) 的 Java web 应用，旨在提供更适用于 Java 相关人员的 Docker Compose 实践案例。

SpringBoot-RocketMQ-Docker 中的消息流转过程如下：

                   +-------------+           +--------------+           +-------------+
                   |             | --------> | RocketMQ     | <-------- |             |
                   |             | discovery | NameServer   | discovery |             |
                   |             |           +--------------+           |             |
         send msg  | MQ Producer |                ^    ^                | MQ Consumer |
    HTTP --------> |     &&      |   routing info |    |                | (print msg) |
                   | REST Server |                v    v                |             |
                   |             |           +--------------+           |             |
                   |             | send msg  | RocketMQ     | send msg  |             |
                   |             | --------> | BrokerServer | --------> |             |
                   +-------------+           +--------------+           +-------------+

1. 使用 HTTP 协议，发送消息至 REST 服务
2. REST 服务作为 MQ Producer 接收消息，并通过 RocketMQ 转发消息至 MQ Consumer
3. MQ Consumer 消费消息

## 前期准备

## 编写 Docker Service: RocketMQ NameServer

## 编写 Docker Service: RocketMQ BrokerServer

## 编写 Docker Service: RocketMQ Console

## 编写 Docker Service: MQ Producer / REST Server

## 编写 Docker Service: MQ Consumer

## 启动 Docker Compose
