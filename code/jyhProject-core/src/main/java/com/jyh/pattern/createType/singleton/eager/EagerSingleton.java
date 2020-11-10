package com.jyh.pattern.createType.singleton.eager;


/**
 * 饿汉式单例模式
 * 饿汉式体现在装载类的时候就调用了自己的私有构造方法创建了对象
 * 是一种控件换时间的做法，在没用到的时候就创建了对象，用到的时候不需要在创建节省了时间
 */
public class EagerSingleton {

    /**
     * 线程安全，改创建对象方式线程安全由JVM保证
     */
    private static EagerSingleton es = new EagerSingleton();

    /**
     * 将构造方法申明成私有方法，不允许外部调用构造方法生成其对象
     */
    private EagerSingleton(){

    }

    /**
     * 静态工厂方法，单例模式获取对象的唯一入口
     * @return
     */
    public static EagerSingleton getInstance(){
        return es;
    }
}
