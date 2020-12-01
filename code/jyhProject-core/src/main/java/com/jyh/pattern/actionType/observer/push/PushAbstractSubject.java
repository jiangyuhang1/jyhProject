package com.jyh.pattern.actionType.observer.push;

import java.util.ArrayList;
import java.util.List;

/**
 * 抽象主题角色
 */
public abstract class PushAbstractSubject {

    /**
     * 持有观察者的一个引用集合，即观察者订阅了主题
     */
    private List<PushObserver> pushObserverList = new ArrayList<>();

    public void addPushObserver(PushObserver pushObserver){
        pushObserverList.add(pushObserver);
    }

    public void batchUpdatePushObserver(String state){
        if(pushObserverList != null && pushObserverList.size() > 0){
            for(PushObserver pushObserver : pushObserverList){
                pushObserver.update(state);
            }
        }
    }
}
