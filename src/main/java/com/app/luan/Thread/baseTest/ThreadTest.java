package com.app.luan.Thread.baseTest;

public class ThreadTest {

    public static void main(String[] args) {
//        Test1 t1 = new Test1();
//        Test2 t2 = new Test2();
//        Thread thread = new Thread(t2);
//        thread.start();
//        t1.start();
//        thread.run();
//        t1.run();
        //java8函数式编程，启用Java内部类
        new Thread(()->{
            for (int i=0; i<12;i++){
                System.out.println("i的值为："+i);
            }
        }).start();
    }

}
