package com.jyh.pattern.actionType.template;

/**
 * 模板方法模式，抽象模板角色
 * 主要包含: 1.模板方法，模板方法由基本方法组成
 *         2.基本方法: 1.具体方法，已实现，一般子类不在重写
 *                   2.钩子方法，一般是空方法，由子类去重写拓展
 *                   3.抽象方法，由子类重写
 */
public abstract class AbstractTemplate {

    /**
     * 模板方法
     */
    public void templateMethod(){
        abstractMethod();
        toDo();
        concreteMethod();
    }

    /**
     * 抽象方法
     */
    public abstract void abstractMethod();


    /**
     * 钩子方法
     */
    public void toDo(){};


    /**
     * 具体方法
     */
    public void concreteMethod(){
        System.out.println("这是个具体方法");
    }
}
