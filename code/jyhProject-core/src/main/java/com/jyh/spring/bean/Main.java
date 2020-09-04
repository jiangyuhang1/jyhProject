package com.jyh.spring.bean;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.FileSystemXmlApplicationContext;

public class Main {
    public static void main(String[] args){
        //可以同时实例多个xml文件，如果不同的xml中有相同的bean id,后实例出来的会覆盖开始实例的
        ApplicationContext ac = new FileSystemXmlApplicationContext("F:/study/jyhProject/code/jyhProject-core/src/main/resources/com/jyh/spring/bean/bean.xml");

        //可以通过设置scope来控制是单例实例化bean对象，还是原型实例化对象
        Person p1 = (Person)ac.getBean("person");
        Person p2 = (Person)ac.getBean("person");
        System.out.println(p1 == p2);//true 说明spring默认用单例模式实例化bean对象

        //如果没有设置lazy-init,会在装配文件的时候就加载class
        EmptyClass ec = (EmptyClass)ac.getBean("emptyClass");
        //关闭bean的装配可以走destroy-method里面的方法
        ((FileSystemXmlApplicationContext)ac).close();

        
    }
}
