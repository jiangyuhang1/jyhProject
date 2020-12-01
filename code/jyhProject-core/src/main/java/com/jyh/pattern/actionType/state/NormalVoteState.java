package com.jyh.pattern.actionType.state;

public class NormalVoteState implements State{

    @Override
    public void vote(String user, String voteItem, VoteManager vm) {

        /**
         * 正常投票
         */
        vm.getMapVote().put(user,voteItem);
        System.out.println("恭喜投票成功");
    }
}
