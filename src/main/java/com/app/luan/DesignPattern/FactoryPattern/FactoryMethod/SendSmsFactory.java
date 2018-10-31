package com.app.luan.DesignPattern.FactoryPattern.FactoryMethod;

public class SendSmsFactory implements Provider {
	@Override
	public Sender produce() {
		return new SmsSender();
	}
}
