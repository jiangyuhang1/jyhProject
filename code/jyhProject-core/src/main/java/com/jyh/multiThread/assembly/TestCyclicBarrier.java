package com.jyh.multiThread.assembly;

import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.CyclicBarrier;

/**
 * 测试CyclicBarrier(栅栏)组件案例
 * 概要: 和CountDownLatch都是用作协调多个线程之间工作的工具,将一定数量的线程拦截在调用await方法处
 *      这个数量在实例CyclicBarrier对象时作为参数传入，先到达的线程要等待后到达的线程，所有线程都阻塞在
 *      await处，达到目标数，所有线程统一时间执行
 * 和CountDownLatch区别: 1.CyclicBarrier所有的线程都停留在await处，后面不会执行；CountDownLatch在执行countDown后，
 *      线程还会执行countDown后面的代码
 *      2.CountDownLatch是一定数量的线程达到完成状态去唤醒另外另外一部分线程，CyclicBarrier是一定数量的线程堵塞在某处，
 *      可以唤醒一个BarrierAction线程，等待数量齐在一起执行后面的代码
 *      3.CountDownLatch只能用一次，CyclicBarrier可以reset重复用
 * 注意: 在线程池用CyclicBarrier时，注意线程池的线程数量，如果数量过少，达不到CyclicBarrier要求的数量，会造成死锁
 */
public class TestCyclicBarrier {

    static class CyclicBarrierThread extends Thread{
        private String name;
        private CyclicBarrier cb;
        private int sleepParam;

        public CyclicBarrierThread(String name, CyclicBarrier cb, int sleepParam){
            super(name);
            this.cb = cb;
            this.sleepParam = sleepParam;
        }

        @Override
        public void run() {
            try {
                System.out.println(this.getName() + " 开始工作!工作时间: " + System.currentTimeMillis());
                Thread.sleep(sleepParam * 1000);
                cb.await();
                //cb.reset();
                System.out.println(this.getName() + " 结束工作!工作时间: " + System.currentTimeMillis());
            }catch (InterruptedException e){
                e.printStackTrace();
            }catch (BrokenBarrierException e){
                e.printStackTrace();
            }
        }
    }

    public static void main(String[] args) {
        //CyclicBarrier cb = new CyclicBarrier(3);
        CyclicBarrier cb = new CyclicBarrier(3, new Runnable() {
            @Override
            public void run() {
                System.out.println("所有线程await结束，此时可以执行await之后的代码!当前时间: " + System.currentTimeMillis());
            }
        });
        CyclicBarrierThread cbt1 = new CyclicBarrierThread("线程1", cb, 2);
        CyclicBarrierThread cbt2 = new CyclicBarrierThread("线程2", cb, 4);
        CyclicBarrierThread cbt3 = new CyclicBarrierThread("线程3", cb, 6);
        cbt1.start();
        cbt2.start();
        cbt3.start();
    }
}
