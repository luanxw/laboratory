package com.app.luan.JsonObject;


import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;

public class JsonArray {
	public static void main(String[] args) {
		String string = "{\n" +
				"    \"code\": \"Success\", \n" +
				"    \"data\": [\n" +
				"        {\n" +
				"            \"mobile\": \"15812345678\", \n" +
				"            \"taskid\": 112345, \n" +
				"            \"status\": 10, \n" +
				"            \"receivetime\": \"2015-01-01 00:00:00\", \n" +
				"            \"errorcode\": \"DELIVRD\", \n" +
				"            \"extno\": null\n" +
				"        }\n" +
				"    ], \n" +
				"    \"msg\": \"Ok\"}\n";
		JSONObject resultJson = JSONObject.parseObject(string);
		System.out.println("转化后结果是：");
		System.out.println(resultJson);
//		JSONObject result = resultJson.getJSONObject("data");
//		System.out.println("得到的data是：");
//		System.out.println(result);
		JSONArray array = resultJson.getJSONArray("data");
		System.out.println("数组第一个是：");
		System.out.println(array.get(0));
	}
}
