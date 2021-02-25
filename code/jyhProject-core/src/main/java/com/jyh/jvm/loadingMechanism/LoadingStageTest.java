package com.jyh.jvm.loadingMechanism;

/**
 * 测试类加载阶段
 * 1.预加载
 * 概念：虚拟机启动时加载，加载的是JAVA_HOME/lib/下的rt.jar下的.class文件，这个jar包里面的内容是程序运行时非常常常用到的，
 * 像java.lang.*、java.util.*、java.io.*等等，因此随着虚拟机一起加载
 * 虚拟机参数：-XX:+TraceClassLoading
 */
public class LoadingStageTest {

    public static void main(String[] args) {

    }
}
