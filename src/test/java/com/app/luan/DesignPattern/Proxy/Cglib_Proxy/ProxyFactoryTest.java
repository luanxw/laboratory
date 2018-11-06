package com.app.luan.DesignPattern.Proxy.Cglib_Proxy;

import org.junit.Test;


public class ProxyFactoryTest {

	@Test
	public void test() {

		//目标对象
		Cglib_UserDao target = new Cglib_UserDao();

		//代理对象
		Cglib_UserDao proxy = (Cglib_UserDao)new ProxyFactory(target).getProxyInsatnce();

		//执行代理对象的方法
		proxy.save();
	}
	
}

