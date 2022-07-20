package com.app.luan.event;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationEvent;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;

import java.util.Date;

public class myEvent extends ApplicationEvent {

    public String my;

    public Date time;

    public myEvent(Object source, String my,Date time) {
        super(source);
        this.my = my;
        this.time = time;
    }

}
