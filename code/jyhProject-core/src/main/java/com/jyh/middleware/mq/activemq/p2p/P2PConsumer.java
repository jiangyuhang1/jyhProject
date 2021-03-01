package com.jyh.middleware.mq.activemq.p2p;

import org.apache.activemq.ActiveMQConnectionFactory;

import javax.jms.*;

/**
 * 点对点模式消费者
 */
public class P2PConsumer {

    public static void main(String[] args) {
        ConnectionFactory connectionFactory = new ActiveMQConnectionFactory("tcp://localhost:61616");

        Connection connection = null;
        try{
            /**
             * 第一步创建连接
             */
            connection = connectionFactory.createConnection();
            connection.start();

            /**
             * 第二步创建会话
             * 非事务不需要commit
             * 应答模式是CLIENT_ACKNOWLEDGE需要手动确认
             * DUPS_OK_ACKNOWLEDGE:延迟确认提交，可能存在重复提交
             */
            //Session session = connection.createSession(Boolean.TRUE,Session.AUTO_ACKNOWLEDGE);
            Session session = connection.createSession(Boolean.FALSE,Session.CLIENT_ACKNOWLEDGE);

            /**
             * 第三步创建消费者获取消息的来源地
             */
            Destination destination = session.createQueue("testQueue");

            /**
             * 第四步创建消费者
             */
            MessageConsumer messageConsumer = session.createConsumer(destination);

            /**
             * 第五步接受消息
             */
            TextMessage textMessage = (TextMessage) messageConsumer.receive();
            System.out.println("========================" + textMessage.getText());

            /**
             * 确认消息已被消费，不提交一直存在队列中
             */
            //session.commit();

            /**
             * 当应答模式是CLIENT_ACKNOWLEDGE时，需要确认消息
             */
            textMessage.acknowledge();
            messageConsumer.close();
            session.close();
        }catch(JMSException e){
            e.printStackTrace();
        }finally {
            try {
                connection.close();
            }catch (JMSException e){
                e.printStackTrace();
            }
        }
    }
}
