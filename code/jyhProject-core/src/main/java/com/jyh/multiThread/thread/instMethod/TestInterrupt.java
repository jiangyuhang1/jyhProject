package com.jyh.multiThread.thread.instMethod;

//测试interrupt()和isInterrupted()
public class TestInterrupt extends Thread{
    @Override
    public void run() {
        for(int i = 0; i < 1000; i++){
            System.out.println(i);
        }
    }

    public static void main(String[] args){
        TestInterrupt ti = new TestInterrupt();
        ti.start();

        try{
            Thread.sleep(20);
        }catch (InterruptedException e){
            e.printStackTrace();
        }
        //意图在线程执行20ms之后中断，事实上run一直执行完了
        //真正作用是线程阻塞的时候，给个中断信号，退出阻塞
        ti.interrupt();
    }
}
