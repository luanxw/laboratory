package com.app.luan.proxy;

import java.lang.reflect.Proxy;

public class RunTest {

    public static void main(String[] args) {

        work luan = new Luanimpl();
        workHandler handler = new workHandler(luan);
        work proxy = (work)Proxy.newProxyInstance(luan.getClass().getClassLoader(), luan.getClass().getInterfaces(), handler);
        proxy.doWork("luan");
        System.out.println("luan第一个方法反射调用结束.....!");
        int count = proxy.count(2);
        System.out.println("luan第二个方法返回值："+count);

        work allen = new Allenimpl();
        workHandler handler2 = new workHandler(allen);
        work proxy2 = (work)Proxy.newProxyInstance(allen.getClass().getClassLoader(), allen.getClass().getInterfaces(), handler2);
        proxy2.doWork("allen");
        System.out.println("allen第一个方法反射调用结束.....!");
        int count2 = proxy2.count(2);
        System.out.println("allen第二个方法返回值：" + count2);
    }
}
