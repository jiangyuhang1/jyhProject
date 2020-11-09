package com.jyh.multiThread.assembly;

import java.util.concurrent.Semaphore;

/**
 * 测试Semaphore(信号)案例
 * 概要: 是一种并发控制器，用于管理信号量，用于控制并发量，在需要控制并发量的代码出用acquire()获取信号量，在执行完的
 *      地方release()释放信号，如果构造时的信号量被acquire完，此时后面的线程将被阻塞，需要等到release之后执行
 * 说明：1.Semaphore构造函数可设置一个程序的最大并发量
 *      2.Semaphore构造函数可指定是否公平锁
 *      3.acquire()和release()可以用参数指定获取和释放多少信号量
 */
public class TestSemaphore {

    public static void main(String[] args) {
        Semaphore semaphore = new Semaphore(5,true);
        Runnable runnable = new Runnable() {
            @Override
            public void run() {
                try{
                    /**
                     * 可以指定一个线程一次获取几个信号量
                     */
                    semaphore.acquire(2);
                    System.out.println(Thread.currentThread().getName() + " 获得信号: " + System.currentTimeMillis());
                    Thread.sleep(2000);
                }catch (InterruptedException e){
                    e.printStackTrace();
                }finally {
                    /**
                     * 可以指定一个线程一次释放几个信号量
                     */
                    semaphore.release(2);
                    System.out.println(Thread.currentThread().getName() + " 释放信号: " + System.currentTimeMillis());
                }
            }
        };

        Thread[] threads = new Thread[10];
        for(int i = 0; i < 10; i++){
            threads[i] = new Thread(runnable);
        }

        for(int i = 0; i < 10; i++){
            threads[i].start();
        }
    }
}
