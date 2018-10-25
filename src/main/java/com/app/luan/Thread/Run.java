package com.app.luan.Thread;

public class Run {
	public static void main(String[] args) {
//		Task wei = new Task();
//		TaskThread1 luan = new TaskThread1(wei);
//		luan.start();
//		TaskThread2 yi = new TaskThread2(wei);
//		yi.start();
//		try {
//			Thread.sleep(10000);
//		} catch (InterruptedException e) {
//			e.printStackTrace();
//		}
//		Long BeginTime = CommonUtil.LuanBeginTime;
//		if (CommonUtil.YiBeginTime > CommonUtil.LuanBeginTime){
//			BeginTime = CommonUtil.YiBeginTime;
//		}
//		Long EndTime = CommonUtil.LuanEndTime;
//		if (CommonUtil.YiEndTime > CommonUtil.LuanEndTime){
//			EndTime = CommonUtil.YiEndTime;
//		}
//		System.out.println("线程耗时："+ ((EndTime-BeginTime)/1000));


		////////////////////////////
		//   volatile关键字test
//		UserVolatile vol = new UserVolatile();
//		vol.start();
//		try {
//			Thread.sleep(1000);
//		} catch (InterruptedException e) {
//			e.printStackTrace();
//		}
//		vol.setRunning(false);
//		System.out.println("已经被赋值为false！");
	///////////////////////////
	//     volatile原子性实验

		UserVolatile[] userVolatile = new UserVolatile[100];
		for (int i=0 ; i <100 ; i++){
			userVolatile[i] = new UserVolatile();
		}
		for (int i=0 ; i <100 ; i++){
			userVolatile[i].start();
		}

	}
}
