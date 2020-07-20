package test.annotations.annotation;

import java.lang.annotation.*;
//重写@component
@Target({ElementType.TYPE})
@Retention(RetentionPolicy.RUNTIME)
@Documented
public @interface TestAnnotation {
    String value() default "";
}
