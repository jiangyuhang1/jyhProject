package com.jyh.jvm.gc;

import java.lang.ref.SoftReference;

/**
 * 测试软引用
 * 概念：软引用是用来描述一些还有用但并非必需的对象，对于软引用关联着的对象，在系统将要发生内存溢出异常之前，将会把这些对象列进回收范围进行第二次回收
 * 虚拟机参数：-Xms20M
 *          -Xmx20M
 *          -Xmn10M
 *          -XX:SurvivorRatio=8
 *          -verbose:gc
 *          -XX:+PrintGCDetails
 */
public class SoftReferenceTest {

    private static final int _1MB = 1024 * 1024;
    public static void main(String[] args) {
        byte[] bytes = new byte[4 * _1MB];
        SoftReference<byte[]> sr = new SoftReference<byte[]>(bytes);

        /**
         * 此处是为了保证强引用不存在，只为了测试软引用存在的情况下，在内存溢出前将被回收掉
         */
        bytes = null;
        System.gc();


        /**
         * 测试内存溢出的时候软引用对象被回收的场景
         */
        //SoftReference<byte[]> sr0 = new SoftReference<byte[]>(new byte[4 * _1MB]);
        //SoftReference<byte[]> sr1 = new SoftReference<byte[]>(new byte[4 * _1MB]);
        //SoftReference<byte[]> sr2 = new SoftReference<byte[]>(new byte[4 * _1MB]);
        //SoftReference<byte[]> sr3 = new SoftReference<byte[]>(new byte[4 * _1MB]);
        //SoftReference<byte[]> sr4 = new SoftReference<byte[]>(new byte[4 * _1MB]);
        //SoftReference<byte[]> sr5 = new SoftReference<byte[]>(new byte[4 * _1MB]);

        //System.out.println(sr0.get());
        //System.out.println(sr1.get());
        //System.out.println(sr2.get());
        //System.out.println(sr3.get());
        //System.out.println(sr4.get());
        //System.out.println(sr5.get());
    }
}
