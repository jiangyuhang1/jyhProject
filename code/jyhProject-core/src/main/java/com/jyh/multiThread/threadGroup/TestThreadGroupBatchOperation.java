package com.jyh.multiThread.threadGroup;

/**
 * 测试线程组批量操作，批量管理线程
 */
public class TestThreadGroupBatchOperation extends Thread{

    public TestThreadGroupBatchOperation(ThreadGroup threadGroup, String name){
        super(threadGroup,name);
    }

    @Override
    public void run() {
        System.out.println("开始死循环: " + this.getName());
        while (!this.isInterrupted()){}
        System.out.println("中断死循环: " + this.getName());
    }

    public static void main(String[] args) throws Exception{
        ThreadGroup threadGroup = new ThreadGroup("线程组");
        Thread thread = null;
        for(int i = 0; i < 5; i++){
            thread = new TestThreadGroupBatchOperation(threadGroup,"线程" + i);
            thread.start();
        }

        Thread.sleep(5000);
        threadGroup.interrupt();
        System.out.println("线程组中断所有线程");
    }
}
