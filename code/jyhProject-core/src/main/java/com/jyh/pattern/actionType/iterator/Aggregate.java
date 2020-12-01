package com.jyh.pattern.actionType.iterator;

/**
 * 抽象聚集角色
 */
public abstract class Aggregate {

    /**
     * 持有创建迭代器角色的接口
     */
    public abstract Iterator createIterator();
}
