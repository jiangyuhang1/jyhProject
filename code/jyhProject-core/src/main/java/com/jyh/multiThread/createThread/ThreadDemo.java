package com.jyh.multiThread.createThread;

public class ThreadDemo extends Thread{

    /*
    重写规则：
    1.参数列表必须与父类相同
    2.返回值必须相同
    3.访问修饰符不能比父类更严格
    4.检查型异常不能抛出新的异常，或者比父类异常范围更宽广的异常，只针对检查型异常，
      RunTimeException没有限制
    */
    @Override
    public void run() throws NullPointerException{
        try{
            for(int i = 0; i < 5; i++){
                //使用继承方式，this就可以获取currentThread()
                System.out.println(this.currentThread().getName() + "在运行");
            }
            Thread.sleep(50);
        }catch (InterruptedException e){
            System.out.println(this.currentThread().getName() + "中断");
            //抛出实例，方法必须往外抛异常
            //throw e;
        }
    }
}
