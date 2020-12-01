package com.jyh.pattern.actionType.state;

import java.util.HashMap;
import java.util.Map;

/**
 * 状态模式
 * 环境角色
 */
public class VoteManager {

    private State state = null;

    /**
     * 记录投票user和投票选项
     */
    private Map<String,String> mapVote = new HashMap<>();

    /**
     * 记录投票user和投票的次数
     */
    private Map<String,Integer> mapVoteCount = new HashMap<>();

    public Map<String,String> getMapVote(){
        return mapVote;
    }

    public void vote(String user, String voteItem){

        /**
         * 从投票系统中取出投票人投票的次数
         */
        Integer oldVoteCount = mapVoteCount.get(user);

        if(oldVoteCount == null){
            oldVoteCount = 0;
        }
        oldVoteCount += 1;

        /**
         * 给投票人增加投票次数
         */
        mapVoteCount.put(user,oldVoteCount);

        if(oldVoteCount == 1){
            state = new NormalVoteState();
        }else if(oldVoteCount > 1 && oldVoteCount < 5){
            state = new RepeatVoteState();
        }else if(oldVoteCount >= 5 && oldVoteCount <= 8){
            state = new SpiteVoteState();
        }else if(oldVoteCount > 8){
            state = new BlackVoteState();
        }

        state.vote(user,voteItem,this);
    }
}
