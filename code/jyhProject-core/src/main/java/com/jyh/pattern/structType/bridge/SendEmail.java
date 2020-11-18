package com.jyh.pattern.structType.bridge;

/**
 * 桥梁模式，具体实现化角色
 */
public class SendEmail implements MessageImplementor{

    /**
     * 具体实现化角色的实现，发送Email消息
     */
    @Override
    public void sendMessage() {
        System.out.println("发送Email消息");
    }
}
