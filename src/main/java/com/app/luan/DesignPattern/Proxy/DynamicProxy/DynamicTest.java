package com.app.luan.DesignPattern.Proxy.DynamicProxy;

import com.app.luan.DesignPattern.Proxy.IUserDao;
import com.app.luan.DesignPattern.Proxy.UserDao;

public class DynamicTest {
	public static void main(String[] args) {
		
		//目标对象
		IUserDao target = new UserDao();

		// 【原始的类型 class cn.itcast.b_dynamic.UserDao】
		System.out.println("target 是："+target.getClass());

		// 给目标对象，创建代理对象
		IUserDao proxy = (IUserDao)new DynamicProxy(target).getProxyInstance();

		// class $Proxy0   内存中动态生成的代理对象
		System.out.println("内存中动态生成对象 为："+proxy.getClass());

		// 执行方法   【代理对象】
		proxy.save();
	}
}

/**
 * 总结:
 * 
 * 代理对象不需要实现接口,但是目标对象一定要实现接口,否则不能用动态代理
 * */
