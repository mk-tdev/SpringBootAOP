package com.mk.springbootaop.aspects;

import com.mk.springbootaop.model.Product;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.*;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.stereotype.Component;

import java.util.Arrays;

@Aspect
@Component
public class MyLoggingAspect {

    // Point cut expressions
    // execution(modifiers-pattern?
    // return-type-pattern declaring-type-pattern method-name-pattern(param-patter) throws patters? )

    @Pointcut("execution(public * getProduct*())")
    private void getProductPointcut() {}

    @Pointcut("execution(* getProduct*())")
    private void afterGetProductPointcut() {}

    @Pointcut("execution(* getProductDetail(..))")
    private void afterGetProductDetailPointcut() {}

    @Before("execution(public void com.mk.springbootaop.dao.impl.ProductDAOImpl.addProduct())")
    public void beforeAddProductAdvice(JoinPoint joinPoint) {
        System.out.println("Logging: Before add product");
    }

    @After("execution(public void add*(com.mk.springbootaop.model.Product, ..))")
    public void afterAddProductAdvice(JoinPoint joinPoint) {
        System.out.println("Logging: After add product **");
    }

    @Before("getProductPointcut()")
    public void beforeAddProductAdvice() {
        System.out.println("Logging: Before get product via aspect");
    }

    @After("afterGetProductPointcut() || afterGetProductDetailPointcut()")
    public void afterGetProductAdvice(JoinPoint joinPoint) {
        MethodSignature methodSignature = (MethodSignature) joinPoint.getSignature();

        System.out.println("Logging: After get product" + methodSignature);
    }

    @AfterReturning(
            pointcut = "afterGetProductDetailPointcut()",
            returning = "result"
    )
    public void afterReturningAdvice(JoinPoint joinPoint, Product result) {
        MethodSignature methodSignature = (MethodSignature) joinPoint.getSignature();
        System.out.println("Logging: After returning product" + methodSignature.toShortString());

        result.setName("Override name");
        System.out.println(result);
    }

    @AfterThrowing(
            pointcut = "afterGetProductDetailPointcut()",
            throwing = "theExc"
    )
    public void afterThrowingAdvice(
            JoinPoint joinPoint, Throwable theExc
    ) {
        System.out.println("Logging: After throwing product");
        System.out.println(theExc);
    }

    @Around("execution(* getSample*())")
    public void aroundAdvice(ProceedingJoinPoint proceedingJoinPoint) throws Throwable {
        System.out.println("Logging: Before around product");
        System.out.println(proceedingJoinPoint.getSignature().toShortString());

        try {
            Object result = proceedingJoinPoint.proceed();
            System.out.println(result);
        } catch(Exception ec) {
            System.out.println("Exception: " + ec);
        }


        System.out.println("Logging: After around product");
    }
}
