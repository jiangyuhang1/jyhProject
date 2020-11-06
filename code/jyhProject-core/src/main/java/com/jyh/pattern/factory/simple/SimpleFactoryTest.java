package com.jyh.pattern.factory.simple;

import com.jyh.pattern.factory.Milk;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

/**
 * 简单工厂测试类
 */
public class SimpleFactoryTest {

    public static void main(String[] args) {
        /**
         * 调用工厂类直接生成需要的对象
         */
        SimpleFactory.getMilk("蒙牛").getName();

        /**
         * 为了减少简单工厂内部生产对象过多，每次添加都要加if else,这里使用反射机制
         * className可以配置在properties文件中，易于维护
         */
        Properties properties = new Properties();
        try {
            File file = new File("F:/study/jyhProject/code/jyhProject-core/src/main/resources/com/jyh/pattern/pattern.properties");
            InputStream inputStream = new FileInputStream(file);

            //加载properties文件
            properties.load(inputStream);

            Milk milk1 = SimpleFactory.getMilkByReflect(properties.getProperty("mengniu"));
            milk1.getName();

            Milk milk2 = SimpleFactory.getMilkByReflect(properties.getProperty("yili"));
            milk2.getName();
            inputStream.close();
        }catch (IOException e){
            e.printStackTrace();
        }catch (Exception e){
            e.printStackTrace();
        }finally {

        }

    }
}
