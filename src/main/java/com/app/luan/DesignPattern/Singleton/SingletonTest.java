package com.app.luan.DesignPattern.Singleton;

public class SingletonTest {
	private static SingletonTest instance = null;

	private SingletonTest(){

	}

	private static synchronized void SyncInit(){
		if (instance == null){
			instance = new SingletonTest();
		}
	}

	public static SingletonTest getInstance(){
		if (instance == null){
			SyncInit();
		}
		return instance;
	}
}
