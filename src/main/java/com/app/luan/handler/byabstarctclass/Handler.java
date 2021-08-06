package com.app.luan.handler.byabstarctclass;

import org.springframework.beans.factory.InitializingBean;

/**
 * 模板方法设计模式
 */
public abstract class Handler implements InitializingBean {


    public void doWork(String worker){
        throw new UnsupportedOperationException();
    }

    public String doWorkOtherthings(String worker){
        throw new UnsupportedOperationException();
    }

}
