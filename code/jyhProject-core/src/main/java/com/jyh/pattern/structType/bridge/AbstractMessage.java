package com.jyh.pattern.structType.bridge;

/**
 * 抽象化角色，保持对实现化角色的引用
 */
public abstract class AbstractMessage {

    /**
     * 抽象化角色保持实现化角色的引用，这是桥梁模式中桥梁的体现
     */
    private MessageImplementor implementor;

    public AbstractMessage(MessageImplementor implementor){
        this.implementor = implementor;
    }

    public void sendMessage(){
        this.implementor.sendMessage();
    }
}
