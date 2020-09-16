package com.app.luan.proxy;

import org.springframework.stereotype.Component;
import org.springframework.util.Assert;

@Component
public class Luanimpl implements work {



    @Override
    public void doWork(String work){
        Assert.notNull(work, "work 不能为空！");
        System.out.println(work+" 正在做工作.....");
    }

    @Override
    public int count(int value) {
        return value*2+12;
    }

}
