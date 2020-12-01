package com.jyh.pattern.actionType.iterator;

/**
 * 具体聚集角色
 * 这是一种黑箱聚集方法，迭代方法写在具体聚集角色内部类中
 */
public class ConcreteAggregateInner extends Aggregate {

    private Object[] obj = null;

    public ConcreteAggregateInner(Object[] obj){
        this.obj = obj;
    }

    @Override
    public Iterator createIterator() {
        return new ConcreteIteratorInner();
    }

    /**
     * 内部类实现迭代器
     */
    private class ConcreteIteratorInner implements Iterator{
        private int size = 0;

        private int index = 0;

        private ConcreteIteratorInner(){
            this.size = obj.length;
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
            return obj[index];
        }
    }
}
