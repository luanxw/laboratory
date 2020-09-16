package com.app.luan.proxy;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

public class workHandler implements InvocationHandler {

    private Object object;

    public workHandler(Object object){
        this.object = object;
    }



    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        System.out.println("开始执行代理.....");

         if (method.getName().equals("doWork")){
                method.invoke(this.object, args);
                return proxy;
         }else{
            return method.invoke(this.object, args);
        }

    }
}
