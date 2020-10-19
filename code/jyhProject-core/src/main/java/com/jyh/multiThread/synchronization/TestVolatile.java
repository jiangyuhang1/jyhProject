package com.jyh.multiThread.synchronization;

//测试volatile的使用
//java有一块主内存，不同的线程有自己的工作内存，当线程使用一个变量的时候会从主内存拷贝一份到自己的工作内存中
//volatile修饰的变量保证的变量的可见性，每次都能从主内存读取变量值
//volatile保证线程之间的可见性，synchronized既保证了原子性，也保证可见性
//因为synchronized无论是同步的方法还是同步的代码块，都会先把主内存的数据拷贝到工作内存中，
//同步代码块结束，会把工作内存中的数据更新到主内存中，这样主内存中的数据一定是最新的
public class TestVolatile extends Thread{
    //保证各线程之前变量的可见性
    private volatile boolean flag = true;

    public void setFlag(boolean flag){
        this.flag = flag;
    }

    @Override
    public void run() {
        System.out.println(Thread.currentThread().getName() + " start!");
        while (flag == true){}
        System.out.println(Thread.currentThread().getName() + " end!");
    }

    public static void main(String[] args){
        TestVolatile tv = new TestVolatile();
        tv.start();
        tv.setFlag(false);
        //System.out.println(Thread.currentThread().getName() + " end!");
    }
}
