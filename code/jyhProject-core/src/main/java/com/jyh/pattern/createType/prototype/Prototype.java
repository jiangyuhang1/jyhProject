package com.jyh.pattern.createType.prototype;

/**
 * 抽象原型角色，实现了Cloneable接口
 * 是一种创建对象模式，在原有的对象基础上，在堆中创建出和原来一样的对象，指向新的引用
 * 注意: 1.使用Object的clone方法需要实现Cloneable接口，不然抛CloneNotSupportedException
 *      2.clone出来的对象一般满足下面三个条件
 *          x.clone() != x 为true  因为引用不同
 *          x.clone().getClass() == x.getClass() 为true  Class对象相同
 *          x.clone().equals(x)一般相等，一般对象equals方法都是重写了，比较的是对象值，不是引用
 * 作用: 使用的地方不需要直接创建对象，调用对象具体的克隆方法即可，并且clone是native()方法，性能比直接new号
 *      特别对于一个大对象来说
 */
public abstract class Prototype implements Cloneable{

    public Prototype clone(){
        Prototype prototype = null;
        try{
            prototype = (Prototype) super.clone();
        }catch (CloneNotSupportedException e){
            e.printStackTrace();
        }
        return prototype;
    }

    /**
     * 为了测试原型模式所用
     */
    public abstract void show();
}
