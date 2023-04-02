package com.zxt.helper.config;

/**
 * @author TanXiao
 * @date 2023-03-30
 */
import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.*;
import org.springframework.stereotype.Component;

import java.util.Arrays;

@Aspect
@Component
@Slf4j
public class BizLogAspects {

    /**
     * 抽取切入点表达式
     * <li>本类引用：pointcut()</li>
     */
    @Pointcut("execution(public * com.zxt.helper.common.Biz.*.*(..))")
    public void pointcut(){ }


    @Before("pointcut()")  //目标方法运行之前运行
    public void logStart(JoinPoint joinPoint){
        log.info(""+joinPoint.getSignature().getName()+"方法运行.......参数列表:{"+Arrays.asList(joinPoint.getArgs()) +"}");
    }

    @After("pointcut()")//目标方法运行之后(无论方法正常结束还是异常结束)
    public void logEnd(JoinPoint joinPoint){
        log.info(""+joinPoint.getSignature().getName()+"方法结束.......");
    }

    @AfterReturning(value="pointcut()",returning = "result")    //返回通知
    public void logReturn(JoinPoint joinPoint, Object result){
        log.info(""+joinPoint.getSignature().getName()+"方法结果返回.......运行结果{"+result+"}");
    }

    @AfterThrowing(value = "pointcut()",throwing = "exception")   //异常通知
    public void logException(JoinPoint joinPoint,Exception exception){
        log.info(""+joinPoint.getSignature().getName()+"方法异常.......异常结果{"+exception+"}");
    }

    //    @Around(value = "pointcut()")
//    public void logAround(JoinPoint joinPoint){
//        System.out.println(""+joinPoint.getSignature().getName()+"运行.......@Around");
//    }
}