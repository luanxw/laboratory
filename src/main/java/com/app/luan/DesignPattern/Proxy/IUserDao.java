package com.app.luan.DesignPattern.Proxy;


/**
 * 1.1.静态代理
 * 静态代理在使用时,需要定义接口或者父类,被代理对象与代理对象一起实现相同的接口或者是继承相同父类.
 *
 * 下面举个案例来解释:
 * 模拟保存动作,定义一个保存动作的接口:IUserDao.java,然后目标对象实现这个接口的方法UserDao.java,此时如果使用静态代理方式,
 * 就需要在代理对象(UserDaoProxy.java)中也实现IUserDao接口.调用的时候通过调用代理对象的方法来调用目标对象.
 * 
 * 需要注意的是: 代理对象与目标对象要实现相同的接口,然后通过调用相同的方法来调用目标对象的方法
 * 
 * */
public interface IUserDao {
	void save();
}
