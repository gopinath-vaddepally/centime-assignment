package com.centime.assignment.tasktwo.utils;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.context.annotation.ClassPathScanningCandidateComponentProvider;
import org.springframework.core.type.filter.AnnotationTypeFilter;
import org.springframework.stereotype.Component;

import java.lang.reflect.Method;
import java.lang.reflect.Parameter;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

@Aspect
@Component
public class LogParamMethodAspect {
    private static final Logger logger = LoggerFactory.getLogger(Logger.class);

    @Pointcut(value = "execution(* *.*(..))")
    public void allMethods() {
        logger.info("Inside all methods");
    }

    @Before("execution(* *(..)) && @annotation(logMethodParam)")
    public void startAProcess(JoinPoint jp, LogMethodParam logMethodParam) throws Throwable {
        logParams();
    }

    public static void logParams() {
        ClassPathScanningCandidateComponentProvider scanner = new ClassPathScanningCandidateComponentProvider(true);
        scanner.addIncludeFilter(new AnnotationTypeFilter(LogMethodParam.class));
        for (BeanDefinition bean : scanner.findCandidateComponents("com.centime")) {
            String beanClassName = bean.getBeanClassName();
            try {
                Class<?> annotatedClass = Class.forName(beanClassName);
                Method[] methods = annotatedClass.getMethods();
                for (Method method : methods) {
                    boolean annotationPresent = method.isAnnotationPresent(LogMethodParam.class);
                    if (annotationPresent) {
                        List<Parameter> parameters = Arrays.asList(method.getParameters());
                        List<String> namesList = parameters.stream().map(i -> {
                            return i.getName();
                        }).collect(Collectors.toList());
                        String join = String.join(",", namesList);
                        logger.info("{} method params {} ", method.getName(), join);
                    }
                }
            } catch (ClassNotFoundException e) {
                e.printStackTrace();
            }
            System.out.println(beanClassName);
        }
    }
}
