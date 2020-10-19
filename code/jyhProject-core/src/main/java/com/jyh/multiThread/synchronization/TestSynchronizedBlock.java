package com.jyh.multiThread.synchronization;

//测试同步代码块
//当A线程访问方法中非同步代码块的内容时，B线程同时能够访问方法中非同步代码块的内容
//当A线程访问方法中同步代码块的内容时，B线程想访问同步块中的内容时，此时将被阻塞
public class TestSynchronizedBlock {

    public void method(){
        for(int i = 0; i < 10; i++){
            System.out.println(Thread.currentThread().getName() + "--" + i);
        }
        System.out.println();

        //同步代码块，当一个方法中不是所有的内容都要加同步锁
        synchronized(this){
            for(int i = 0; i < 10; i++) {
                System.out.println(Thread.currentThread().getName() + "--" + i);
            }
        }
    }

    public static void main(String[] args){
        TestSynchronizedBlock tsb = new TestSynchronizedBlock();
        TestSynchronizedBlock1 tsb1 = new TestSynchronizedBlock1(tsb);
        TestSynchronizedBlock1 tsb2 = new TestSynchronizedBlock1(tsb);
        tsb1.start();
        tsb2.start();
    }
}

class TestSynchronizedBlock1 extends Thread{
    private TestSynchronizedBlock tsb;

    public TestSynchronizedBlock1(TestSynchronizedBlock tsb){
        this.tsb = tsb;
    }

    @Override
    public void run() {
        tsb.method();
    }
}
