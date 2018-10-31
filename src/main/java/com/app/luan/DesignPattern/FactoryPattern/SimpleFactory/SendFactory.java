package com.app.luan.DesignPattern.FactoryPattern.SimpleFactory;

/*
* 这是工厂类
*
* */
public class SendFactory {

	////////////////////////////////////
	//		version 1.0
//	public Sender prodect(String Type){
//		if ("Mail".equals(Type)){
//			return  new MailSender();
//		}else if ("Sms".equals(Type)){
//			return new SmsSender();
//		}else {
//			System.out.println("请输入正确的类型");
//			return null;
//		}
//	}
	/////////////////////////////////

	////////////////////////////////////
	//		version 1.1
//	public Sender MailProdect(){
//		return new MailSender();
//	}
//	public Sender SmsProdect(){
//		return  new SmsSender();
//	}

	///////////////////////////

	////////////////////////////////////
	//		version 1.2
		public static Sender MailProdect(){
		return new MailSender();
	}
	public static Sender SmsProdect(){
		return  new SmsSender();
	}
}
