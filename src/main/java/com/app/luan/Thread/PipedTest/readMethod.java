package com.app.luan.PipedTest;

import java.io.IOException;
import java.io.PipedInputStream;

public class readMethod {
	public void readMethod(PipedInputStream inputStream){
		System.out.println("read : ");
		byte[] bytearray = new byte[20];
		try {
			int readLength = inputStream.read(bytearray);
			while (readLength != 1){
				String newdata = new String(bytearray , 0 , readLength);
				System.out.println(newdata);
				readLength = inputStream.read(bytearray);
			}
			System.out.println();
			inputStream.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
