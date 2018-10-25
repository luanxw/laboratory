package com.app.luan.Thread;

public class Service {
	public void TestMethod(MyRunnable Object){
		synchronized (Object){
			System.out.println("TestMethod_____getLock time ="+System.currentTimeMillis()+"run ThreadName ="+Thread.currentThread().getName());
			try {
				Thread.sleep(2000);
			} catch (InterruptedException e) {
					e.printStackTrace();
			}
			System.out.println("TestMethod_____getLock time ="+System.currentTimeMillis()+"run ThreadName ="+Thread.currentThread().getName());
		}
	}
}
