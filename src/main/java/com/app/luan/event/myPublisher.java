package com.app.luan.event;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.stereotype.Component;

import java.util.Date;

@Component
public class myPublisher {

    @Autowired
    private ApplicationEventPublisher publisher;

    public void publisher (String my, Date time){
        myEvent myEvent = new myEvent("source",my,time);
        publisher.publishEvent(myEvent);

    }
}
