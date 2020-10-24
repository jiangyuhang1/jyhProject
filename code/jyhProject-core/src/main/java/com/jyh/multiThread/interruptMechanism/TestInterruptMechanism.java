package com.jyh.multiThread.interruptMechanism;

/**
 * 测试中断机制:主要涉及interrupt，isInterrupted,interrupted
 * 中断机制是一种协作模式，并不能直接中断线程，只是给线程一个中断标识位，需要获取中断标识位的线程自己处理
 * 中断方法实现层面jdk看不到，都是虚拟机层面实现的
 * interrupt:设置调用的线程中断标识位
 * isInterrupted:返回一个true Or false，判断调用的线程是否中断，不清除中断标识位，非静态方法
 * interrupted:返回一个true Or false,判断调用的线程是否中断，清除中断标识位,静态方法
 * 上面两个方法调用的是一个native的方法，只是在是否清除标识位的参数上相反
 */
public class TestInterruptMechanism {

    public static void main(String[] args) throws Exception{
        Thread thread = new Thread(()->{
            while (!Thread.interrupted()){
            //while (!Thread.currentThread().isInterrupted()){
                System.out.println("线程没有被中断");
            }

            System.out.println("线程被中断");
        });

        thread.start();
        Thread.sleep(3000);

        thread.interrupt();

        System.out.println("线程中断结束");
    }
}
