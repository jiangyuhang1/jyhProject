package com.jyh.pattern.structType.bridge;

/**
 *  桥梁模式，实现化角色，给出底层操作的定义
 */
public interface MessageImplementor {

    /**
     * 定义一个底层操作，此操作是发送消息
     */
    void sendMessage();
}
