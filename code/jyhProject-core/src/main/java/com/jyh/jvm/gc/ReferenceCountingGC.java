package com.jyh.jvm.gc;

/**
 *  确认虚拟机寻找回收对象的方式
 *  1.如果使用的引用计数法来查找回收对象，下面的案例对象互相引用，将不会被回收
 *  2.事实上被回收了，证明不是通过引用计数法来查找回收对象，这种方式会导致互相引用的对象永远不会回收
 *  虚拟机参数：-verbose:打印粗略的gc信息
 *           -XX:+PrintGCDetails:打印详细的gc信息
 */
public class ReferenceCountingGC {

    private Object instance = null;
    private static final int _1MB = 1024 * 1024;

    /** 这个成员属性唯一的作用就是占用一点内存 */
    private byte[] bigSize = new byte[2 * _1MB];

    public static void main(String[] args)
    {
        ReferenceCountingGC objectA = new ReferenceCountingGC();
        ReferenceCountingGC objectB = new ReferenceCountingGC();
        objectA.instance = objectB;
        objectB.instance = objectA;
        objectA = null;
        objectB = null;

        System.gc();
    }
}
