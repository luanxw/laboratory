package com.app.luan.event;

import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationEvent;


public class LuanApplicationEvent extends ApplicationEvent {

    private String name ;

    public LuanApplicationEvent(ApplicationContext source) {
        super(source);
    }

    public LuanApplicationEvent(ApplicationContext source, String name) {
        super(source);
        this.name = name;
    }

    public void setName(String name){
        this.name = name;
    }

    public String getName(){
        return name;
    }

}
