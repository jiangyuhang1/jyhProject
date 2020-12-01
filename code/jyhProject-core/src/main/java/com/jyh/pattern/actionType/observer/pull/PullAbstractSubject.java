package com.jyh.pattern.actionType.observer.pull;

import java.util.ArrayList;
import java.util.List;

/**
 * 抽象主题角色
 */
public abstract class PullAbstractSubject {

    /**
     * 持有观察者引用集合
     */
    private List<PullObserver> pullObserverList = new ArrayList<>();

    /**
     * 观察者订阅主题过程
     * @param pullObserver
     */
    public void addPullObserverList(PullObserver pullObserver){
        pullObserverList.add(pullObserver);
    }

    public void batchUpdateObserver(String newState){
        for(PullObserver pullObserver : pullObserverList){
            pullObserver.update(this);
        }
    }
}
