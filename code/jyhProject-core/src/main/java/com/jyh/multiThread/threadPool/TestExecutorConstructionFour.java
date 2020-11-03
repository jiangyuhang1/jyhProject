package com.jyh.multiThread.threadPool;

import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/**
 * 测试ThreadPoolExecutor构造函数参数案例
 * 特征四：当池中存在的线程数已经达到maximumPoolSize时，新加入的任务将执行拒绝策略
 *        线程池默认的拒绝策略是抛异常
 *        如果池中的任务执行的够快，线程空闲下来的够快，队列中的任务会不断的获取到空闲线程，也不会执行拒绝策略
 */
public class TestExecutorConstructionFour {

    public static void main(String[] args) {
        ThreadPoolExecutor threadPoolExecutor = new ThreadPoolExecutor(2, 3, 60, TimeUnit.SECONDS, new LinkedBlockingQueue<>(1));

        //任务一
        threadPoolExecutor.execute(new Runnable() {
            @Override
            public void run() {
                try {
                    Thread.sleep(3000);
                    System.out.println("线程创建的线程1 " + Thread.currentThread().getName());
                }catch (InterruptedException e){
                    e.printStackTrace();
                }
            }
        });

        //任务二
        threadPoolExecutor.execute(new Runnable() {
            @Override
            public void run() {
                try {
                    Thread.sleep(5000);
                    System.out.println("线程创建的线程2 " + Thread.currentThread().getName());
                }catch (InterruptedException e){
                    e.printStackTrace();
                }
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
                try {
                    Thread.sleep(2000);
                    System.out.println("线程创建的线程4 " + Thread.currentThread().getName());
                }catch (InterruptedException e){
                    e.printStackTrace();
                }
            }
        });

        //任务五
        /**
         * 由于池中存在的线程数是3，已经达到了maximumPoolSize,对于执行的任务五，将执行拒绝策略
         */
        threadPoolExecutor.execute(new Runnable() {
            @Override
            public void run() {
                System.out.println("线程创建的线程5 " + Thread.currentThread().getName());
            }
        });

        threadPoolExecutor.shutdown();
    }
}
