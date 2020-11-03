package com.jyh.multiThread.threadPool;

import java.util.concurrent.Executors;

/**
 * 测试Executors下面四种线程池
 * workQueue排队策略:直接提交(SynchronousQueue)、(无界队列)LinkedBlockingQueue、有界队列(ArrayBlockingQueue)
 * 有界队列相对于无界队列的缺点：
 * 1.需要平衡corePoolSize,maximumPoolSize数值大小，避免一些任务被拒绝处理，对于开发难度太大
 * 使用无界队列，不需要考虑maximumPoolSize大小，只需要设置根据系统处理能力设置好corePoolSize就行了
 * 2.防止业务突刺,web可能会突然有巨大的访问量，有界队列平衡不好会造成大量的任务会被拒绝处理
 * 四种拒绝策略(父接口RejectedExecutionHandler):
 * 1.AbortPolicy: 丢弃并抛异常RejectedExecutionException，jdk默认此策略
 * 2.DiscardPolicy: 直接丢弃不抛异常
 * 2.CallerRunsPolicy: 主线程尝试直接运行被拒绝的任务，线程池关闭，任务丢弃
 * 3.DiscardOldestPolicy: 当任务被拒绝的时候，将队列中最开始加入的任务移除，将当前被拒绝的任务加入到队列中
 *
 */
public class TestExecutors {

    public static void main(String[] args){
        /**
         * 单线程线程池
         * corePoolSize: 1
         * maximumPoolSize: 1 由于队列无界，改值不起作用
         * keepAliveTime: 0 该值是空闲线程的结束时间，当线程数大于corePoolSize才会起作用，由于是单线程线程池，不起作用
         * 缓冲队列: new LinkedBlockingQueue<>() 无界的缓冲队列
         */
        Executors.newSingleThreadExecutor();

        /**
         * 固定线程数线程池
         * corePoolSize: nThreads 该线程池最多存在nThreads个线程
         * maximumPoolSize: nThreads 由于队列无界，改值不起作用
         * keepAliveTime: 0 该值是空闲线程的结束时间，当线程数大于corePoolSize才会起作用，由于是单线程线程池，不起作用
         * 缓冲队列: new LinkedBlockingQueue<>() 无界的缓冲队列
         */
        Executors.newFixedThreadPool(100);

        /**
         * 无界线程池
         * corePoolSize: 0 该参数不起作用
         * maximumPoolSize: Integer.MAX_VALUE,近似无限大的最大线程数
         * keepAliveTime: 60 空闲线程的存活时间，60s未被使用将被收回
         * unit : s
         * 缓冲队列: new SynchronousQueue<Runnable>() 没有容量一说，直接提交，主要是maximumPoolSize起作用
         */
        Executors.newCachedThreadPool();


        /**
         * 直接调用ScheduleThreadPoolSize的构造函数，用于定时任务
         */
        Executors.newScheduledThreadPool(100);
    }
}
