package com.app.luan.Thread;

public class MyThread extends Thread{

	private int count = 5;

//	public  MyThread(String name){
//		super();
//		this.setName(name);
//	}
//	@Override
//	public  void run(){
//		super.run();
//		while(count > 0){
//			count --;
//			System.out.println("由"+MyThread.currentThread().getName()+"计算，count = "+count);
//		}
////		System.out.println("It is MyThread !");
//	}
	@Override
	public void run(){
		super.run();
			count --;
			System.out.println("由"+MyThread.currentThread().getName()+"计算，count = "+count+"线程标识符"+MyThread.currentThread().getId());
//		System.out.println("It is MyThread !");
	}
	public static void main(String[] args) {
		MyThread thread = new MyThread();
		Thread A = new Thread(thread,"A");
		Thread B = new Thread(thread,"B");
		Thread C = new Thread(thread,"C");
		Thread D = new Thread(thread,"D");
		Thread E = new Thread(thread,"E");
//		thread.start();
//		thread.run();
		A.start();
		B.start();
		try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
//		C.run();
		C.start();
		C.setPriority(6);
		D.start();
		E.start();
//		System.out.println("Thread id done !");
	}
}
