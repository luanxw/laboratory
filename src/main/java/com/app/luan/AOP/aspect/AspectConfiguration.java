package com.app.luan.AOP.aspect;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;

@Aspect
public class AspectConfiguration {

    @Pointcut("execution(public * *(..))")    //匹配 Join Point
    private void anyPublicMethod(){ // 方法名称 Pointcut 名
        System.out.println("@Pointcut at any public method.");
    }

    @Before("anyPublicMethod()")  //具体的Join Point 执行动作
    public void beforePublicMethod(){
        System.out.println("@Before any public method.");
    }
}
