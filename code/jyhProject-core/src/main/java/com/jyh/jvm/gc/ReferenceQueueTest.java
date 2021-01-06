package com.jyh.jvm.gc;

import java.lang.ref.ReferenceQueue;
import java.lang.ref.SoftReference;

/**
 * 测试ReferenceQueue
 * 作用：1.可以用于SoftReference、WeakReference、PhantomReference构造函数时参数传入
 *      2.软引用，弱引用构造函数可以不传，虚引用构造函数必须传这个参数
 *      3.当上述三个引用的对象被回收时，会添加到ReferenceQueue这个队列中
 *      4.可以通过poll()方法不断拿到队列的头元素
 * 虚拟机参数：-Xms20M
 *          -Xmx20M
 *          -Xmn10M
 *          -XX:SurvivorRatio=8
 */
public class ReferenceQueueTest {
    private static final int _1MB = 1024 * 1024;

    public static void main(String[] args) {
        System.out.println("**********引用队列测试**********\n");

        ReferenceQueue<byte[]> referenceQueue = new ReferenceQueue<byte[]>();

        SoftReference<byte[]> sr0 = new SoftReference<byte[]>(new byte[4 * _1MB], referenceQueue);
        SoftReference<byte[]> sr1 = new SoftReference<byte[]>(new byte[4 * _1MB], referenceQueue);
        SoftReference<byte[]> sr2 = new SoftReference<byte[]>(new byte[4 * _1MB], referenceQueue);
        SoftReference<byte[]> sr3 = new SoftReference<byte[]>(new byte[4 * _1MB], referenceQueue);
        SoftReference<byte[]> sr4 = new SoftReference<byte[]>(new byte[4 * _1MB], referenceQueue);
        SoftReference<byte[]> sr5 = new SoftReference<byte[]>(new byte[4 * _1MB], referenceQueue);

        System.out.println("**********软引用关联的对象展示**********");
        System.out.println(sr0 + "---" + sr0.get());
        System.out.println(sr1 + "---" + sr1.get());
        System.out.println(sr2 + "---" + sr2.get());
        System.out.println(sr3 + "---" + sr3.get());
        System.out.println(sr4 + "---" + sr4.get());
        System.out.println(sr5 + "---" + sr5.get());

        System.out.println("**********引用队列中的SoftReference展示**********");
        System.out.println(referenceQueue.poll());
        System.out.println(referenceQueue.poll());
        System.out.println(referenceQueue.poll());
        System.out.println(referenceQueue.poll());
        System.out.println(referenceQueue.poll());
        System.out.println(referenceQueue.poll());
    }
}
