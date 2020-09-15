package com.jyh.multiThread.thread.instMethod;

//测试isAlive()、getId()、getName()方法
public class TestIsAlive extends Thread{

    @Override
    public void run() {
        //执行过程中，true
        //id是由线程Id生成器threadSeqNumber生成，new一个实例，自增1，不可设置
        //name可设置 setName()
        System.out.println("id :" + this.getId() + " name :" + this.getName() +" run :" +this.isAlive());
    }

    public static void main(String[] args) throws Exception{
        TestIsAlive mt = new TestIsAlive();
        //新建状态，未处于可运行状态，false
        System.out.println("run :" + mt.isAlive());
        mt.start();

        //加个sleep，确保线程run执行完，走到终止状态TERMINATED
        Thread.sleep(100);
        //线程终止，false
        System.out.println("run :" + mt.isAlive());
    }
}
