package cn.fantasticmao.demo;

import org.apache.rocketmq.common.message.MessageExt;
import org.apache.rocketmq.spring.annotation.RocketMQMessageListener;
import org.apache.rocketmq.spring.core.RocketMQListener;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.nio.charset.StandardCharsets;

@RocketMQMessageListener(consumerGroup = "consumer", topic = "springboot-rocketmq-docker")
@SpringBootApplication
public class Consumer implements RocketMQListener<MessageExt> {

    @Override
    public void onMessage(MessageExt message) {
        final String msgId = message.getMsgId();
        final String msgBody = new String(message.getBody(), StandardCharsets.UTF_8);
        System.out.printf("Receive MsgId: %s MsgBody: %s%n", msgId, msgBody);
    }

    public static void main(String[] args) {
        SpringApplication.run(Consumer.class, args);
    }
}
