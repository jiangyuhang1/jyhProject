package com.jyh.multiThread.thread.instMethod;


//测试start()和run()方法
public class TestRun extends Thread{

    @Override
    public void run()
    {
        try
        {
            for (int i = 0; i < 3; i++)
            {
                Thread.sleep((int)(Math.random() * 1000));
                System.out.println("run = " + Thread.currentThread().getName());
            }
        }
        catch (InterruptedException e)
        {
            e.printStackTrace();
        }
    }

    //cpu执行哪个线程具有不确定性
    public static void main(String[] args)
    {
        TestRun mt = new TestRun();
        //标志该线程可以执行了，等待CPU调用该对象的run方法，产生异步执行的效果
        mt.start();

        //只调用run方法相当于普通的类的实例调用方法，没有异步效果，此时只有一个main主线程，会打印六遍main
        //mt.run();

        try
        {
            for (int i = 0; i < 3; i++)
            {
                Thread.sleep((int)(Math.random() * 1000));
                System.out.println("run = " + Thread.currentThread().getName());
            }
        }
        catch (InterruptedException e)
        {
            e.printStackTrace();
        }
    }
}
