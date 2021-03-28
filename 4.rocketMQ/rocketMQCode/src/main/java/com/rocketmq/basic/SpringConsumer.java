package com.rocketmq.basic;

import org.apache.rocketmq.spring.annotation.ConsumeMode;
import org.apache.rocketmq.spring.annotation.RocketMQMessageListener;
import org.apache.rocketmq.spring.core.RocketMQListener;
import org.springframework.stereotype.Component;

/**
 * 注意下@RocketMQMessageListener这个注解的其他属性
 **/
@Component
@RocketMQMessageListener(consumerGroup = "MyConsumerGroup", topic = "TestTopicOneWay", consumeMode = ConsumeMode.CONCURRENTLY)
public class SpringConsumer implements RocketMQListener<String> {
    static int i = 0;

    @Override
    public void onMessage(String message) {
        System.out.println("Received message :  " + i + "  ------------------" + message);
        // 增加静态变量i来查看消息数量  同步代码块应删掉
//        synchronized ("") {
        i++;
//        }
    }
}
