package com.jyh.jvm.gc;

/**
 * 测试基于不同的垃圾收集器，对象分配原则是否不同
 * 1.虚拟机配置参数
 *      -verbose:gc
 *      -XX:+PrintGCDetails
 *      -XX:+PrintTLAB
 *      -XX:+UseTLAB
 *      -Xms20M
 *      -Xmx20M
 *      -Xmn10M
 *      -XX:SurvivorRatio=8
 */
public class EdenAllocationTest {

    private static final int _1MB = 1024 * 1024;

    public static void main(String[] args)
    {
        byte[] allocation1 = new byte[2 * _1MB];
        byte[] allocation2 = new byte[2 * _1MB];
        byte[] allocation3 = new byte[3 * _1MB];
    }
}
