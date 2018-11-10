package com.app.luan.DesignPattern.Strategy.PayWork;


//外部客户端
public class Client {
	public static void main(String[] args) {
		//创建具体的支付策略
		PayStrategy rmbStrategy = new RMBPay();
		PayStrategy dollarStrategy = new DollarPay();
		//准备小王的支付上下文
		PayContext ctx = new PayContext("栾奕",30000,rmbStrategy);
		//向栾奕支付工资
		ctx.pay();

		//准备Ethan的支付上下文
		ctx = new PayContext("Ethan",10000,dollarStrategy);
		//向Jack支付工资
		ctx.pay();
	}
}