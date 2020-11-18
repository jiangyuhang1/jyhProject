package com.jyh.pattern.structType.bridge;

/**
 * 桥梁模式测试类
 */
public class BridgeTest {

    public static void main(String[] args) {
        MessageImplementor sms = new SendSMS();
        MessageImplementor email = new SendEmail();

        AbstractMessage common1 = new CommonMessage(sms);
        AbstractMessage common2 = new CommonMessage(email);

        AbstractMessage urgency1 = new UrgencyMessage(sms);
        AbstractMessage urgency2 = new UrgencyMessage(email);

        /**
         * 可以排列组合，通过AbstractMessage这个桥梁来在不同情形下发送不同的类型的消息
         * 桥梁模式的作用好处:
         * 一：在于易拓展
         * 1.当需要拓展新的消息类型，可以实现一下实现化角色即可
         * 2.当需要在新的场景下发送消息，可以继承抽象角色
         * 二：解耦
         * 将发送消息的场景和消息类型分离开来
         */
        common1.sendMessage();
        common2.sendMessage();
        urgency1.sendMessage();
        urgency2.sendMessage();
    }
}
