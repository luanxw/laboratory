package com.app.luan.DesignPattern.Singleton;

public class SingletonMix {
    // 私有构造
    private SingletonMix() {}

    private static SingletonMix single = null;

    public static SingletonMix getInstance() {
        
        // 等同于 synchronized public static SingletonMix getInstance()
        synchronized(SingletonMix.class){
          // 注意：里面的判断是一定要加的，否则出现线程安全问题
            if(single == null){
                single = new SingletonMix();
            }
        }   
        return single;
    }
}