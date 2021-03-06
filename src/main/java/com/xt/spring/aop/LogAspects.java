package com.xt.spring.aop;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.*;
import org.springframework.core.annotation.Order;

import java.util.Arrays;

/**
 * 切面类
 *
 * @Aspect： 告诉Spring当前类是一个切面类
 *
 */
@Aspect
public class LogAspects {

    // 抽取公共的切入点表达式
    // 1.本类引用
    // 2.其他的切面引用
    @Pointcut("execution(public int com.xt.spring.aop.MathCalculator.*(..))")
    public void pointcut() {}

    //@Before在目标方法之前切入；切入点表达式（指定在哪个方法切入）
    @Before("com.xt.spring.aop.LogAspects.pointcut()")
    public void logStart(JoinPoint joinPoint) {
        Object[] args = joinPoint.getArgs();
        System.out.println("" + joinPoint.getSignature().getName() + "除法运行。。。@Before:参数列表：{" + Arrays.toString(args) + "}");
    }

    @After("pointcut()")
    public void logEnd(JoinPoint joinPoint) {
        System.out.println("" + joinPoint.getSignature().getName() + "除法结束。。。@After");
    }

    //JoinPoint一定要出现在参数表的第一位
    @AfterReturning(value = "pointcut()", returning = "result")
    public void logReturn(JoinPoint joinPoint, Object result) {
        System.out.println("" + joinPoint.getSignature().getName() + "除法正常返回。。。@AfterReturning: 运算结果：{" + result + "}");
    }

    @AfterThrowing(value = "pointcut()", throwing = "exception")
    public void logException(JoinPoint joinPoint, Throwable exception) {
        System.out.println("" + joinPoint.getSignature().getName() + "除法异常。。。@AfterThrowing：异常信息：{" +  exception +"}");
    }

    /**
     * 添加了 Around 后异常信息不打印了
     * @param proceedingJoinPoint
     * @return
     */
    @Around(value = "pointcut()")
    public Object logAround(ProceedingJoinPoint proceedingJoinPoint) {
        Object result = null;
        System.out.println("在方法之前执行 logAround");
        try {
            result = proceedingJoinPoint.proceed();
        } catch (Throwable throwable) {
            throwable.printStackTrace();
        }
        System.out.println("在方法之后执行 logAround\t" + result);
        return result;
    }
}
