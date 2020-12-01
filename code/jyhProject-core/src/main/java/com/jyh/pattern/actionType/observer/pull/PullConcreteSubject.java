package com.jyh.pattern.actionType.observer.pull;

/**
 * 具体主题角色
 */
public class PullConcreteSubject extends PullAbstractSubject{

    private String state;

    public PullConcreteSubject(String state){
        this.state = state;
    }

    public String getState(){
        return state;
    }

    @Override
    public void batchUpdateObserver(String newState) {
        System.out.println("具体主题角色开始状态: " + state);
        super.batchUpdateObserver(newState);
        state = newState;
        System.out.println("具体主题角色更新后状态: " + state);
    }
}
