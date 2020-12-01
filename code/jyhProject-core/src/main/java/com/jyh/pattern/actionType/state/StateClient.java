package com.jyh.pattern.actionType.state;

/**
 * 状态模式客户端测试
 * 概要:1.上下文根据不同的状态调用不同具体状态角色，以实现不同状态下的逻辑
 *     2.状态的转换封装在上下文角色中，不暴露给客户端，客户端只要投票即可，上下文可以根据不同的结果调用不同的
 *       状态角色去实现
 *     3.状态和行为分离，状态决定行为
 */
public class StateClient {

    public static void main(String[] args) {
        VoteManager vm = new VoteManager();
        for(int i = 0; i < 10; i++){
            vm.vote("user","A");
        }
    }
}
