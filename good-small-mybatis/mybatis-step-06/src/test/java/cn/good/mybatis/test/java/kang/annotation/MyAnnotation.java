package cn.good.mybatis.test.java.kang.annotation;

/**
 * TODO
 *
 * @Description
 * @Author wkm
 * @Date 2025/1/17
 **/

/**
 * 如何自定义注解
 * 1.注解声明为:@interface
 * 2.内部定义成员，通常使用value表示
 * 3.可以指定成员的默认值，使用default定义
 * 4.如果自定义注解没有成员，表明是一个标识作用
 * 5.如果注解有成员，在使用注解时，需要指明成员的值
 */
public @interface MyAnnotation {
    String value() default "hello";
}
