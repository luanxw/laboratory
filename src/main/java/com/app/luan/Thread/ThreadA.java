package com.app.luan.Thread;

public class ThreadA extends Thread{
	private  PrivateNum privateNum;
	public ThreadA(PrivateNum privateNum){
		super();
		this.privateNum = privateNum;
	}

	@Override
	public void run(){
		super.run();
		privateNum.add("a");

	}
}
