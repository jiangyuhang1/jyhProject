package com.jyh.pattern.actionType.iterator;

/**
 * 迭代器测试客户端
 */
public class IteratorClientInner {

    public static void main(String[] args) {

        String[] strs = new String[]{"a","b","c","d","e"};
        ConcreteAggregateInner ca = new ConcreteAggregateInner(strs);

        Iterator iterator = ca.createIterator();
        while (iterator.isFinally()){
            System.out.println(iterator.currentItem());
            iterator.next();
        }
    }
}
