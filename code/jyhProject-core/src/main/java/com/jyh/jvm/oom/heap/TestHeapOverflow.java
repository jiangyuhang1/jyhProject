package com.jyh.jvm.oom.heap;

import java.util.ArrayList;
import java.util.List;

/**
 * 测试堆溢出案例
 * VM参数：
 * -Xms20M
 * -Xmx20M
 * -XX:+HeapDumpOnOutOfMemoryError
 * -XX:HeapDumpPath=F:\study\jyhProject\dump.hprof
 */
public class TestHeapOverflow {

    public static void main(String[] args) {

        List<TestUser> list = new ArrayList<>();
        while (true){
            list.add(new TestUser("1","zhangsan"));
        }
    }
}
