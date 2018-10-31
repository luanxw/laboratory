package com.app.luan.DesignPattern.FactoryPattern.SimpleFactory;


import com.app.luan.DesignPattern.FactoryPattern.SimpleFactory.Sender;

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
