package com.jyh.multiThread.threadGroup;

/**
 * 线程组作用：可以批量管理线程或线程组对象，有效地对线程或线程组对象进行组织。
 * 测试线程组一级关联：只有父子对象
 * 可以先创建一个线程，再将线程归属于到某个线程组
 */
public class TestSingleRelatedThreadGroup implements Runnable{

    @Override
    public void run() {
        try{
            while (!Thread.currentThread().isInterrupted()){
                System.out.println("当前线程: " + Thread.currentThread().getName());
                Thread.sleep(2000);
            }
        }catch(InterruptedException e){
            e.printStackTrace();
        }
    }

    public static void main(String[] args){
        TestSingleRelatedThreadGroup testSingleRelatedThreadGroup1 = new TestSingleRelatedThreadGroup();
        TestSingleRelatedThreadGroup testSingleRelatedThreadGroup2 = new TestSingleRelatedThreadGroup();
        TestSingleRelatedThreadGroup testSingleRelatedThreadGroup3 = new TestSingleRelatedThreadGroup();

        ThreadGroup threadGroup1 = new ThreadGroup("线程组1");
        ThreadGroup threadGroup2 = new ThreadGroup("线程组2");

        Thread thread1 = new Thread(threadGroup1,testSingleRelatedThreadGroup1);
        Thread thread2 = new Thread(threadGroup1,testSingleRelatedThreadGroup2);
        Thread thread3 = new Thread(threadGroup2,testSingleRelatedThreadGroup3);
        thread1.start();
        thread2.start();
        thread3.start();

        System.out.println("活动的线程数: " + threadGroup1.activeCount());
        System.out.println("线程组名称: " + threadGroup1.getName());
        System.out.println("活动的线程数: " + threadGroup2.activeCount());
        System.out.println("线程组名称: " + threadGroup2.getName());
    }
}
