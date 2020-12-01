package com.jyh.pattern.actionType.observer.push;


/**
 * 具体观察者角色
 */
public class PushConcreteObserver implements PushObserver{

    private String state;

    public PushConcreteObserver(String state){
        this.state = state;
    }

    @Override
    public void update(String newState) {
        System.out.println("开始的状态: " + state);
        state = newState;
        System.out.println("更新后的状态: " + state);
    }
}
