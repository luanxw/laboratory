package com.app.luan.Thread;

public class UserVolatile extends Thread{
	volatile private boolean isRunning = true;
//	 volatile private boolean isRunning = true;
volatile private static 	int m ;
	public boolean isRunning(){
		return isRunning;
	}
	public void setRunning(boolean isRunning){
		this.isRunning = isRunning;
	}
	private static void addCount(){
		for (int i = 0; i < 100 ; i++){
			m = i ;
		}
		System.out.println(m);

	}
	@Override
	public void run(){
//		System.out.println("进入Run方法");
//		while (isRunning == true){
//			int a = 1;
//			int b = 2;
//			m = a + b ;
//		}
//		System.out.println(m);
//		System.out.println("线程结束了！");
		addCount();
	}
}
