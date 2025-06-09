package com.zpf.rocketmqtestzpf.controller;

import lombok.extern.slf4j.Slf4j;
import org.apache.rocketmq.spring.annotation.MessageModel;
import org.apache.rocketmq.spring.annotation.RocketMQMessageListener;
import org.apache.rocketmq.spring.core.RocketMQListener;
import org.springframework.stereotype.Component;

/**
 * description：TODO
 * time：2022/5/22 15:11
 * auther：zhaopengfei
 */
@Slf4j
@Component
@RocketMQMessageListener(topic = "zpf-Topic-order",
        consumerGroup = "zpf_group_name",
        messageModel = MessageModel.BROADCASTING)
public class RocketMQConsumer implements RocketMQListener<String> {


    @Override
    public void onMessage(String message) {
        log.info("[onMessage][线程编号:{} 消息内容：{}]", Thread.currentThread().getId(), message);
    }
}
