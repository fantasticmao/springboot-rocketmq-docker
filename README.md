使用 Docker 构建 Spring Boot + RocketMQ 简单应用。

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
