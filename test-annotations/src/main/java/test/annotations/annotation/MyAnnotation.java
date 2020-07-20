package test.annotations.annotation;

import java.lang.annotation.*;
//测试注解 /无用
@Target({ElementType.METHOD,ElementType.TYPE})
@Retention(RetentionPolicy.RUNTIME)
@Documented
public @interface MyAnnotation {
    String name() default "我是你爸爸";
    int  age() default 0;
    int  id()  default -1;
    String[]  schools();
}
