package com.jyh.multiThread.thread.instMethod;

//测试getPriority()和setPriority(int priority)
//线程优先级默认是5,具有继承性如果A线程启动了B线程,B线程具有和A相同的线程
//CPU会优先调用优先级较高的线程
public class TestPriority extends Thread{

    @Override
    public void run() {
        //Thread-1 5
        System.out.println(this.getName() + " " + this.getPriority());
    }
}

class TestPriority1 extends Thread{
    @Override
    public void run() {
        //Thread-0 5
        System.out.println(this.getName() + " " + this.getPriority());
        TestPriority tp = new TestPriority();
        tp.start();
    }

    public static void main(String[] args){
        //在main线程设置级别为4，通过main启动所有线程的级别都为4
        //Thread.currentThread().setPriority(4);
        //main 5
        System.out.println(Thread.currentThread().getName() + " " + Thread.currentThread().getPriority());
        TestPriority1 tp1 = new TestPriority1();
        tp1.start();
    }
}


class TestPriority2 extends Thread{
    @Override
    public void run()
    {
        long beginTime = System.currentTimeMillis();
        for (int j = 0; j < 100000; j++){}
        long endTime = System.currentTimeMillis();
        System.out.println("◆◆◆◆◆ thread0 use time = " +
                (endTime - beginTime));
    }
}

class TestPriority3 extends Thread{
    public void run()
    {
        long beginTime = System.currentTimeMillis();
        for (int j = 0; j < 100000; j++){}
        long endTime = System.currentTimeMillis();
        System.out.println("◇◇◇◇◇ thread1 use time = " +
                (endTime - beginTime));
    }

    public static void main(String[] args)
    {
        for (int i = 0; i < 5; i++)
        {
            TestPriority2 mt0 = new TestPriority2();
            //CPU会尽量将执行资源让给优先级比较高的线程,但也不绝对
            mt0.setPriority(5);
            mt0.start();
            TestPriority3 mt1 = new TestPriority3();
            mt1.setPriority(4);
            mt1.start();
        }
    }
}