package com.app.luan.Thread.baseTest;

public class ObjectLock {

    private static Object lock = new Object();
    private static Object A = new Object();
    private static Object B = new Object();

    static class PrintName implements Runnable{
        @Override
        public void run() {
           synchronized (A){
               System.out.println(Thread.currentThread().getName()+": 开始执行");

               try {
                   Thread.sleep(100);
               } catch (InterruptedException e) {
                   e.printStackTrace();
               }
               synchronized (B){
                   for (int i=0; i< 15; i++){
                       System.out.println(Thread.currentThread().getName()+"输出结果是："+i);
                   }
               }
           }
        }
    }

    static class PrintThread implements Runnable{
        @Override
        public void run() {
            synchronized (B){
                System.out.println(Thread.currentThread().getName()+": 开始执行");
                synchronized (A){
                    for (int i=0; i< 15; i++){
                        System.out.println(Thread.currentThread().getName()+"输出结果是："+i);
                    }
                }

            }
        }
    }


    public static void main(String[] args) {
        new Thread(new PrintName()).start();
        new Thread(new PrintThread()).start();
    }
}
