package com.app.luan.PipedTest;

import java.io.IOException;
import java.io.PipedInputStream;
import java.io.PipedOutputStream;

public class run {
	public static void main(String[] args) {
		WriteMethod writeMethod = new WriteMethod();
		readMethod readMethod = new readMethod();
		PipedInputStream inputStream = new PipedInputStream();
		PipedOutputStream outputStream = new PipedOutputStream();
		try {
			outputStream.connect(inputStream);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
