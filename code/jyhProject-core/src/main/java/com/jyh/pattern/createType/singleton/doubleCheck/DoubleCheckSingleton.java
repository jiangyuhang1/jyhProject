package com.jyh.pattern.createType.singleton.doubleCheck;

/**
 * 双检锁单例模式
 * 相比较饿汉式方法加同步锁，每次调用同步方法获取对象会影响效率，可以使用双检锁，只在第一次创建对象时走同步代码块
 */
public class DoubleCheckSingleton {

    private static DoubleCheckSingleton dcs = null;

    private DoubleCheckSingleton(){

    }

    /**
     * 双检锁方法，第一次创建将进入同步代码块，以后创建对象不会进入同步代码块
     * @return
     */
    public static DoubleCheckSingleton getInstance(){

        if(dcs == null){
            if(dcs == null){
                synchronized(DoubleCheckSingleton.class){
                    dcs = new DoubleCheckSingleton();
                }
            }
        }

        return dcs;
    }
}
