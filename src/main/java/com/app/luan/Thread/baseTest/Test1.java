package com.app.luan.Thread.baseTest;

public class Test1 extends Thread{

    @Override
    public void run(){
        for (int i =0 ; i < 100; i++){
            System.out.println("继承run方法运行。。。");
        }
    }

}
