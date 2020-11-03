package com.jyh.multiThread.threadPool;

import java.util.LinkedList;
import java.util.List;
import java.util.Random;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/**
 * 测试使用线程池执行多个线程所需要的时间
 * 作用：1、减少了创建和销毁线程的次数，每个工作线程都可以被重复利用，可执行多个任务
 *      2、可以根据系统的承受能力，调整线程池中工作线程的数据，防止因为消耗过多的内存导致服务器崩溃
 */
public class TestUserThreadPool {

    public static void main(String[] args){
        final List<Integer> list = new LinkedList<>();
        final Random random = new Random();

        /**
         * 构造函数有六个参数
         * 线程池创建之后，默认情况下，没有任何线程，等待有任务到来才会去创建线程并执行
         * corePoolSize:核心池大小
         * maximumPoolSize:线程池最大线程数
         * keepAliveTime:空闲线程存活时间,只有当池中的线程数大于corePoolSize时才会起作用，终止空闲线程获取新任务的时间
         * unit:keepAliveTime时间单位
         * workQueue:线程池锁使用的缓冲队列
         * threadFactory:线程池创建线程使用的工厂
         * handler:线程池对于拒绝任务的处理策略
         */
        ThreadPoolExecutor threadPoolExecutor = new ThreadPoolExecutor(100,100,60, TimeUnit.SECONDS,new LinkedBlockingQueue<>(2000));

        long startTime = System.currentTimeMillis();
        for(int i = 0; i < 2000; i++){
            threadPoolExecutor.execute(new Runnable() {
                @Override
                public void run() {
                    list.add(random.nextInt());
                }
            });
        }
        threadPoolExecutor.shutdown();
        try{
            threadPoolExecutor.awaitTermination(1,TimeUnit.DAYS);
        }catch (InterruptedException e){
            e.printStackTrace();
        }

        long endTime = System.currentTimeMillis();

        System.out.println(endTime - startTime);
    }
}
