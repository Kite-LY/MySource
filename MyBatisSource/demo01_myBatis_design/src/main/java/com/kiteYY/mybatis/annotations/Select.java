package com.kiteYY.mybatis.annotations;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * 创建查询注解
 */
@Retention(RetentionPolicy.RUNTIME)//运行时
@Target(ElementType.METHOD) //改变出现位置
public @interface Select {

    /**
     * 配置接受sql语句
     * @return
     */
    String value();
}
