package com.jyh.multiThread.assembly;

import java.util.concurrent.CountDownLatch;

/**
 * 测试CountDownLatch(计数器同步工具类)使用案例
 * 作用：一：类似于一种通知等待模型
 *         1.Object中的wait/notify/notifyAll 一个线程达到预期状态或结束可以唤醒一个或多个在wait的线程
 *         2.ReentrantLock中的newCondition的await/signal/signalAll 一个线程达到预期状态可以唤醒一个或多个await的线程
 *         3.CountDownLatch中的countDown/await 多个线程达到预期状态或者结束可以唤醒一个或多个在await的线程
 *      二:基本原理
 *         1.CountDownLatch的构造方法传入数量，该数量代表有多少个线程达到预期状态或者结束时才可以唤醒调用await方法的线程
 *         2.调用countDown方法时，执行一次，计数减一，当计数为0时，唤醒调用await的线程
 *         3.不可以传小于0的数值，否则抛异常
 *
 */
public class TestCountDownLatch {

    static class WorkThread extends Thread{
        private String name;
        private CountDownLatch cl;
        private int sleepParam;

        public WorkThread(String name, CountDownLatch cl, int sleepParam){
            super(name);
            this.cl = cl;
            this.sleepParam = sleepParam;
        }

        @Override
        public void run() {
            try{
                System.out.println(Thread.currentThread().getName() + " start time " + System.currentTimeMillis());
                cl.countDown();
                Thread.sleep(sleepParam * 1000);
                System.out.println(Thread.currentThread().getName() + " end time " + System.currentTimeMillis());
            }catch (InterruptedException e){
                e.printStackTrace();
            }
        }
    }

    static class DoneThread extends Thread{
        private String name;
        private CountDownLatch cl;

        public DoneThread(String name, CountDownLatch cl){
            super(name);
            this.cl = cl;
        }

        @Override
        public void run() {
            try {
                System.out.println(Thread.currentThread().getName() + " start time " + System.currentTimeMillis());
                cl.await();
                System.out.println(Thread.currentThread().getName() + " end time " + System.currentTimeMillis());
            }catch (InterruptedException e){

            }
        }
    }

    public static void main(String[] args) {
        CountDownLatch cl = new CountDownLatch(3);

        DoneThread doneThread1 = new DoneThread("doneThread1", cl);
        DoneThread doneThread2 = new DoneThread("doneThread2", cl);
        doneThread1.start();
        doneThread2.start();

        WorkThread workThread1 = new WorkThread("workThread1", cl, 2);
        WorkThread workThread2 = new WorkThread("workThread2", cl, 3);
        WorkThread workThread3 = new WorkThread("workThread3", cl, 4);

        workThread1.start();
        workThread2.start();
        workThread3.start();
    }
}
