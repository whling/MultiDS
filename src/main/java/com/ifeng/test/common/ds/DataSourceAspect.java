package com.ifeng.test.common.ds;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.aspectj.lang.reflect.MethodSignature;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import java.lang.reflect.Method;

/**
 * Created by whling on 2017/12/12.
 */
@Component
@Aspect
public class DataSourceAspect {

    private static final Logger logger = LoggerFactory.getLogger(DataSourceAspect.class);

    @Pointcut("execution(* com.ifeng.test.dao.mapper..*.*(..))")
    public void intercept() {
    }

    @Before("intercept()")
    public void before(JoinPoint joinPoint) throws Exception {
        Object target = joinPoint.getTarget();
        String methodName = joinPoint.getSignature().getName();

        Class<?>[] parameterTypes = ((MethodSignature) joinPoint.getSignature()).getMethod().getParameterTypes();
        Class<?>[] clazzs = target.getClass().getInterfaces();
        try {
            Method method = clazzs[0].getMethod(methodName, parameterTypes);
            if (null != method && method.isAnnotationPresent(DataSource.class)) {
                String key = method.getAnnotation(DataSource.class).value();
                DynamicDs.setKey(key);
                logger.debug("method {} use dataSource key is:{}", new Object[]{methodName, key});
            }
        } catch (Exception e) {
            logger.error("method {} get dataSource key occur exception", methodName, e);
        }
    }

    @After("intercept()")
    public void after() {
        DynamicDs.remove();
        logger.debug("remove key");
    }

}
