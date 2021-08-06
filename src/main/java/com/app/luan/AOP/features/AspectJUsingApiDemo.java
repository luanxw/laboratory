package com.app.luan.AOP.features;


import com.app.luan.AOP.aspect.AspectConfiguration;
import org.springframework.aop.MethodBeforeAdvice;
import org.springframework.aop.aspectj.annotation.AspectJProxyFactory;
import java.lang.reflect.Method;
import java.util.HashMap;
import java.util.Map;

public class AspectJUsingApiDemo {
    public static void main(String[] args) {

        //创建一个 hashmap 缓存, 作为被代理的对象
        Map<String, Object> cache =  new HashMap<>();

        //创建proxy工厂（aspectj）
        AspectJProxyFactory factory = new AspectJProxyFactory(cache);
        //增加 Aspect 配置类
        factory.addAspect(AspectConfiguration.class);
        factory.addAdvice(new MethodBeforeAdvice() {
            @Override
            public void before(Method method, Object[] objects, Object o) throws Throwable {
                if ("put".equals(method.getName()) && objects.length == 2){
                    System.out.printf("当前存放的Key：%s, Value: %s \n",objects[0],objects[1]);
                }
            }
        });


        //  直接存储
//        cache.put("1","A");
        Map<String, Object> proxy = factory.getProxy();
        proxy.put("1","A");
//        System.out.println(cache.get("1"));
    }
}
