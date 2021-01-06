package com.jyh.jvm.oom.metaspace;

import org.springframework.cglib.proxy.Enhancer;
import org.springframework.cglib.proxy.MethodInterceptor;
import org.springframework.cglib.proxy.MethodProxy;

import java.lang.reflect.Method;

/**
 * 测试Metaspace内存溢出场景
 * Metaspace并不在虚拟机内存中而是使用本地内存，理论上取决于操作系统的内存大小
 * JVM参数:-XX:MetaspaceSize=8m
 *        -XX:MaxMetaspaceSize=128m
 *        -XX:+PrintFlagsInitial(打印虚拟机初始化参数)
 */
public class MetaspaceOverflow {

    public static void main(String[] args) {
        int i = 0;

        try {
            for (;;) {
                i++;

                Enhancer enhancer = new Enhancer();
                enhancer.setSuperclass(OOMObject.class);
                enhancer.setUseCache(false);
                enhancer.setCallback(new MethodInterceptor() {
                    public Object intercept(Object obj, Method method, Object[] args, MethodProxy proxy) throws Throwable {
                        return proxy.invokeSuper(obj, args);
                    }
                });
                enhancer.create();
            }
        } catch (Exception e) {
            System.out.println("第" + i + "次时发生异常");
            e.printStackTrace();
        }
    }

    static class OOMObject {

    }
}
