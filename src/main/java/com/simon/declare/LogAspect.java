package com.simon.declare;

import com.springapp.mvc.HelloController;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

/**
 * Created by Simon on 2015/9/24.
 */
@Component
@Aspect
public class LogAspect {
    static Logger logger = LoggerFactory.getLogger(LogAspect.class);

    @Pointcut("execution(* com.springapp.mvc.*Controller.*(..))")
    public void pointcut(){}

    @Before("pointcut()")
    public void beforeAspect(JoinPoint joinPoint){
        logger.info(joinPoint.getSignature().toString());
    }
}
