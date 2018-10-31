package com.app.luan.DesignPattern.FactoryPattern.SimpleFactory;

import com.app.luan.DesignPattern.FactoryPattern.SimpleFactory.SendFactory;
import com.app.luan.DesignPattern.FactoryPattern.SimpleFactory.Sender;

public class FactoryTest {
	public static void main(String[] args) {

		///////////////////////////////
		//		version 1.0
//		SendFactory factory = new SendFactory();
//		Sender sender = factory.prodect("Mail");
//		sender.Send();
		////////////////////////////////

		//////////////////////////////
//		version 1.1
//		SendFactory factory = new SendFactory();
//		Sender sender = factory.MailProdect();
//		sender.Send();

		////////////////////////////////////

 		////////////////////////////////////
		//		version 1.2
//		多个工厂方法模式里的方法置为静态的，不需要创建实例，直接调用即可。
		Sender sender = SendFactory.MailProdect();
		sender.Send();
	}

	/////////////////////////////////////////
	//总结
/*	工厂模式适合：凡是出现了大量的产品需要创建，并且具有共同的接口时，可以通过工厂方法模式进行创建
	。在以上的三种模式中，第一种如果传入的字符串有误，
	不能正确创建对象，第三种相对于第二种，不需要实例化工厂类，
	所以，大多数情况下，我们会选用第三种——静态工厂方法模式。*/
}
