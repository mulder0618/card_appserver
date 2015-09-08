package com.zhx.base.queue.queuesender;

import javax.jms.*;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.jms.core.JmsTemplate;
import org.springframework.jms.core.MessageCreator;
import org.springframework.stereotype.Repository;

import java.util.HashMap;

/**
 * Created by admin on 2015/7/29.
 */
@Repository(value = "queueSender")
public class QueueSender {
    @Autowired
    @Qualifier("jmsQueueTemplate")
    private JmsTemplate jmsTemplate;//通过@Qualifier修饰符来注入对应的bean

    /**
     * 发送一条消息到指定的队列（目标）
     * @param queueName 队列名称
     * @param message 消息内容
     */
    public void send(String queueName,final HashMap message){
        jmsTemplate.send(queueName, new MessageCreator() {
            public ObjectMessage createMessage(Session session) throws JMSException {
                return session.createObjectMessage(message);
            }
        });
    }
}
