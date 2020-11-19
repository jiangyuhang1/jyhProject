package com.jyh.pattern.structType.proxy.cglib;

/**
 * cglib需要代理的对象，此时可以代理类
 */
public class Dao {

    /**
     * 测试在构造函数调用要拦截的方法
     * 在生成Dao对象时，该方法也会被拦截一边，造成重复
     */
    public Dao(){
        update();
    }


    public void update(){
        System.out.println("更新接口");
    }

    public void select(){
        System.out.println("查询接口");
    }

    public void delete(){
        System.out.println("删除接口");
    }
}
