package com.jyh.multiThread.threadPool;

import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/**
 * 测试ThreadPoolExecutor构造参数
 * 特性二：当池中运行的线程数大于等于corePoolSize时，新加的任务加入到workQueue中，
 *       如果workQueue长度允许的时候，workQueue中的线程等待空闲线程出现时在执行
 */
public class TestExecutorConstructionTwo {

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
         * 由于corePoolSize的大小为2，所以在workQueue未满的情况下最多创建2个线程
         * 此时workQueue中的任务将等待最先执行完的空闲线程去执行
         */
        threadPoolExecutor.execute(new Runnable() {
            @Override
            public void run() {
                System.out.println("线程创建的线程3 " + Thread.currentThread().getName());
            }
        });

        threadPoolExecutor.shutdown();
    }
}
