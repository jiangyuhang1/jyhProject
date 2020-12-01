package com.jyh.pattern.actionType.state;

public class BlackVoteState implements State{

    @Override
    public void vote(String user, String voteItem, VoteManager vm) {
        System.out.println("黑名单禁止进入系统");
    }
}
