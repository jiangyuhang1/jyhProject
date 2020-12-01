package com.jyh.pattern.actionType.iterator;

/**
 * 抽象迭代器角色，定义操作一个聚集角色的方法
 */
public interface Iterator {

    void first();

    void next();

    Boolean isFinally();

    Object currentItem();
}
