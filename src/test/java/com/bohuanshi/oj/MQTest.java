package com.bohuanshi.oj;

import com.bohuanshi.oj.messenger.MessageSender;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.HashMap;

/**
 * 消息队列测试类
 */

@RunWith(SpringRunner.class)
@SpringBootTest(classes = com.bohuanshi.oj.application.ApplicationBootstrap.class)
public class MQTest {

    @Test
    public void MQProducerTest(){

        for(int i=0;i<10;i++){
            HashMap map = new HashMap();
            map.put(i+"","hello");
            messageSender.sendMessage2writeQueue(map);
        }

    }

    @Autowired
    private MessageSender messageSender;


}
