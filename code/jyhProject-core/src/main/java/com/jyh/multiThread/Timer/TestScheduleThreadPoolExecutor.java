package com.jyh.multiThread.Timer;

import java.util.Date;
import java.util.concurrent.ScheduledThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/**
 *  测试ScheduleThreadPoolExecutor案例，构造定时任务
 *  构造函数参数:
 *  可传参数: corePoolSize: 核心池大小，
 *          ThreadFactory:生成线程工厂类，
 *          RejectedExecutionHandler:拒绝策略实现类
 *  默认参数: maximumPoolSize: Integer.MAX_VALUE
 *          队列: new DelayedWorkQueue()，是一个初始默认16的有界队列
 *          keepAliveTime: 0 无效参数
 */
public class TestScheduleThreadPoolExecutor {

    public static void main(String[] args){
        ScheduledThreadPoolExecutor scheduledThreadPoolExecutor = new ScheduledThreadPoolExecutor(2);

        /**
         * 时间单位是initialDela和period两个时间的单位
         * 说明: 1.对比于Timer和TimerTask的定时任务来说，一个timer只会创建一个线程，所以多个任务会排队，导致后面的任务因为前面的任务执行时间过长
         *      而执行的时间不是计划的时间，将推迟延后，而ScheduleThreadPoolExecutor定时任务不会存在这个问题，因为会同时创建多个线程
         *      2.Timer的创建的线程没有处理异常，出现问题将终止
         *      3.Timer使用cancel停止，ScheduleThreadPoolExecutor使用shutdown
         */
        scheduledThreadPoolExecutor.scheduleAtFixedRate(new Runnable() {
            @Override
            public void run() {
                System.out.println("线程名: " + Thread.currentThread().getName() + "任务的执行时间: " + new Date());
            }
        },2,2, TimeUnit.SECONDS);

        scheduledThreadPoolExecutor.scheduleAtFixedRate(new Runnable() {
            @Override
            public void run() {
                System.out.println("线程名: " + Thread.currentThread().getName() + "任务的执行时间: " + new Date());
            }
        },2,2, TimeUnit.SECONDS);


        scheduledThreadPoolExecutor.scheduleAtFixedRate(new Runnable() {
            @Override
            public void run() {
                System.out.println("线程名: " + Thread.currentThread().getName() + "任务的执行时间: " + new Date());
            }
        },2,2, TimeUnit.SECONDS);
    }

}
