package com.jyh.pattern.structType.bridge;

/**
 * 桥梁模式，具体实现化角色
 */
public class SendSMS implements MessageImplementor{

    /**
     * 实现了实现化角色的方法，具体给出底层操作
     */
    @Override
    public void sendMessage() {
        System.out.println("发送SMS信息");
    }
}
