package com.app.luan.leetcode;

import java.nio.charset.StandardCharsets;
import java.util.Arrays;
import java.util.List;
import java.util.Locale;
import java.util.Scanner;

public class 字符串转换成整数 {

//    List<Character> alph = Arrays.asList('a','b','c','d','e','f','g','h','i','j','k','l','m','n','o','p','q','r','t','s','u','v','w','x','y','z');
//    List<Character> ignore = Arrays.asList(' ','0');


    public static void main(String[] args) {
        List<String> alph = Arrays.asList("a","b","c","d","e","f","g","h","i","j","k","l","m","n","o","p","q","r","t","s","u","v","w","x","y","z");
        List<String> ignore = Arrays.asList(" ","0");
        String sign = "-";
        boolean flag = false, begin = true;
        StringBuilder result = new StringBuilder();
        Scanner scanner = new Scanner(System.in);
        System.out.println("请输入字符串：");
        String rew = scanner.nextLine();
        rew = rew.trim();
        int leng = rew.length();
        for (int i = 0; i < leng; i++) {
            String temp = String.valueOf(rew.charAt(i)).toLowerCase(Locale.ROOT);
            if (ignore.contains(temp)){
                continue;
            }
            if (alph.contains(temp)){
                if (begin){
                    continue;
                }
                break;
            }
            if (sign.equals(temp)){
                flag = true;
                continue;
            }
            result.append(temp);
            begin = false;
        }
        if (flag){
            System.out.println(-1*Integer.valueOf(result.toString()));
            return;
        }
        System.out.println(Integer.valueOf(result.toString()));
        return;
    }



}
