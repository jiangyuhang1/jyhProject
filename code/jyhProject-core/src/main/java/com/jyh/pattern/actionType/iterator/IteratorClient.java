package com.jyh.pattern.actionType.iterator;

/**
 * 迭代器模式测试客户端
 */
public class IteratorClient {

    public static void main(String[] args) {
        String[] strs = new String[]{"a","b","c","d","e"};
        ConcreteAggregate ca = new ConcreteAggregate(strs);
        Iterator iterator = ca.createIterator();

        while(iterator.isFinally()){
            System.out.println(iterator.currentItem());
            iterator.next();
        }
    }
}
