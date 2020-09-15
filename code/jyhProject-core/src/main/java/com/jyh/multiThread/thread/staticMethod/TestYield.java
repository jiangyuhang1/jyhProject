package com.jyh.multiThread.thread.staticMethod;

//测试yield方法
//暂停当前执行运行的程序，并执行其他线程，这个暂停是会放弃CPU资源的，并且放弃CPU的时间不确定
public class TestYield extends Thread{

    @Override
    public void run() {
        long begin = System.currentTimeMillis();
        for(int i = 0; i < 50000; i++){
            Thread.yield();
        }
        long end = System.currentTimeMillis();

        System.out.println(end-begin);
    }

    public static void main(String[] args){
        TestYield ty = new TestYield();
        ty.start();
    }
}
