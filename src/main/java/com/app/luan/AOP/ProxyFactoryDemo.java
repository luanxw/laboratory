package com.app.luan.AOP;

import com.app.luan.AOP.service.EchoService;
import com.app.luan.AOP.service.impl.DefaultEchoServiceImpl;
import org.springframework.aop.framework.ProxyFactory;

public class ProxyFactoryDemo {

    public static void main(String[] args) {
        DefaultEchoServiceImpl defaultEchoService = new DefaultEchoServiceImpl();

        //注入目标对象(被代理对象)
        ProxyFactory factory = new ProxyFactory(defaultEchoService);
        EchoService echoService = (EchoService)factory.getProxy();
        System.out.println(echoService.enco("hello word!"));

    }
}
