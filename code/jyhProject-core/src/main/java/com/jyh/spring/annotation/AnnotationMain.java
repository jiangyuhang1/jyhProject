package com.jyh.spring.annotation;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.context.support.FileSystemXmlApplicationContext;

public class AnnotationMain {

    public static void main(String[] args){
        //ApplicationContext ac = new FileSystemXmlApplicationContext("F:/study/jyhProject/code/jyhProject-core/src/main/resources/com/jyh/spring/annotation/bean.xml");
        //classpath是指当工程代码被编译过后，会在target下面生成classes目录，该目录会把java和resource放在一起，这个classes以下的路径就是classpath路径
        ApplicationContext ac = new ClassPathXmlApplicationContext("classpath:com/jyh/spring/annotation/bean.xml");
        Zoo zoo = (Zoo)ac.getBean("zoo");
        String tigerName = zoo.getTiger().toString();
        System.out.println(tigerName);

        ZZoo zzoo = (ZZoo)ac.getBean("zzoo");
        System.out.println(zzoo.toString());
    }
}
