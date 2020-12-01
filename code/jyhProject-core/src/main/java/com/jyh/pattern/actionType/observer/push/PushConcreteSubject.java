package com.jyh.pattern.actionType.observer.push;

/**
 * 具体主题角色
 */
public class PushConcreteSubject extends PushAbstractSubject{

    private String state;

    @Override
    public void batchUpdatePushObserver(String state) {
        System.out.println("更新主题状态，通知观察者状态更新");

        /**
         * 主题状态发生变更，将主题状态推送给所有的订阅观察者
         */
        super.batchUpdatePushObserver(state);
    }
}
