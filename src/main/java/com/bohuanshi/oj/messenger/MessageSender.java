package com.bohuanshi.oj.messenger;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jms.core.JmsTemplate;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import javax.jms.Queue;

/**
 * 消息发送服务.
 */
@Service("producer")
public class MessageSender {
    /**
     * 发送消息至消息队列.
     *
     * @param mapMessage - Key-Value格式的消息
     */
    public void sendMessage(final Map<String, Object> mapMessage,Queue queue) {
        jmsTemplate.convertAndSend(queue,mapMessage);
    }

    /**
     * 发送消息至消息队列
     *
     * @param objectMessage - 发送Java对象格式的消息
     */
    public void sendMessage(final Object objectMessage,Queue queue) {
        jmsTemplate.convertAndSend(queue,objectMessage);
    }

    /**
     * 自动注入的JmsTemplate对象.
     * 用于发送消息至消息队列.
     */
    @Autowired
    private JmsTemplate jmsTemplate;

    @Autowired
    private Queue writeQueue;

    @Autowired
    private Queue dealQueue;
}