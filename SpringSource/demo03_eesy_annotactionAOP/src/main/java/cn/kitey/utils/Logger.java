package cn.kitey.utils;


import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.*;
import org.springframework.stereotype.Component;

/**
 * 用于记录日志的工具类
 */
@Component("logger")
@Aspect//表示当前类是一个切面类
public class Logger {

    //配置切入点表达式

    @Pointcut("execution(* cn.kitey.service.*.*(..))")
    private void prt(){}


   /* *//**
     * 用于记录日志的方法，计划让其在切入点给方法执行之前进行执行（切入点给方法就是业务层方法）
     *//*
    @Before("prt()")
    public void beforePrintLog(){
        System.out.println("printLog 前置通知开始记录日志！");
    }

    *//**
     * 后置通知
     *//*
    @AfterReturning("prt()")
    public void AfterReturnPrintLog(){
        System.out.println("printLog后置通知 开始记录日志！");
    }

    *//**
     * 异常通知
     *//*
    @AfterThrowing("prt()")
    public void ThrowPrintLog(){
        System.out.println("printLog 异常通知开始记录日志！");
    }

    *//**
     * 最终通知
     *//*
    @After("prt()")
    public void AfterPrintLog(){
        System.out.println("printLog 最终通知开始记录日志！");
    }
*/
    /**
     * 环绕通知
     * 解析：
     *      Spring框架为我们提供了一个接口：ProceedingJoinPoint.该接口有一个方法proceed（）
     *      此方法相当于明确的调用切入点给方法，该接口可以作为环绕通知的方法参数，程序执行时，
     *      Spring框架会为我们提供该接口的实现类供我们使用
     *
     *
     * @return
     */
    @Around("prt()")
    public Object aroundPrint(ProceedingJoinPoint pro){
        try {

            System.out.println("aroundPrint 环绕开始记录日志！--------前置！");
            //得到方法执行的所需要的参数
            Object[] args = pro.getArgs();

            System.out.println("aroundPrint 环绕开始记录日志！--------后置！");
            //明确调用的业务层方法（切入点方法）
            Object proceed = pro.proceed(args);

            return proceed;
        } catch (Throwable e) {
            System.out.println("aroundPrint 环绕开始记录日志！--------异常！");
           throw new RuntimeException(e);

        } finally {
            System.out.println("aroundPrint 环绕开始记录日志！--------最终！");
        }

    }
}
