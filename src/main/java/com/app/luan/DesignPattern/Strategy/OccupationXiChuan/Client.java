package com.app.luan.DesignPattern.Strategy.OccupationXiChuan;

public class Client {
	
	public static void main(String[] args) {
		
		OccupationContext context = new  OccupationContext();
		//这个给手下的人激励不够啊
		context.occupationWestOfSichuan("拿下西川");
		System.out.println("=========================");
		//这个人人有赏，让士兵有动力啊
		context.occupationWestOfSichuan("拿下西川之后，人人有赏！");
	}
}
