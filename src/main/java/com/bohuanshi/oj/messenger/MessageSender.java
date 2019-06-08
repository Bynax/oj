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
     * 将消息发送到writeQueue中等待将消息的结果落盘
     * @param mapMessage
     */
    public void sendMessage2writeQueue(final Map<String, Object> mapMessage){
        jmsTemplate.convertAndSend(writeQueue,mapMessage);
    }

    /**
     * 将消息发送到dealQueue中，等待提交的代码被执行
     * @param mapMessage
     */
    public void sendMessage2dealQueue(final Map<String, Object> mapMessage){
        jmsTemplate.convertAndSend(dealQueue,mapMessage);
    }


    /**
     * 将消息发送到webQueue中，将程序执行的结果返回给web端
     * @param mapMessage
     */
    public void sendMessage2webQueue(final Map<String, Object> mapMessage){
        jmsTemplate.convertAndSend(webQueue,mapMessage);

    }



    public void sendMessage(final Map<String,Object>mapMessage){
        jmsTemplate.convertAndSend(dealQueue,mapMessage);
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

    @Autowired
    private Queue webQueue;
}