package com.jyh.pattern.actionType.state;

/**
 * 抽象状态接口
 */
public interface State {

    /**
     * 投票抽象方法
     * @param user 投票人
     * @param voteItem 投票项
     * @param vm 投票上下文，用于回调函数
     */
    void vote(String user,String voteItem,VoteManager vm);
}
