package cn.fantasticmao.demo;

import org.apache.rocketmq.client.producer.SendResult;
import org.apache.rocketmq.spring.core.RocketMQTemplate;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.nio.charset.StandardCharsets;

/**
 * Producer
 *
 * @author maomao
 * @since 2020-01-03
 */
@RestController
public class Producer {
    @Resource
    private RocketMQTemplate rocketMQTemplate;

    @GetMapping("/say/{msg}")
    public String say(@PathVariable String msg) {
        final byte[] payload = msg.getBytes(StandardCharsets.UTF_8);
        final SendResult sendResult = rocketMQTemplate.syncSend("springboot-rocketmq-docker", payload);
        return "Send MsgId: " + sendResult.getMsgId();
    }
}
