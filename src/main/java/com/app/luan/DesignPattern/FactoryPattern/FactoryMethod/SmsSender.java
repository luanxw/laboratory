package com.app.luan.DesignPattern.FactoryPattern.FactoryMethod;


/*
 * 这是Sms实现类
 *
 * */
public class SmsSender implements Sender {
	@Override
	public void Send() {
		System.out.println("This is SmsSender");
	}
}
