package com.app.luan.AOP.pointcut;

import org.springframework.aop.support.StaticMethodMatcherPointcut;

import java.lang.reflect.Method;
import java.util.Objects;

public class EchoServicePointcut extends StaticMethodMatcherPointcut {

    public EchoServicePointcut(String methodName, Class targetClass) {
        this.methodName = methodName;
        this.targetClass = targetClass;
    }

    private String methodName;

    private Class targetClass;

    @Override
    public boolean matches(Method method, Class<?> aClass) {
        return Objects.equals(methodName, method.getName()) && this.targetClass.equals(aClass);
    }


    public String getMethodName() {
        return methodName;
    }

    public void setMethodName(String methodName) {
        this.methodName = methodName;
    }

    public Class getTargetClass() {
        return targetClass;
    }

    public void setTargetClass(Class targetClass) {
        this.targetClass = targetClass;
    }


}
