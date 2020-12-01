package com.jyh.pattern.actionType.state;

public class RepeatVoteState implements State{

    @Override
    public void vote(String user, String voteItem, VoteManager vm) {

        System.out.println("请不要重复投票");
    }
}
