package com.app.luan.leetcode;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class 电话号码的字母组合_深度遍历 {

    //深度优先遍历
    public static List<String> backTrace(List<String> result, Map<Character, String> phoneMap, int index, String digits,StringBuilder temp){
        if (digits.length() == index){
            result.add(temp.toString());
            return result;
        }
        String s = phoneMap.get(digits.charAt(index));
        int length = s.length();
        for (int i = 0; i < length; i++) {
            temp.append(s.charAt(i));
            backTrace(result, phoneMap, index+1, digits, temp);
            temp.deleteCharAt(index);
        }
        return result;
    }


    public static void main(String[] args) {
        Map<Character, String> phoneMap = new HashMap<>();
        phoneMap.put('2', "abc");
        phoneMap.put('3', "def");
        phoneMap.put('4', "ghi");
        phoneMap.put('5', "jkl");
        phoneMap.put('6', "mno");
        phoneMap.put('7', "pqrs");
        phoneMap.put('8', "tuv");
        phoneMap.put('9', "wxyz");
        String digits = "23";
        List<String> result  =  new ArrayList<>();
        backTrace(result, phoneMap, 0, digits, new StringBuilder());
            System.out.println(result);
        }
}
