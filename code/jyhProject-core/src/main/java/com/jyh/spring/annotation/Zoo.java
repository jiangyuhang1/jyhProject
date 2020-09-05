package com.jyh.spring.annotation;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Service;

//使用注解的方式实例bean，默认生产的bean id是类名首字母小写zoo
//@Service表名下面的类是一个bean
@Service
//和xml里配置一样，这里也可以指定实例对象的方式是单例还是原型，默认单例
@Scope("prototype")
public class Zoo {

    //会自动在上下文寻找bean,来注入到Zoo里
    //如果找不到bean，又想使用@Autowired就可以默认不必须，找不到默认是Null
    @Autowired(required = false)
    private Tiger tiger;

    //如果不同包下面有同样类名的类，会生成同名的bean，导致Spring容器会抛出BeanDefinitionStoreException异常
    @Autowired
    private Monkey monkey;

    /*
    public void setTiger(Tiger tiger) {
        this.tiger = tiger;
    }

    public void setMonkey(Monkey monkey) {
        this.monkey = monkey;
    }
    */

    public Tiger getTiger() {
        return tiger;
    }

    public Monkey getMonkey() {
        return monkey;
    }

    public String toString() {
        return tiger + "\n" + monkey;
    }
}
