# springboot-rocketmq-docker

Docker Compose 官方文档的 [Getting Started](https://docs.docker.com/compose/gettingstarted/) 章节基于 [Python](https://www.python.org/) 和 [Redis](https://redis.io/) 创建并演示了一个可以实时更新网页访问次数的 web 应用。

SpringBoot-RocketMQ-Docker 基于 [Spring Boot](https://spring.io/projects/spring-boot) 和 [Apache RocketMQ](https://rocketmq.apache.org/) 创建了一个可以 _使用 HTTP 发送消息至 REST 服务 -> 接收消息并转发至 MQ -> 从 MQ 中消费消息_ 的稍微复杂一些的 web 应用，旨在提供更适用于 Java 开发人员的《Get started with Docker Compose》，用以作为 Docker Compose 官方文档的补充。

SpringBoot-RocketMQ-Docker 的大体流程图如下：

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
