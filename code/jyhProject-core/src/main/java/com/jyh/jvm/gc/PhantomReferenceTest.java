package com.jyh.jvm.gc;

import java.lang.ref.PhantomReference;
import java.lang.ref.ReferenceQueue;

/**
 * 测试虚引用
 * 概念：虚引用唯一的目的只是跟踪对象的回收,并不决定对象的生命周期，可以当做没有引用存在，可能在任何时候被回收，且必须和引用一起队列使用
 * 虚拟机参数：-Xms20M
 *          -Xmx20M
 *          -Xmn10M
 *          -XX:SurvivorRatio=8
 *          -verbose:gc
 *          -XX:+PrintGCDetails
 */
public class PhantomReferenceTest {

    private static final int _1MB = 1024 * 1024;
    public static void main(String[] args) throws Exception{
        System.out.println("**********虚引用测试**********");

        ReferenceQueue<byte[]> referenceQueue = new ReferenceQueue<byte[]>();

        byte[] bytes = new byte[4 * _1MB];
        PhantomReference<byte[]> pr = new PhantomReference<byte[]>(bytes, referenceQueue);

        bytes = null;
        System.gc();
        System.out.println(referenceQueue.poll());
        Thread.sleep(100);
        System.out.println(referenceQueue.poll());
    }
}
