package com.app.luan.LockTest;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class MyserviceMoreCondition {
	private Lock lock = new ReentrantLock();
	Condition conditionA = lock.newCondition();
	Condition conditionB = lock.newCondition();

	public void awaitA(){
		lock.lock();
		try {
			System.out.println("begin awaitA time:"+System.currentTimeMillis()+"  Thread name："+Thread.currentThread().getName());
			conditionA.await();
			System.out.println("end awaitA time:"+System.currentTimeMillis()+"  Thread name："+Thread.currentThread().getName());
		} catch (InterruptedException e) {
			e.printStackTrace();
		}finally {
			lock.unlock();
		}
	}
	public void awaitB(){
		lock.lock();
		try {
			System.out.println("begin awaitB time:"+System.currentTimeMillis()+"  Thread name："+Thread.currentThread().getName());
			conditionB.await();
			System.out.println("end awaitB time:"+System.currentTimeMillis()+"  Thread name："+Thread.currentThread().getName());
		} catch (InterruptedException e) {
			e.printStackTrace();
		}finally {
			lock.unlock();
		}
	}
	public void Signal_allA(){
		lock.lock();
		try {
			System.out.println("begin Signal_allA time:"+System.currentTimeMillis()+"  Thread name："+Thread.currentThread().getName());
			conditionA.signalAll();
			System.out.println("end Signal_allA time:"+System.currentTimeMillis()+"  Thread name："+Thread.currentThread().getName());

		}finally {
			lock.unlock();
		}
	}

	public void Signal_allB(){
		lock.lock();
		try {
			System.out.println("begin Signal_allB time:"+System.currentTimeMillis()+"  Thread name："+Thread.currentThread().getName());
			conditionB.signalAll();
			System.out.println("end Signal_allB time:"+System.currentTimeMillis()+"  Thread name："+Thread.currentThread().getName());
		}finally {
			lock.unlock();
		}
	}
}
