package cn.fantasticmao.demo;

import org.apache.rocketmq.common.message.MessageExt;
import org.apache.rocketmq.spring.annotation.RocketMQMessageListener;
import org.apache.rocketmq.spring.core.RocketMQListener;
import org.springframework.stereotype.Component;

import java.nio.charset.StandardCharsets;

/**
 * Consumer
 *
 * @author maomao
 * @since 2020-01-04
 */
@Component
@RocketMQMessageListener(consumerGroup = "consumer", topic = "springboot-rocketmq-docker")
public class Consumer implements RocketMQListener<MessageExt> {

    @Override
    public void onMessage(MessageExt message) {
        final String msgId = message.getMsgId();
        final String msgBody = new String(message.getBody(), StandardCharsets.UTF_8);
        System.out.printf("Receive MsgId: %s MsgBody: %s%n", msgId, msgBody);
    }
}
