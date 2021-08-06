package com.app.luan.Thread.baseTest;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Semaphore;
import java.util.concurrent.atomic.AtomicInteger;

public class atom {
     private static Semaphore flag = new Semaphore(2);
//     private static Semaphore flag = new Semaphore(1);
     private static AtomicInteger atomicInteger = new AtomicInteger(2);
     private static final String INFO = ": 获取信号量成功";
     ExecutorService pools = Executors.newCachedThreadPool();

     Runnable run1 = new Runnable(){
          @Override
          public void run() {
               try {
                    System.out.println(Thread.currentThread().getName()+":尝试获取信号量");
                    flag.acquire();
                    System.out.println(Thread.currentThread().getName()+INFO);
                    Thread.sleep(2000);
                    flag.release();
               } catch (InterruptedException e) {
                    e.printStackTrace();
               }
          }
     };

     Runnable run2 = new Runnable(){
          @Override
          public void run() {
               try {
                    System.out.println(Thread.currentThread().getName()+":尝试获取信号量");
                    flag.acquire();
                    System.out.println(Thread.currentThread().getName()+INFO);
                    flag.release();
               } catch (InterruptedException e) {
                    e.printStackTrace();
               }
          }
     };

     Runnable run3 = new Runnable(){
          @Override
          public void run() {
               try {
                    System.out.println(Thread.currentThread().getName()+":尝试获取信号量");
                    flag.acquire();
                    System.out.println(Thread.currentThread().getName()+INFO);
                    flag.release();
               } catch (InterruptedException e) {
                    e.printStackTrace();
               }
          }
     };

     public static void main(String[] args) throws InterruptedException {
          atom atom = new atom();
          new Thread(atom.run1).start();
          new Thread(atom.run3).start();
          new Thread(atom.run2).start();

     }




}
