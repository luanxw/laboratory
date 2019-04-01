package com.app.luan.JoinTest;


public class JoinTest {
	public static void main(String[] args) {
		MyThread thread = new MyThread();
		thread.start();
		try {
			thread.join();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		System.out.println("我想当ThreadTest对象执行结束之后再执行!");
	}
	static public class MyThread extends Thread{
		@Override
		public void run(){
			System.out.println("我想先执行......");
		}
	}
}
