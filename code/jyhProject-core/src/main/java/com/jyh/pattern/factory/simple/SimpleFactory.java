package com.jyh.pattern.factory.simple;

import com.jyh.pattern.factory.MengNiu;
import com.jyh.pattern.factory.Milk;
import com.jyh.pattern.factory.YiLI;

/**
 * 简单工厂
 */
public class SimpleFactory {

    public static Milk getMilk(String milkName) {

        /**
         * 这里如果还要生产其他对象，要不断的if else,可以用反射机制改进
         */
        if("蒙牛".equals(milkName)){
            return new MengNiu();
        }else if("伊利".equals(milkName)){
            return new YiLI();
        }
        return null;
    }

    public static Milk getMilkByReflect(String milkPath) throws Exception{
        /**
         * 获取Class类对象有三种方式
         * className.class: 不执行静态代码块和代码块的内容
         * Class.forName(classPath): 执行静态代码块，不执行代码块
         * Object.getClass(): 由于需要new对象，所以会执行静态代码块和代码块的内容
         */
        Class<?> c = Class.forName(milkPath);
        return (Milk)c.newInstance();
    }
}
