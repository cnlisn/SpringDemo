package com.lisn.demo.core.startuprunner;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

/**
 * 如果有多个实现类，而我们需要按照一定的顺序执行的话，那应该怎么办
 * 解决方案：在实现类上加上@Order注解指定执行的顺序
 * 需要注意：数字越小，优先级越高，也就是@Order(1)注解的类会在@Order(2)注解的类之前执行。
 */
@Component
@Order(value = 1)
public class StartupRunner1 implements ApplicationRunner {

    private static final Logger logger = LoggerFactory.getLogger(StartupRunner1.class);

    @Override
    public void run(ApplicationArguments var1) throws Exception {
        logger.info("服务器启动成功！<<<<使用ApplicationRunner接口");
    }
}