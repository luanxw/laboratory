package com.app.luan.Thread;

public class Excute {
	public static void main(String[] args) {
		PrivateNum num1 = new PrivateNum();
		PrivateNum num2 = new PrivateNum();

		ThreadA A = new ThreadA(num1);
		ThreadB B = new ThreadB(num2);
		A.start();
		B.start();
	}
}
