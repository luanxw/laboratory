package com.app.luan.event;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.context.ConfigurableApplicationContext;

import java.util.Date;

public class ApplicationRun {

    public static void main(String[] args) throws InterruptedException {
        SpringApplication application =  new SpringApplicationBuilder(ApplicationRun.class)
                .listeners(new myListener()).build();
        ConfigurableApplicationContext context = application.run(args);

        context.publishEvent(new myEvent("source","我的⌚", new Date()));

        Thread.sleep(3000);

        context.publishEvent(new myEvent("source","我的⌚", new Date()));


    }
}
