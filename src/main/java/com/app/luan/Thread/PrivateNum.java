package com.app.luan.Thread;

public class PrivateNum {
	private  int num = 0;
	synchronized  public  void add(String name){
		try {
			if(name.equals("a")){
				num = 100;
				System.out.println("a set over!");
				Thread.sleep(1500);
			}else {
				num = 200;
				System.out.println("b set over!");
			}
			System.out.println("线程"+name+"num=" +num);
		}catch (Exception e){
                  e.getStackTrace();
		}
	}
}
