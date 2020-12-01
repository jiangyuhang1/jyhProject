package com.jyh.pattern.actionType.observer.push;

/**
 * 抽象观察者角色
 */
public interface PushObserver {

    /**
     * 提供更新观察者状态入口
     * @param state
     */
    void update(String state);
}
