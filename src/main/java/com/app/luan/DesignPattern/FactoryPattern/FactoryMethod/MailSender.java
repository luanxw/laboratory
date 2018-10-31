package com.app.luan.DesignPattern.FactoryPattern.FactoryMethod;

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
