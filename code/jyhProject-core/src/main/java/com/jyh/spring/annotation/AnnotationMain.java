package com.jyh.spring.annotation;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.FileSystemXmlApplicationContext;

public class AnnotationMain {

    public static void main(String[] args){
        ApplicationContext ac = new FileSystemXmlApplicationContext("F:/study/jyhProject/code/jyhProject-core/src/main/resources/com/jyh/spring/annotation/bean.xml");
        Zoo zoo = (Zoo)ac.getBean("zoo");
        String tigerName = zoo.getTiger().toString();
        System.out.println(tigerName);

        ZZoo zzoo = (ZZoo)ac.getBean("ZZoo");
        System.out.println(zzoo.toString());
    }
}
