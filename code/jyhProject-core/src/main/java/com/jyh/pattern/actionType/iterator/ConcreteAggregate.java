package com.jyh.pattern.actionType.iterator;

/**
 * 具体聚集角色
 * 这是一种白箱聚集写法
 */
public class ConcreteAggregate extends Aggregate{

    /**
     * 由一个数组维护所有元素
     */
    private Object[] obj;

    public ConcreteAggregate(Object[] obj){
        this.obj = obj;
    }

    /**
     * 将当前聚集对象传给具体迭代器角色，迭代方法在聚集对象外面，白箱聚集
     * @return
     */
    @Override
    public Iterator createIterator() {
        return new ConcreteIterator(this);
    }

    public Object getElement(int index){
        if(index < obj.length){
            return obj[index];
        }
        return null;
    }

    public int getSize(){
        return obj.length;
    }
}
