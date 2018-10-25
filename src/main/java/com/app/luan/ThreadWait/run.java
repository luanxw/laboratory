package com.app.luan.ThreadWait;

public class run {
	public static void main(String[] args) {

		Object lock = new Object();
		ThreadA a = new ThreadA(lock);
		a.start();
		try {
			Thread.sleep(100);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}

		ThreadB b = new ThreadB(lock);
		b.start();
	}
}
