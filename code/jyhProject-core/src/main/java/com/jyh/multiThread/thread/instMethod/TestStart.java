package com.jyh.multiThread.thread.instMethod;


//测试start()方法
public class TestStart extends Thread{

    @Override
    public void run() {
        System.out.println(this.currentThread().getName());
    }

    public static void main(String[] args){
        TestStart mt1 = new TestStart();
        TestStart mt2 = new TestStart();
        TestStart mt3 = new TestStart();

        //执行结果具有随机性，并不是按照start的顺序执行的，线程启动的顺序具有不确定性
        mt1.start();
        mt2.start();
        mt3.start();
    }
}
