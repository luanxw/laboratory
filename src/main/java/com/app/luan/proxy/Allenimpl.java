package com.app.luan.proxy;

import org.springframework.stereotype.Component;

@Component
public class Allenimpl implements work {



    @Override
    public void doWork(String work){
        System.out.println(work+" 开始工作.....");
    }

    @Override
    public int count(int value) {
        return value*2;
    }

}
