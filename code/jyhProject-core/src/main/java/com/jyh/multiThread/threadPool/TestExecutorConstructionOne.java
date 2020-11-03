package com.jyh.multiThread.threadPool;

import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/**
 * 测试ThreadPoolExecutor构造函数参数含义
 * 特性一：当池中的线程数包括空闲线程小于corePoolSize时，新建线程执行任务
 */
public class TestExecutorConstructionOne {

    public static void main(String[] args){
        ThreadPoolExecutor threadPoolExecutor = new ThreadPoolExecutor(2,3,60, TimeUnit.SECONDS,new LinkedBlockingQueue<>(1));

        //任务一
        threadPoolExecutor.execute(new Runnable() {
            @Override
            public void run() {
                System.out.println("线程创建的线程1 " + Thread.currentThread().getName());
            }
        });

        //任务二
        threadPoolExecutor.execute(new Runnable() {
            @Override
            public void run() {
                System.out.println("线程创建的线程2 " + Thread.currentThread().getName());
            }
        });

        threadPoolExecutor.shutdown();
    }
}
