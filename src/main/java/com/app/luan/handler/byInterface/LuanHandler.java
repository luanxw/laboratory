package com.app.luan.handler.byInterface;

import org.springframework.stereotype.Component;

@Component
public class LuanHandler implements Handler {

    @Override
    public void afterPropertiesSet() throws Exception {
        Factory.register("luan", this);
    }

    @Override
    public void doWork(String work){
        System.out.println("luan 正在做工作.....");
    }

}
