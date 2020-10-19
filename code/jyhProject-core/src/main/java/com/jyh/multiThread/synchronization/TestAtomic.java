package com.jyh.multiThread.synchronization;

import java.util.concurrent.atomic.AtomicInteger;

//测试原子类也无法绝对保证线程安全
//可以保证多个线程操作同一个变量最终结果是对的
//在某些情况下输出结果具有随机性，不是同步锁那种一个时间内只有一个线程在操作，其他线程必须等待，结果有序
//原子性指的是一个操作不可分割，例如a=0;a++是a = a+1可分割，所以这个操作就不是原子性
//线程安全三要素：原子性，可见性，有序性
//synchronized保证了三要素，volatile保证了可见性，有序性，Lock和原子类保证了原子性
public class TestAtomic {
    //默认为0
    private static AtomicInteger ai = new AtomicInteger();
    public void addNum()
    {
        //addAndGet(int val)在原来的数值上+val,并返回相加之后的数值，并更新原来的值
        //getAndAdd(int val)先返回原来的值，在相加更新成现有的数值
        System.out.println(Thread.currentThread().getName() + "加了100之后的结果：" +
                ai.addAndGet(100));
        ai.getAndAdd(1);

    }

    public static void main(String[] args) throws Exception{
        TestAtomic ta = new TestAtomic();
        TestAtomic1[] taArr = new TestAtomic1[5];
        for(int i = 0; i < 5; i++){
            taArr[i] = new TestAtomic1(ta);
        }
        for(int i = 0; i < 5; i++){
            taArr[i].start();
        }
        Thread.sleep(1000);
        System.out.println(TestAtomic.ai.get());
    }
}


class TestAtomic1 extends Thread{
    private TestAtomic ta;

    public TestAtomic1(TestAtomic ta){
        this.ta = ta;
    }

    @Override
    public void run() {
        ta.addNum();
    }
}
