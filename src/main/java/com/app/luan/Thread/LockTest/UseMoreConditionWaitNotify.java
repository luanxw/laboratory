package com.app.luan.LockTest;



public class UseMoreConditionWaitNotify {
	public static void main(String[] args) throws InterruptedException {
		MyserviceMoreCondition service = new MyserviceMoreCondition();
		MyThreadA myThreadA = new MyThreadA(service);
		myThreadA.setName("A");
		myThreadA.start();

		MyThreadB myThreadB = new MyThreadB(service);
		myThreadB.setName("B");
		myThreadB.start();

		Thread.sleep(3000);
		service.Signal_allA();
		service.Signal_allB();
	}
	static public class MyThreadA extends Thread{
		private MyserviceMoreCondition service;
		public MyThreadA(MyserviceMoreCondition service){
			super();
			this.service = service;
		}
		@Override
		public void run(){
			service.awaitA();
		}
	}

	static public class MyThreadB extends Thread{
		private MyserviceMoreCondition service;
		public MyThreadB(MyserviceMoreCondition service){
			super();
			this.service = service;
		}
		@Override
		public void run(){
			service.awaitB();
		}
	}

}
