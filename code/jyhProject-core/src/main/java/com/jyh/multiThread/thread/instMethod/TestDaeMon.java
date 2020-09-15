package com.jyh.multiThread.thread.instMethod;

//测试setDaeMon()方法
//守护进程，当用户进程结束，守护线程自动结束
public class TestDaeMon extends Thread{

    @Override
    public void run(){
        int i = 0;
        try{
            while (true){
                i++;
                System.out.println(i);
                Thread.sleep(1000);
            }
        }catch(InterruptedException e){
            e.printStackTrace();
        }
    }

    public static void main(String[] args){
        TestDaeMon td = new TestDaeMon();
        //在线程启动之前设置
        td.setDaemon(true);
        td.start();

        try {
            Thread.sleep(5000);
        }catch(InterruptedException e){
            e.printStackTrace();
        }
    }
}
