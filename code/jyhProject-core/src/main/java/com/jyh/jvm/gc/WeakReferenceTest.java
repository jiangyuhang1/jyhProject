package com.jyh.jvm.gc;

import java.lang.ref.WeakReference;

/**
 * 测试弱引用
 * 概念：弱引用也是用来描述非必需对象的，但是它的强度比软引用更弱一些，被弱引用关联的对象，只能生存到下一次垃圾收集发生之前。
 * 当垃圾收集器工作时，无论当前内存是否足够，都会回收掉只被弱引用关联的对象。
 * 虚拟机参数：-Xms20M
 *          -Xmx20M
 *          -Xmn10M
 *          -XX:SurvivorRatio=8
 *          -verbose:gc
 *          -XX:+PrintGCDetails
 */
public class WeakReferenceTest {

    private static final int _1MB = 1024 * 1024;
    public static void main(String[] args) {
        System.out.println("**********弱引用测试**********");

        WeakReference<byte[]> wr = new WeakReference<byte[]>(new byte[4 * _1MB]);
        System.out.println("GC前：" + wr.get());

        System.gc();
        System.out.println("GC后：" + wr.get());
    }
}
