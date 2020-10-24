package com.jyh.multiThread.threadGroup;

/**
 * 测试线程组具有自动归属属性
 * 如果实例出来的线程组没有指定父类线程组，那么自动归属于当前线程的线程组中
 */
public class TestThreadAutoBelong {
    public static void main(String[] args){
        System.out.println("A处线程： " + Thread.currentThread().getName() + " A处线程组： " + Thread
                .currentThread().getThreadGroup().getName() + " A处线程组中包含的线程组数： " + Thread
        .currentThread().getThreadGroup().activeGroupCount());

        ThreadGroup threadGroup0 = new ThreadGroup("新的线程组0");
        ThreadGroup threadGroup1 = new ThreadGroup("新的线程组1");

        System.out.println("B处线程： " + Thread.currentThread().getName() + " B处线程组： " + Thread
                .currentThread().getThreadGroup().getName() + " B处线程组中包含的线程组数： " + Thread
                .currentThread().getThreadGroup().activeGroupCount());

        ThreadGroup[] threadGroups = new ThreadGroup[Thread.currentThread().getThreadGroup().activeGroupCount()];

        Thread.currentThread().getThreadGroup().enumerate(threadGroups);

        for(int i = 0; i < threadGroups.length; i++){
            System.out.println(" 线程组" + i + threadGroups[i].getName());
        }
    }
}
