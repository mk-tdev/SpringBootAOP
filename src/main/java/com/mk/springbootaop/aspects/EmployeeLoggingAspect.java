package com.mk.springbootaop.aspects;

import com.mk.springbootaop.model.Employee;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;
import org.springframework.web.ErrorResponse;

import java.time.Instant;

@Aspect
@Component
public class EmployeeLoggingAspect {

    @Pointcut("execution(public * com.mk.springbootaop.dao.impl.EmployeeDAOImpl.add*(..))")
    private void afterAddEmployee() {}

    @Pointcut("execution(public * com.mk.springbootaop.dao.impl.EmployeeDAOImpl.get*(..))")
    private void aroundGetEmployee() {}

    @After("afterAddEmployee()")
    public void afterAddEmployeeAdvice() {
        System.out.println("Aspect: After around AddEmployee");
    }

    @Around(value = "aroundGetEmployee()")
    public Object aroundAddEmployeeAspect(ProceedingJoinPoint joinPoint) throws Throwable {
        System.out.println("===== Around Advice: Before method execution =====");
        System.out.println("Method: " + joinPoint.getSignature().getName());
        System.out.println("Arguments: " + java.util.Arrays.toString(joinPoint.getArgs()));
        Object result = null;
        try {
            result = joinPoint.proceed();
            System.out.println(result);
        } catch (Exception e) {
            System.out.println("Exception: " + joinPoint.getSignature().getName());
            System.out.println("Exception: " + e.getMessage());

//            throw e;
            result = "Exception: ";
            return Employee.builder()
                    .id(-1)
                    .name("Error Employee")
                    .employeeId("ERROR")
                    .department("N/A")
                    .build();
        }
        return result;
    }
}
