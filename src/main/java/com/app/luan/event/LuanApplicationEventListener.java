package com.app.luan.event;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.ApplicationListener;

public class LuanApplicationEventListener implements ApplicationListener<LuanApplicationEvent> {

    public static final Logger log = LoggerFactory.getLogger(LuanApplicationEventListener.class);

    @Override
    public void onApplicationEvent(LuanApplicationEvent luanApplicationEvent) {

        log.info("时间luan已经开始执行！！！！");
        System.out.println("执行工作的是: "+luanApplicationEvent.getName());
    }
}
