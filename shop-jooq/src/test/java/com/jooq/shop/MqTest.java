package com.jooq.shop;

import com.jooq.shop.service.TopicProducter;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.amqp.core.AmqpTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.stereotype.Component;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest(classes={ShopApplication.class})
public class MqTest {
    @Autowired
    TopicProducter topicProducter;
    @Autowired
    private AmqpTemplate rabbitTemplate;
    @Test
    public void testPublish(){
        topicProducter.send();
    }

    @Test
    public void testMQ1() {
        for(int i=0;i<1000; i++) {

            rabbitTemplate.convertAndSend("topic.message","message" + i);
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
