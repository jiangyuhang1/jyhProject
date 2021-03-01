package com.jyh.middleware.mq.activemq.pubsub;

import org.apache.activemq.ActiveMQConnectionFactory;

import javax.jms.*;

/**
 * 发布订阅模式生产者觉得
 */
public class PubSubProducer {

    public static void main(String[] args) {
        /**
         * 服务端端口61616
         * 客户端8161
         */
        ConnectionFactory connectionFactory = new ActiveMQConnectionFactory("tcp://localhost:61616");

        Connection connection = null;
        try {
            /**
             * 第一步创建连接
             */
            connection = connectionFactory.createConnection();
            connection.start();

            /**
             * 第二步创建会话
             * 参数包括1.是否支持事务，true false
             * 2.应答模式，包括
             *     int AUTO_ACKNOWLEDGE = 1;
             *     int CLIENT_ACKNOWLEDGE = 2;
             *     int DUPS_OK_ACKNOWLEDGE = 3;
             */
            Session session = connection.createSession(Boolean.FALSE,Session.AUTO_ACKNOWLEDGE);

            /**
             * 第三步创建目的地，发布订阅模式创建一个Topic
             */
            Destination destination = session.createTopic("testTopic");

            /**
             * 第四部创建生产者
             */
            MessageProducer messageProducer = session.createProducer(destination);

            /**
             * 第五步创建会话内容
             */
            TextMessage textMessage = session.createTextMessage("testTopic");
            System.out.println("===========================" + textMessage.getText());

            /**
             * 可以设置消息是否持久化，持久化将生成数据文件,会在data文件夹下面生成一个db.data
             */
            messageProducer.setDeliveryMode(DeliveryMode.PERSISTENT);
            //messageProducer.setPriority();

            /**
             * 第六步发送消息
             */
            messageProducer.send(textMessage);

            /**
             * 开启事务后，需要提交
             */
            session.commit();
            session.close();
        }catch(JMSException e){
            e.printStackTrace();
        }finally {
            try{
                connection.close();
            }catch (JMSException e){
                e.printStackTrace();
            }
        }

    }
}
