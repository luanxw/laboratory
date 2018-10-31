package com.app.luan.DesignPattern.FactoryPattern.SimpleFactory;

import com.app.luan.DesignPattern.FactoryPattern.SimpleFactory.Sender;

/*
 * 这是Mai实现类
 *
 * */
public class MailSender implements Sender {

	@Override
	public void Send() {
		System.out.println("This is MailSender");
	}
}
