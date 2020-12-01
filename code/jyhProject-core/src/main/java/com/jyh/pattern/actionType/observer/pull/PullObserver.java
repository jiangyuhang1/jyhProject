package com.jyh.pattern.actionType.observer.pull;

/**
 * 抽象观察者角色
 */
public interface PullObserver {

    /**
     * 定义一个更新方法，可以根据主题对象更新自身
     * 这里是拉模型的核心
     * @param pullAbstractSubject
     */
    void update(PullAbstractSubject pullAbstractSubject);
}
