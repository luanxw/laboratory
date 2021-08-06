package com.app.luan.leetcode;

import org.apache.poi.util.StringUtil;
import org.springframework.util.StringUtils;

import java.util.*;

public class 电话号码的字母组合_广度遍历 {
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
        int length = digits.length();
        List<String> result  =  new ArrayList<>();
        Queue<String> temp = new ArrayDeque<>();
        for (int i = 0; i < length; i++) {
            Queue<String> part_temp = new ArrayDeque<>();
            String s = phoneMap.get(digits.charAt(i));
            int leng = s.length();
            for (int k = 0; k < temp.size(); k++) {

            }
            while (!temp.isEmpty() || i==0){
                if (i==0){
                    for (int j = 0; j < leng; j++) {
                        part_temp.add(String.valueOf(s.charAt(j)));
                    }
                    break;
                }
                String peek = temp.poll();
                if (StringUtils.isEmpty(peek)){
                    break;
                }
                for (int j = 0; j < leng; j++) {
                    part_temp.add(peek+s.charAt(j));
                }
            }
            temp = part_temp;
        }
        int size = temp.size();
        for (int i = 0; i < size; i++) {
            result.add(temp.poll());
        }
        System.out.println(result);
    }
}
