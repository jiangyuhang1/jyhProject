package com.jyh.middleware.mq.activemq.pubsub;

import org.apache.activemq.ActiveMQConnectionFactory;

import javax.jms.*;
import java.io.IOException;

public class PubSubOtherConsumer {

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
            Session session = connection.createSession(Boolean.FALSE,Session.AUTO_ACKNOWLEDGE);

            /**
             * 第三步创建消费者获取消息的来源地
             */
            Destination destination = session.createTopic("testTopic");

            /**
             * 第四步创建消费者
             */
            MessageConsumer messageConsumer = session.createConsumer(destination);

            /**
             * 第五步接受消息
             */
            //TextMessage textMessage = (TextMessage) messageConsumer.receive();
            //System.out.println("========================" + textMessage.getText());
            // 7.设置监听器
            messageConsumer.setMessageListener(new MessageListener() {

                @Override
                public void onMessage(Message message) {
                    if (message instanceof TextMessage) {
                        TextMessage textMessage = (TextMessage) message;
                        try {
                            System.out.println(textMessage.getText());
                        } catch (JMSException e) {
                            // TODO Auto-generated catch block
                            e.printStackTrace();
                        }
                    }

                }
            });

            /**
             * 确认消息已被消费，不提交一直存在队列中
             */
            //session.commit();

            /**
             * 当应答模式是CLIENT_ACKNOWLEDGE时，需要确认消息
             */
            //textMessage.acknowledge();
            // 8.等待接收消息
            System.out.println("topic消费者开始接收消息");
            System.in.read();
            messageConsumer.close();
            session.close();
        }catch(JMSException e){
            e.printStackTrace();
        }catch (IOException e){
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
