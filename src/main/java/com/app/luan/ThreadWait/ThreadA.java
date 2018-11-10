package com.app.luan.Thread.ThreadWait;

public class ThreadA extends Thread {
	private Object lock;

	public ThreadA(Object lock){
		super();
		this.lock = lock;
	}

	@Override
	public void run(){
			synchronized (lock){
				if (MyList.size() != 5){
					System.out.println("线程等待开始"+System.currentTimeMillis());
					try {
						lock.wait();
						System.out.println("wait被激活");
					} catch (InterruptedException e) {
						e.printStackTrace();
					}
					System.out.println("线程等待结束"+System.currentTimeMillis());
				}
			}
	}
}
