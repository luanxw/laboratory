package com.app.luan.DesignPattern.FactoryPattern.FactoryMethod;

public class SendMailFactory implements Provider {
	@Override
	public Sender produce() {
		return new MailSender();
	}
}
