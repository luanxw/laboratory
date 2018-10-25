package com.app.luan.Thread;

public class TaskThread2 extends Thread{
	private Task task;
	public TaskThread2(Task task){
		super();
		this.task = task;
	}

	@Override
	public void run(){
		super.run();
		CommonUtil.YiBeginTime =System.currentTimeMillis();
		task.DoLongTimeTask();
		CommonUtil.YiEndTime =System.currentTimeMillis();

	}
}
