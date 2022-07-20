package com.app.luan.leetcode;


public class 外观数列 {

    public String countAndSay(int n) {
        if (n == 1){
            return "1";
        }
        //递归
        String anws = countAndSay(n-1);
        StringBuilder builder = new StringBuilder();
        //快慢指针
        int i = 0, j = 1;
        for (; j < anws.length(); j++) {
            if (anws.charAt(i)  !=  anws.charAt(j)){
                builder.append(j-i).append(anws.charAt(i));
                i=j;
            }
        }
        builder.append(j-i).append(anws.charAt(i));
        return builder.toString();
    }

    public static void main(String[] args) {
        外观数列 aa = new 外观数列();
        System.out.println( aa.countAndSay(4));;

    }
}
