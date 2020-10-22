package com.jyh.multiThread.producerCustomerModel;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;

/**
 * 使用await和signal来实现生产者和消费者模型
 *
 * 避免假死：新建两个condition,生产者生产之后使用消费者的condition去通知
 *          消费者消费之后使用生产者的condition去通知
 */
public class TestAwaitSignalModel {
    public static String value = "";

    public static void main(String[] args){

        ProducerCustomer producerCustomer = new ProducerCustomer();

        new Thread(() -> {while (true) producerCustomer.setValue();}).start();
        new Thread(() -> {while (true) producerCustomer.setValue();}).start();
        new Thread(() -> {while (true) producerCustomer.getValue();}).start();

    }
}

class ProducerCustomer extends ReentrantLock{

    private Condition producerCondition = newCondition();
    private Condition customerCondition = newCondition();

    public void setValue(){
        try{
            lock();
            if(!"".equals(TestAwaitSignalModel.value)){
                producerCondition.await();
            }
            String value = System.currentTimeMillis() + "_" + System.nanoTime();
            System.out.println(Thread.currentThread().getName() + " 生产者设置的value: " + value);
            TestAwaitSignalModel.value = value;
            customerCondition.signal();
        }catch(InterruptedException e){
            e.printStackTrace();
        }finally {
            unlock();
        }
    }

    public void getValue(){
        try{
            lock();
            if("".equals(TestAwaitSignalModel.value)){
                customerCondition.await();
            }
            System.out.println("消费者消费的value: " + TestAwaitSignalModel.value);
            TestAwaitSignalModel.value = "";
            producerCondition.signal();
        }catch(InterruptedException e){
            e.printStackTrace();
        }finally {
            unlock();
        }
    }
}
