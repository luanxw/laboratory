package com.app.luan.handler.byabstarctclass;

import org.springframework.stereotype.Component;

@Component
public class TestHandler extends Handler{

    @Override
    public void doWork(String worker) {
//        super.doWork(worker);
        System.out.println(worker+"已经开始工作.....");
    }

    @Override
    public void afterPropertiesSet() throws Exception {

        Factory.register("test", this);
    }
}
