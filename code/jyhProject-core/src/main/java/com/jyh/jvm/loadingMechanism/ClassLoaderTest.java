package com.jyh.jvm.loadingMechanism;

/**
 * 测试相关类加载器
 */
public class ClassLoaderTest {

    public static void main(String[] args) {
        /*
        扩展类加载器加载目录
         */
        System.out.println(System.getProperty("java.ext.dirs"));

        /*
        系统类加载器
         */
        System.out.println(ClassLoader.getSystemClassLoader());

        /*
        系统类加载器加载目录
         */
        System.out.println(System.getProperty("java.class.path"));

        /*
        系统类加载器父类是拓展类加载器
         */
        System.out.println(ClassLoader.getSystemClassLoader().getParent());

        /*
        系统类加载器父类的父类是启动类加载器
         */
        System.out.println(ClassLoader.getSystemClassLoader().getParent().getParent());
    }
}
