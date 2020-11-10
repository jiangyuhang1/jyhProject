package com.jyh.pattern.createType.singleton.lazy;

/**
 * 懒加载单例模式
 * 以时间换空间的思路，获取对象时判断是否已创建，浪费了时间，但是不需要在类加载的时候就创建对象
 * 与饿汉式的区别在于不是在类加载的时候创建对象
 */
public class LazySingleton {

    private static LazySingleton ls = null;

    private LazySingleton(){}

    /**
     * 静态工厂方法，synchronized线程安全版
     * @return
     */
    public static synchronized LazySingleton getInstance(){
        if(ls == null){
            ls = new LazySingleton();
        }
        return ls;
    }
}
