package com.jyh.jvm.gc;

/**
 * 测试强引用
 * 概念：代码中普遍存在。类似于Object obj = new Object()这种形式，只要这种引用存在。垃圾收集器永远不会回收
 * 虚拟机参数：-Xms20M
 *          -Xmx20M
 *          -Xmn10M
 *          -XX:SurvivorRatio=8
 *          -verbose:gc
 *          -XX:+PrintGCDetails
 */
public class StrongReferenceTest {

    private static final int _1MB = 1024 * 1024;
    public static void main(String[] args) {
        byte[] bytes = new byte[4 * _1MB];

        bytes = null;
        System.gc();
    }
}
