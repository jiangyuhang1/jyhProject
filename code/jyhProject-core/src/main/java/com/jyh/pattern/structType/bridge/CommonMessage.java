package com.jyh.pattern.structType.bridge;

/**
 * 修正抽象化角色，对抽象化角色的修正，可以修改或者添加一些方法
 */
public class CommonMessage extends AbstractMessage{

    public CommonMessage(MessageImplementor implementor){
        super(implementor);
    }

    /**
     * 普通消息发送，直接复用父类方法
     */
    @Override
    public void sendMessage() {
        super.sendMessage();
    }
}
