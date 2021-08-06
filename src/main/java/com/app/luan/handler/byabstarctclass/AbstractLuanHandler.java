package com.app.luan.handler.byabstarctclass;

import org.springframework.stereotype.Component;

@Component
public class AbstractLuanHandler extends Handler {

    @Override
    public void afterPropertiesSet() throws Exception {
        Factory.register("luan", this);
    }

    @Override
    public void doWork(String worker) {
        System.out.println(worker+"已经开始工作.......");
    }

    @Override
    public String doWorkOtherthings(String worker) {
        return worker+"的工作结果.......";
    }
}
