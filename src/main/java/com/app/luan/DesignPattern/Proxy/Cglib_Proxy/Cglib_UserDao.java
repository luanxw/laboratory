package com.app.luan.DesignPattern.Proxy.Cglib_Proxy;


/**
 * 目标对象,没有实现任何接口
 */
public class Cglib_UserDao {
	public void save() {
		System.out.println("----已经保存数据!----");
	}
}
