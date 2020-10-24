package com.jyh.multiThread.threadGroup;

/**
 * 测试多级关联线程组：使用New ThreadGroup构造函数，可以指定父类线程组
 * 线程必须启动后(start)后，才能归属于到某个线程组
 */
public class TestMultiRelatedThreadGroup implements Runnable{

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

        ThreadGroup parentThreadGroup = new ThreadGroup("父类线程组");
        ThreadGroup childThreadGroup = new ThreadGroup(parentThreadGroup,"子类线程组线程组");

        Thread thread1 = new Thread(parentThreadGroup,testSingleRelatedThreadGroup1);
        Thread thread2 = new Thread(parentThreadGroup,testSingleRelatedThreadGroup2);
        Thread thread3 = new Thread(childThreadGroup,testSingleRelatedThreadGroup3);
        thread1.start();
        thread2.start();
        thread3.start();

        System.out.println("活动的线程数: " + parentThreadGroup.activeCount());
        System.out.println("线程组名称: " + parentThreadGroup.getName());
        System.out.println("活动的线程数: " + childThreadGroup.activeCount());
        System.out.println("线程组名称: " + childThreadGroup.getName());
    }
}
