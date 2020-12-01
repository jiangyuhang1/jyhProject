package com.jyh.pattern.actionType.state;

public class SpiteVoteState implements State{

    @Override
    public void vote(String user, String voteItem, VoteManager vm) {

        String voteItemhis = vm.getMapVote().get(user);

        if(voteItemhis != null){
            vm.getMapVote().remove(user);
        }

        System.out.println("恶意刷票，取消用户资格");
    }
}
