package test.annotations.annotation;

import java.lang.annotation.*;

/**
 * 日志注解
 */
@Target({ ElementType.PARAMETER, ElementType.METHOD })
@Retention(RetentionPolicy.RUNTIME)
@Documented
public @interface Log {
    /**
     * 模块
     * title :注解标题名
     */
    public String title() default "";
}
