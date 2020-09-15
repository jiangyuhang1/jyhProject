package com.jyh.multiThread.synchronization;

//测试线程异常，会释放同步锁
//当线程持有的对象锁运行的时候发生异常，会导致该线程释放对象锁，其他线程此时可以进入
public class TestExceptionReleaseLock {

    public synchronized void method(String flag){
        if("a".equals(flag)) {
            System.out.println(Thread.currentThread().getName());
            try {
                int i = Integer.MAX_VALUE;
                while (true) {
                    int j = 2 / i;
                    i--;
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }else{
            System.out.println(Thread.currentThread().getName());
        }
    }

    public static void main(String[] args){
        TestExceptionReleaseLock ter = new TestExceptionReleaseLock();
        TestExceptionReleaseLock1 ter1 = new TestExceptionReleaseLock1(ter);
        TestExceptionReleaseLock2 ter2 = new TestExceptionReleaseLock2(ter);
        ter1.start();
        ter2.start();
    }
}

class TestExceptionReleaseLock1 extends Thread{
    private TestExceptionReleaseLock ter;

    public TestExceptionReleaseLock1(TestExceptionReleaseLock ter){
        this.ter = ter;
    }

    @Override
    public void run() {
        ter.method("a");
    }
}

class TestExceptionReleaseLock2 extends Thread{
    private TestExceptionReleaseLock ter;

    public TestExceptionReleaseLock2(TestExceptionReleaseLock ter){
        this.ter = ter;
    }

    @Override
    public void run() {
        ter.method("b");
    }
}
