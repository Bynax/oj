package com.bohuanshi.oj.configurations;

import org.apache.activemq.ActiveMQConnectionFactory;
import org.apache.activemq.command.ActiveMQQueue;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jms.config.DefaultJmsListenerContainerFactory;
import org.springframework.jms.config.JmsListenerContainerFactory;

import javax.jms.Queue;

/**
 * 消息队列的相关配置
 */

@Configuration
public class ActiveMQConfig {
    @Value("${activemq.queue-name.dealQueueName}")
    // 此消息队列用来运行提交的程序
    private String dealQueueName;

    @Value("${activemq.queue-name.writeQueueName}")
    // 此消息队列用来将数据写入到数据库中
    private String writeQueueName;


    @Value("${spring.activemq.user}")
    private String usrName;

    @Value("${spring.activemq.password}")
    private String password;

    @Value("${spring.activemq.broker-url}")
    private String brokerUrl;

    /**
     * 返回用来处理提交程序的消息队列
     *
     * @return JMS定义的Queue
     */
    @Bean
    public Queue dealQueue() {
        return new ActiveMQQueue(dealQueueName);
    }

    /**
     * 返回用来落盘的消息队列（将数据写入到数据库中）
     *
     * @return JMS定义的Queue
     */
    @Bean
    public Queue writeQueue() {
        return new ActiveMQQueue(writeQueueName);
    }


    @Bean
    public ActiveMQConnectionFactory connectionFactory() {
        return new ActiveMQConnectionFactory(usrName, password, brokerUrl);
    }

    @Bean
    public JmsListenerContainerFactory<?> jmsListenerContainerQueue(ActiveMQConnectionFactory connectionFactory) {
        DefaultJmsListenerContainerFactory bean = new DefaultJmsListenerContainerFactory();
        bean.setConnectionFactory(connectionFactory);
        return bean;
    }

    @Bean
    public JmsListenerContainerFactory<?> jmsListenerContainerTopic(ActiveMQConnectionFactory connectionFactory) {
        DefaultJmsListenerContainerFactory bean = new DefaultJmsListenerContainerFactory();
        //设置为发布订阅方式, 默认情况下使用的生产消费者方式
        bean.setPubSubDomain(true);
        bean.setConnectionFactory(connectionFactory);
        return bean;
    }
}