package com.jyh.pattern.actionType.observer.pull;

/**
 * 具体观察者角色
 */
public class PullConcreteObserver implements PullObserver{

    private String state;

    public PullConcreteObserver(String state){
        this.state = state;
    }

    @Override
    public void update(PullAbstractSubject pullAbstractSubject) {
        System.out.println("具体观察者对象开始状态: " + state);
        /**
         * 这是一种拉模型观察者模型的处理方式
         */
        state = ((PullConcreteSubject)pullAbstractSubject).getState();
        System.out.println("具体观察者对象更新后状态: " + state);
    }
}
