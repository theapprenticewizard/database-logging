package com.theapprenticewizard.databaselogging.application;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class LogAroundDatabaseAspect {

    private final MongoDbLogger mongoDbLogger;

    public LogAroundDatabaseAspect(MongoDbLogger mongoDbLogger) {
        this.mongoDbLogger = mongoDbLogger;
    }

    @Around(value = "execution(public * * (..)) && @annotation(Loggable))")
    public Object log(ProceedingJoinPoint proceedingJoinPoint) throws Throwable {
        Throwable toThrow = null;
        Object returnValue = null;

        try {
            returnValue = proceedingJoinPoint.proceed();
        } catch (Throwable t) {
            toThrow = t;
        }

        mongoDbLogger.info(returnValue);

        if (null != toThrow) {
            throw toThrow;
        }

        return returnValue;
    }
}
