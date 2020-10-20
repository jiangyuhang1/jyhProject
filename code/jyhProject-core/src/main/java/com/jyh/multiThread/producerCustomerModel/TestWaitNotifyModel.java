package com.jyh.multiThread.producerCustomerModel;

/**
 * 使用wait和notify实现生产者消费者模型
 * 生产者消费者模型需要关注以下几点
 * 一：生产者生产的时候消费者不能消费
 * 二：消费者消费的时候生产者不能生产
 * 三：缓冲区空时消费者不能消费
 * 四：缓冲区满时生产者不能生产
 */
public class TestWaitNotifyModel {

    /**
     * 用value值作为缓冲区，生产者消费者的仓库
     */
    public static String value = "";

    public static void main(String[] args){
        Object lock = new Object();

        Producer producer = new Producer(lock);
        Customer customer = new Customer(lock);
        new Thread(() -> {while (true) producer.setValue();}).start();
        new Thread(() -> {while (true) customer.getValue();}).start();
    }
}

class Producer{
    private Object lock;

    public Producer(Object lock){
        this.lock = lock;
    }

    public void setValue(){
        try{
            synchronized (lock){

                //当value有值时，生产者进行等待，在消费者消费完之后在生产
                if(!"".equals(TestWaitNotifyModel.value)){
                    lock.wait();
                }
                String value = System.currentTimeMillis() + "_" + System.nanoTime();
                System.out.println("生产者设置的value: " + value);
                TestWaitNotifyModel.value = value;
                lock.notify();
            }
        }catch (InterruptedException e){
            e.printStackTrace();
        }
    }
}

class Customer{
    private Object lock;

    public Customer(Object lock){
        this.lock = lock;
    }

    public void getValue(){
        try{
            synchronized (lock){

                //当value为空时，消费者进行等待，等待生产者生产过后再消费
                if("".equals(TestWaitNotifyModel.value)){
                    lock.wait();
                }
                System.out.println("消费者消费的的value: " + TestWaitNotifyModel.value);
                TestWaitNotifyModel.value = "";
                lock.notify();
            }
        }catch (InterruptedException e){
            e.printStackTrace();
        }
    }
}
