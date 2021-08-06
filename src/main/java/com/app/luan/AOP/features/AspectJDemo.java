package com.app.luan.AOP.features;


import org.aspectj.lang.annotation.Aspect;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.EnableAspectJAutoProxy;

@Aspect    //声明为 Aspect 切面
@Configuration
@EnableAspectJAutoProxy  //激活 Aspect 注解自动代理
public class AspectJDemo {
    public static void main(String[] args) {
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext();
        context.register(AspectJDemo.class);
        context.refresh();

        AspectJDemo aspectJDemo = context.getBean(AspectJDemo.class);


        context.close();
    }
}
