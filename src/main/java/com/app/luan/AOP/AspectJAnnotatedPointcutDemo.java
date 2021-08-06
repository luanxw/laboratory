package com.app.luan.AOP;


import com.app.luan.AOP.aspect.AspectConfiguration;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.EnableAspectJAutoProxy;

@Configuration
@EnableAspectJAutoProxy  //激活 Aspect 注解自动代理
public class AspectJAnnotatedPointcutDemo {
    public static void main(String[] args) {
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext();
        context.register(AspectJAnnotatedPointcutDemo.class, AspectConfiguration.class);
        context.refresh();

        AspectJAnnotatedPointcutDemo aspectJDemo = context.getBean(AspectJAnnotatedPointcutDemo.class);

        aspectJDemo.execute();

        context.close();
    }

    public void execute(){
        System.out.println("执行execute....");
    }

}
