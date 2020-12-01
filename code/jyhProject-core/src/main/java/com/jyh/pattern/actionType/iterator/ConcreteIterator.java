package com.jyh.pattern.actionType.iterator;

/**
 * 具体迭代器角色
 */
public class ConcreteIterator implements Iterator{

    /**
     *
     */
    private ConcreteAggregate ca;

    /**
     * 聚集对象元素个数
     */
    private int size = 0;

    /**
     * 内部索引
     */
    private int index = 0;

    public ConcreteIterator(ConcreteAggregate ca){
        this.ca = ca;
        this.size = ca.getSize();
        index = 0;
    }

    @Override
    public void first() {
        index = 0;
    }

    @Override
    public void next() {
        if(index < size){
            index++;
        }
    }

    @Override
    public Boolean isFinally() {
        return index < size;
    }

    @Override
    public Object currentItem() {
        return ca.getElement(index);
    }
}
