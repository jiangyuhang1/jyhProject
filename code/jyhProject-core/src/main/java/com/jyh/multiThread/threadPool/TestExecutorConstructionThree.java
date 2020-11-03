package com.jyh.multiThread.threadPool;

import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/**
 * 测试ThreadPoolExecutor构造函数参数案例
 * 当缓存队列中的任务数达到上限，但池中运行的线程数小于maximumPoolSize时，此时将继续创建
 */
public class TestExecutorConstructionThree {

    public static void main(String[] args) {
        ThreadPoolExecutor threadPoolExecutor = new ThreadPoolExecutor(2, 3, 60, TimeUnit.SECONDS, new LinkedBlockingQueue<>(1));

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

        //任务三
        /**
         * 等待了任务一的空闲线程执行了此任务
         */
        threadPoolExecutor.execute(new Runnable() {
            @Override
            public void run() {
                System.out.println("线程创建的线程3 " + Thread.currentThread().getName());
            }
        });

        //任务四
        /**
         * 由于workQueue已满，并且此时的池中的线程数达到了2，但是小于最大线程数3，此时的任务4将新建一个线程去执行
         */
        threadPoolExecutor.execute(new Runnable() {
            @Override
            public void run() {
                System.out.println("线程创建的线程4 " + Thread.currentThread().getName());
            }
        });

        threadPoolExecutor.shutdown();
    }
}
