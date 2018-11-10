package com.app.luan.Thread.PipedTest;

import java.io.IOException;
import java.io.PipedOutputStream;

public class WriteMethod {
	public void WriteMethod(PipedOutputStream out){
		System.out.println("write ：");
		for (int i =0 ; i < 1000 ; i++){
			String outdate = ""+(i + 1);
			try {
				out.write(outdate.getBytes());
				out.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}
}
