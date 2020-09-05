package com.jyh.spring.aop;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.context.support.FileSystemXmlApplicationContext;

public class AopMain {
    public static void main(String[] args) {
        //ApplicationContext ac = new FileSystemXmlApplicationContext("F:/study/jyhProject/code/jyhProject-core/src/main/resources/com/jyh/spring/aop/aop.xml");
        ApplicationContext ac = new ClassPathXmlApplicationContext("classpath:com/jyh/spring/aop/aop.xml");

        HelloWorld hw1 = (HelloWorld) ac.getBean("helloWorldImpl1");
        HelloWorld hw2 = (HelloWorld) ac.getBean("helloWorldImpl2");

        hw1.printHelloWorld();
        System.out.println();
        hw1.doPrint();
        System.out.println();

        hw2.printHelloWorld();
        System.out.println();
        hw2.doPrint();
    }
}
