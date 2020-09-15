package com.jyh.multiThread.thread.instMethod;

//测试join()方法
//可以使调用join方法的子线程所在的主线程无限阻塞，直到子线程执行完毕
//使用场景，主线程要依赖子线程返回结果
//和sleep的区别，join释放锁，sleep不释放锁
public class TestJoin extends Thread{

    @Override
    public void run() {
        try {
            System.out.println(this.getName());
            Thread.sleep(5000);
        }catch (InterruptedException e){
            e.printStackTrace();
        }
    }

    public static void main(String[] args){
        TestJoin tj = new TestJoin();
        tj.start();
        try {
            //tj.join();
            //阻塞2秒
            tj.join(2000);
        }catch (InterruptedException e){
            e.printStackTrace();
        }
        //不加join方法，main线程会先执行完
        //加了join方法，会在5秒之后打印下面的话
        System.out.println("main 等待子线程执行完毕在打印");
    }
}
