package com.jyh.pattern.createType.singleton.lazyInit;

/**
 * 延迟加载的单例模式
 * 该种模式即保证了线程安全，也保证了性能问题
 * 对比与饿汉式，在使用的时候才会创建对象，节省了空间
 * 对比与懒汉式，不需要走同步代码方法，节省了时间
 * 对比与双检锁式，不需要判断对象是否存在，也不需要在第一次创建的时候走同步代码块
 */
public class Singleton {

    private Singleton(){}

    private static class InnerSingleton{

        /**
         * 由JVM保证线程安全
         */
        private static Singleton singleton = new Singleton();
    }

    /**
     * 延迟加载，在使用该对象时在加载静态内部类
     * @return
     */
    public static Singleton getInstance(){
        return InnerSingleton.singleton;
    }
}
