package com.app.luan.Thread.LockTest;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class ReentrantLockTest {

	/**
	 *
	 *  Lock的简单使用
	 * Lock lock= new ReentrantLock()；
	 *  lock.lock();
	 * try
	 * {
	 * } finally
	 * {
	 *   lock .unlock();
	 * }
	 *
	 * 当一个线程运行完毕后才把锁释放，其他线程才能执行，其他线程的执行顺序是不确定的。
	 */

	public static void main(String[] args) {
		MyService service = new MyService();

		MyThread a = new MyThread(service);
		MyThread a1 = new MyThread(service);
		MyThread a2 = new MyThread(service);
		MyThread a3 = new MyThread(service);
		MyThread a4 = new MyThread(service);
		a.start();
		a1.start();
		a2.start();
		a3.start();
		a4.start();
	}
	static public class MyService{
		private Lock  lock = new ReentrantLock();
		public void testMethod(){
			lock.lock();
			try {
				for (int i = 0 ; i < 5 ; i++){
					System.out.println("ThreadName:"+Thread.currentThread().getName()+"  "+(i+1));
				}
			}finally{
				lock.unlock();
			}
		}
	}
	static public class MyThread extends Thread{
		private MyService myService;
		public MyThread(MyService myService){
			super();
			this.myService =myService;
		}
		@Override
		public void run(){
            myService.testMethod();
		}
	}
}
