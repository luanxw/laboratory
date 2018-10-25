package com.app.luan.Thread;

public class ThreadB extends Thread {
	private  PrivateNum privateNum;
	public  ThreadB(PrivateNum  privateNum){
		super();
		this.privateNum = privateNum;
	}
	@Override
	public void  run(){
		super.run();
		privateNum.add("b");
	}
}
