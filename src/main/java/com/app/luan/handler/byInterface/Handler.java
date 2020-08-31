package com.app.luan.handler.byInterface;

import org.springframework.beans.factory.InitializingBean;

/**
 *
 * 策略设计模式
 * */

public interface Handler extends InitializingBean {

    public void doWork(String work);
}
