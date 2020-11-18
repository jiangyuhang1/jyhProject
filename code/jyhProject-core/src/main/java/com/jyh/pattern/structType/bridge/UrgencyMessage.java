package com.jyh.pattern.structType.bridge;

/**
 * 修正抽象类角色
 */
public class UrgencyMessage extends AbstractMessage{

    public UrgencyMessage(MessageImplementor implementor){
        super(implementor);
    }

    /**
     * 加急消息发送，对操作进行修改
     */
    @Override
    public void sendMessage() {
        System.out.println("这是一个加急消息");
        super.sendMessage();
    }

    /**
     * 加急消息发送拓展新功能，加上监听消息操作
     * @param messageId
     * @return
     */
    public Object watch(String messageId){
        return null;
    }
}
