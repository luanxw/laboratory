package com.app.luan.Thread.LockTest;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class UseSingleConditionWaitNotify {
	/**
	 *
	 * synchronized关键字与wait()和notify/notifyAll()方法相结合可以实现等待/通知机制，
	 * ReentrantLock类当然也可以实现，但是需要借助于Condition接口与newCondition() 方法。
	 * Condition是JDK1.5之后才有的，它具有很好的灵活性，
	 * 比如可以实现多路通知功能也就是在一个Lock对象中可以创建多个Condition实例（即对象监视器），
	 * 线程对象可以注册在指定的Condition中，从而可以有选择性的进行线程通知，在调度线程上更加灵活。
	 * @param args
	 */
	public static void main(String[] args) {

		Myservice myservice = new Myservice();
		Myservice.MyThread myThread = new Myservice.MyThread(myservice);
		myThread.start();
		try {
			Thread.sleep(3000);
			myservice.signal();
		}catch (InterruptedException e){
			e.getStackTrace();
		}

	}
	static public class Myservice {
		private Lock lock = new ReentrantLock();
		public Condition condition = lock.newCondition();

		public void await() throws InterruptedException {
			lock.lock();
			try {
				System.out.println("wait 的时间是："+System.currentTimeMillis());
				condition.await();
				System.out.println("condition.await之后的语句：，我是需要在condition.signal()之后才被执行"+System.currentTimeMillis());
			}finally {
				lock.unlock();
			}
		}

		public void signal() throws InterruptedException  {
			lock.lock();
			try {
				System.out.println("signal 的时间是："+System.currentTimeMillis());
				condition.signal();
				Thread.sleep(2000);
				System.out.println("我是condition.signal()之后的语句"+System.currentTimeMillis());
			}finally {
				lock.unlock();
			}
		}

		static public class MyThread extends Thread{
			private Myservice myService;
			public MyThread(Myservice myService){
				super();
				this.myService = myService;
			}
			@Override
			public void run(){
				try {
					myService.await();
				}catch (InterruptedException e){
					e.getStackTrace();
				}
			}
		}
	}

	/*
	*后记：
	* 在使用wait/notify实现等待通知机制的时候我们知道必须执行完notify()方法所在的synchronized代码块后才释放锁。
	* 在这里也差不多，必须执行完signal所在的try语句块之后才释放锁，condition.await()后的语句才能被执行。
	*
	* 注意： 必须在condition.await()方法调用之前调用lock.lock()代码获得同步监视器，不然会报错。
	* */
}
