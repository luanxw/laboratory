package com.app.luan.handler.byInterface;

import org.springframework.stereotype.Component;

@Component
public class AllenHandler implements Handler {

    @Override
    public void doWork(String work) {
        System.out.println("Allen 开始工作.......");
    }

    @Override
    public void afterPropertiesSet() throws Exception {
        Factory.register("allen" , this);
    }

}
