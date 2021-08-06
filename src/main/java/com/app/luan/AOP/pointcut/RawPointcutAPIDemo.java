package com.app.luan.AOP.pointcut;

import com.app.luan.AOP.service.EchoService;
import org.springframework.aop.framework.ProxyFactory;
import org.springframework.aop.support.DefaultPointcutAdvisor;

public class RawPointcutAPIDemo {

    public int TestRetrun(int s){
        try {
            System.out.println("传递字符串："+s);
            return s;
        }finally {
            s++;
            System.out.println("finally执行:"+s);
        }
    }


    public static void main(String[] args) {
        EchoServicePointcut pointcut = new EchoServicePointcut("echo", EchoService.class);

        //将Pointcut 适配晟Advisor

//        DefaultPointcutAdvisor advisor = new DefaultPointcutAdvisor(pointcut, null);

//        ProxyFactory proxyFactory = new ProxyFactory();
        RawPointcutAPIDemo demo = new RawPointcutAPIDemo();
        int res=demo.TestRetrun(1);
        System.out.println(res);



    }
}
