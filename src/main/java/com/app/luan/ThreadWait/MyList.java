package com.app.luan.ThreadWait;

import java.util.ArrayList;
import java.util.List;

public class MyList {
	private static List<String> list = new ArrayList<>();

	public static void add(){
		list.add("any String");
	}
	public static int size(){
		return list.size();
	}
}
