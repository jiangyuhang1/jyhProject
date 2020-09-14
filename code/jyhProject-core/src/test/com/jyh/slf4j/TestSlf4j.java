package com.jyh.slf4j;
import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
/*
    一：slf4j不提供日志的具体实现,只有slf4j是无法打印日志的，是典型的门面模式
    二：当有多个实现类的时候，会打印有多个实现，列举哪些实现，以及实际的实现
    三：slf4j定义了STATIC_LOGGER_BINDER_PATH这个字符串org/slf4j/impl/StaticLoggerBinder.class，每个实现类下面都有这个class
    四：编译器会自动绑定一个实现，在日志中会体现
*/
public class TestSlf4j {
    @Test
    public void testSlf4j() {
        Logger logger = LoggerFactory.getLogger(TestSlf4j.class);
        //logger.error("123");

        //日志级别由低到高分别是trace-->debug-->info-->warn-->error
        logger.trace("=====trace=====");
        logger.debug("=====debug=====");
        logger.info("=====info=====");
        logger.warn("=====warn=====");
        logger.error("=====error=====");
    }
}