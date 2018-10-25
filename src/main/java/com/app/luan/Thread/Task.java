package com.app.luan.Thread;

public class Task {
	public String luan;
	public String yi;

	public  synchronized void DoLongTimeTask(){

		try {
			System.out.println("Begin Task");
			Thread.sleep(3000);
			luan = "长时间处理任务返回值luan,Thread Name= "+Thread.currentThread().getName();
			yi = "长时间处理任务返回值yi,Thread Name= "+Thread.currentThread().getName();
			System.out.println(luan);
			System.out.println(yi);
			System.out.println("End Task");
		} catch (InterruptedException e) {
			e.printStackTrace();
		}

	}


}
