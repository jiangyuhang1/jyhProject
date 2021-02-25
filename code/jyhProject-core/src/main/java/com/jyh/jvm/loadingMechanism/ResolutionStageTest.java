package com.jyh.jvm.loadingMechanism;

/**
 * 测试解析阶段
 * 解析阶段是将常量池中的符号引用替换成直接引用
 */
public class ResolutionStageTest {

    private static int i;
    private double d;

    public static void print() {}

    private boolean trueOrFalse()
    {
        return false;
    }
}
