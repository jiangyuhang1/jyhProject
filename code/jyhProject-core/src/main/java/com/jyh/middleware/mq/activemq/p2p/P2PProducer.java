package com.jyh.middleware.mq.activemq.p2p;

import org.apache.activemq.ActiveMQConnectionFactory;

import javax.jms.*;

/**
 * 测试点对点模式
 * 点对点模式生产者角色
 */
public class P2PProducer {

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
            Session session = connection.createSession(Boolean.TRUE,Session.AUTO_ACKNOWLEDGE);

            /**
             * 第三步创建目的地，点对点模式创建一个队列
             */
            Destination destination = session.createQueue("testQueue");

            /**
             * 第四部创建生产者
             */
            MessageProducer messageProducer = session.createProducer(destination);

            /**
             * 第五步创建会话内容
             */
            TextMessage textMessage = session.createTextMessage("testMessage");
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
            messageProducer.close();
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
