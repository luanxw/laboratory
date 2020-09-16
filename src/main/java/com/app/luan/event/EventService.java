package com.app.luan.event;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.BeansException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.stereotype.Service;

@Service
public class EventService implements ApplicationContextAware {

    private static Logger log = LoggerFactory.getLogger(EventService.class);

    private ApplicationContext context;

    @Override
    public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {

        log.debug("Autowired applicationContext");
        this.context = applicationContext;
    }

    public void persistEvent(String name){

        LuanApplicationEvent applicationEvent = new LuanApplicationEvent(context, name);
        log.debug("begain publish evnet LuanApplicationEvent");
        this.context.publishEvent(applicationEvent);
    }

}
