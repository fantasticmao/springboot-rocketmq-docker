# springboot-rocketmq-docker

Docker Compose 是用于定义和运行多个 Docker Container 的工具。Docker 官方在 [《Get started with Docker Compose》](https://docs.docker.com/compose/gettingstarted/) 文档中，以创建一个基于 [Flask](https://palletsprojects.com/p/flask/) 和 [Redis](https://redis.io/) 的 Python web 应用，为 Docker 新手提供了一个用于学习和实践 Docker Compose 的简单案例。

SpringBoot-RocketMQ-Docker 使用 Docker Compose，创建了一个基于 [Spring Boot](https://spring.io/projects/spring-boot) 和 [Apache RocketMQ](https://rocketmq.apache.org/) 的 Java web 应用，旨在提供更适用于 Java 相关人员的 Docker Compose 实践案例。

SpringBoot-RocketMQ-Docker 的业务场景比较简单：MQ Producer 作为 REST Server，通过 HTTP 协议从客户端中接收消息，并经由 RocketMQ 发送给 MQ Consumer。消息在 SpringBoot-RocketMQ-Docker 中的流转过程如下：

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

## 前期准备

安装 [Docker Engine](https://docs.docker.com/install/) 和 [Docker Compose](https://docs.docker.com/compose/install/)，以及在开发阶段用于管理依赖和打包项目的 [Maven](https://maven.apache.org/download.cgi)、用于编译项目和调试代码的 [JDK](https://www.oracle.com/java/technologies/javase/javase-jdk8-downloads.html)，但是无需安装运行阶段的 JRE 和 RocketMQ，因为它们会由 Docker Image 提供。

## 创建应用

### 创建父工程

定义 springboot-rocketmq-docker 项目中所需要的依赖。

1. 创建工程目录：

   ```shell
     $ mkdir springboot-rocketmq-docker
     $ cd springboot-rocketmq-docker
   ```

2. 在工程目录下，创建一个 `pom.xml` 文件，并粘贴以下内容:

   ```xml
   <?xml version="1.0" encoding="UTF-8"?>
   <project xmlns="http://maven.apache.org/POM/4.0.0"
            xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance"
            xsi:schemaLocation="http://maven.apache.org/POM/4.0.0 http://maven.apache.org/xsd/maven-4.0.0.xsd">
       <parent>
           <groupId>org.springframework.boot</groupId>
           <artifactId>spring-boot-starter-parent</artifactId>
           <version>2.2.2.RELEASE</version>
       </parent>
       <modelVersion>4.0.0</modelVersion>

       <groupId>cn.fantasticmao.demo</groupId>
       <artifactId>springboot-rocketmq-docker</artifactId>
       <packaging>pom</packaging>
       <version>1.0-SNAPSHOT</version>

       <modules>
           <module>mq-producer</module>
           <module>mq-consumer</module>
       </modules>

       <build>
           <plugins>
               <plugin>
                   <groupId>org.springframework.boot</groupId>
                   <artifactId>spring-boot-maven-plugin</artifactId>
               </plugin>
           </plugins>
       </build>

       <dependencyManagement>
           <dependencies>
               <dependency>
                   <groupId>org.apache.rocketmq</groupId>
                   <artifactId>rocketmq-spring-boot-starter</artifactId>
                   <version>2.0.4</version>
               </dependency>
           </dependencies>
        </dependencyManagement>
   </project>
   ```

### 创建子模块 MQ Producer

### 创建子模块 MQ Consumer

## 创建 Dockerfile

### MQ Producer

### MQ Consumer

## 定义 Docker Service

### RocketMQ NameServer

### RocketMQ BrokerServer

### RocketMQ Console

### MQ Producer

### MQ Consumer

## 使用 Docker Compose 构建和运行应用
