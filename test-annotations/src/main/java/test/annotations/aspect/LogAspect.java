package test.annotations.aspect;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.Signature;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.stereotype.Component;
import test.annotations.annotation.Log;

import java.lang.reflect.Method;
import java.lang.reflect.Modifier;
import java.util.Map;
//aop切面
@Aspect
@Component
public class LogAspect {
    // 配置织入点  @Log注解，只要使用了Log注解就会被执行
    @Pointcut("@annotation(test.annotations.annotation.Log)")
    public void logPointCut()
    {
    }
    /**
     * 处理完请求后执行
     *
     * @param joinPoint 切点
     */
    @AfterReturning(pointcut = "logPointCut()", returning = "jsonResult")
    public void doAfterReturning(JoinPoint joinPoint, Object jsonResult)
    {   //只输出方法名
        System.out.println("目标方法名为:" + joinPoint.getSignature().getName());
        //只输出类名
        System.out.println("目标方法所属类的简单类名:" +        joinPoint.getSignature().getDeclaringType().getSimpleName());
        //全类名
        System.out.println("目标方法所属类的类名:" + joinPoint.getSignature().getDeclaringTypeName());
        //权限
        System.out.println("目标方法声明类型:" + Modifier.toString(joinPoint.getSignature().getModifiers()));
        //输出参数
        Object[] args = joinPoint.getArgs();
        for (int i = 0; i < args.length; i++) {
            System.out.println("第" + (i+1) + "个参数为:" + args[i]);
        }
        System.out.println("被代理的对象:" + joinPoint.getTarget());

        System.out.println("代理对象自己:" + joinPoint.getThis());
        // 获得注解
        Signature signature = joinPoint.getSignature();
        MethodSignature methodSignature = (MethodSignature) signature;
        Method method = methodSignature.getMethod();
        Log controllerLog = method.getAnnotation(Log.class);
        //获取注解的标题名
        System.out.println("标题名:"+controllerLog.title());
        //输出类名
        System.out.println("类名:"+ joinPoint.getTarget().getClass().getName());
        //输出方法名
        System.out.println("类名:"+ joinPoint.getSignature().getName());
        //未知
        System.out.println("类名:"+ joinPoint.getTarget().getClass().getMethods());
        //返回参数
        System.out.println(jsonResult);
    }
}
