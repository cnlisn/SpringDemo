package com.lisn.demo.core.aop;

import java.lang.annotation.*;

//remark为记录的备注
@Target(ElementType.METHOD)
@Retention(RetentionPolicy.RUNTIME)
@Documented
public @interface AnnotationLog {
    String remark() default "";

}