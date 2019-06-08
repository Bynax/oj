package com.bohuanshi.oj;

import com.bohuanshi.oj.messenger.MessageSender;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

/**
 * 消息队列测试类
 */

@RunWith(SpringRunner.class)
@SpringBootTest(classes = com.bohuanshi.oj.application.ApplicationBootstrap.class)
public class MQTest {

    @Test
    public void MQTest(){

    }

    @Autowired
    private MessageSender messageSender;


}
