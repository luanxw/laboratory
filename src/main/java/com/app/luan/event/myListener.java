package com.app.luan.event;

import org.springframework.context.ApplicationListener;
import org.springframework.stereotype.Component;

@Component
public class myListener implements ApplicationListener<myEvent> {
    @Override
    public void onApplicationEvent(myEvent myEvent) {
        System.out.println("myListener接收到事件，时间:"+myEvent.time+",信息内容："+ myEvent.my);
    }


}
