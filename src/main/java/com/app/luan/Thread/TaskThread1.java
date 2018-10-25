package com.app.luan.Thread;

public class TaskThread1 extends Thread{
	private Task task;
	public TaskThread1(Task task){
		super();
		this.task = task;
	}

	@Override
	public void run(){
		super.run();
		CommonUtil.LuanBeginTime =System.currentTimeMillis();
		task.DoLongTimeTask();
		CommonUtil.LuanBeginTime =System.currentTimeMillis();

	}
}
