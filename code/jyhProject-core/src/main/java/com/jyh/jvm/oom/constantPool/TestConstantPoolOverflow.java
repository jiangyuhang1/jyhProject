package com.jyh.jvm.oom.constantPool;

import java.util.ArrayList;
import java.util.List;

/**
 * 测试常量池内存溢出，由于jdk1.7之后常量池从方法区移除到了堆中，所以将不会报PermGen space
 * 这里将报Java heap space
 * jdk1.7后参数
 * -Xmx5M
 * -Xmn5M
 * -XX:+HeapDumpOnOutOfMemoryError
 * jdk1.7之前参数
 * -XX:PermSize=10M -XX:MaxPermSize=10M
 */
public class TestConstantPoolOverflow {

    public static void main(String[] args) {
        List<String> list = new ArrayList<String>();
        int i = 0;
        while (true)
        {
            list.add(String.valueOf(i++).intern());
        }
    }
}
