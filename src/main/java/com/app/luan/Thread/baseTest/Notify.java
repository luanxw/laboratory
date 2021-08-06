package com.app.luan.Thread.baseTest;

public class Notify {

    private static Object lock = new Object();

    static class luan implements Runnable{
        @Override
        public void run() {
            synchronized (lock){
                System.out.println(Thread.currentThread().getName()+":开始执行了!");
                try {
                    lock.notify();
                    Thread.sleep(1000);
                    lock.wait();
                    System.out.println(Thread.currentThread().getName()+":被唤醒了!");
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }finally {
                    lock.notify();
                }
            }
        }
    }


    static class allen implements Runnable{
        @Override
        public void run() {
            synchronized (lock){
                System.out.println(Thread.currentThread().getName()+":开始执行了!");
                try {
                    lock.notify();
                    Thread.sleep(1000);
                    lock.wait();
                    System.out.println(Thread.currentThread().getName()+":被唤醒了!");
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }finally {
                    lock.notify();
                }
            }
        }
    }

    public static void main(String[] args) throws InterruptedException {
        new Thread(new luan()).start();
        Thread.sleep(1000);
        new Thread(new allen()).start();
    }
}

