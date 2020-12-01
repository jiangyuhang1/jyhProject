package com.jyh.pattern.actionType.template;

/**
 * 具体模板角色
 * 作用:1.子类可以替换掉父类中的可变方法，但是不能改变模板方法中的顶级逻辑
 *     2.出现新的应用场景的时候，可以根据应用场景去置换掉模板方法
 *     3.servlet中HttpServlet担任抽象模板方法角色，继承该类的类充当具体模板方法角色
 *       父类中的service()是模板方法，继承的子类可以重写doGet()，doPost()实现不同的业务需求
 */
public class ConcreteTemplate extends AbstractTemplate{

    @Override
    public void abstractMethod() {
        System.out.println("这是一个必须重写的方法");
    }


    @Override
    public void toDo() {
        System.out.println("置换父类的空方法");
        super.toDo();
    }
}
