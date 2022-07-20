package com.app.luan.Test;


import java.util.Scanner;

public class Mian {
    public static boolean comNum(long num1, long num2){
        boolean result = true;
        String num1String = String.valueOf(num1);
        String num2String = String.valueOf(num2);
        String first = num1String + num2String;
        String sec = num2String + num1String;
        int res = numCompare(first, sec);
        if (res < 0){
            result= false;
        }else if (res==0){
            if (first.length() > sec.length()){
                result= false;
            }
        }
        return result;
    }

    public  static  int numCompare(String fir , String sec){
        for (int i= 0;i < fir.length();i++){
            int firChar = fir.charAt(i);
            int secCher = sec.charAt(i);
            if (secCher > firChar){
                return -1;
            }
            if (secCher < firChar){
                return 1;
            }
        }
        return 0;
    }


    public static void main(String[] args) {
        String input;
        Scanner in = new Scanner(System.in);
        input = in.nextLine();
        if (input == null || input.length() ==0){
            return;
        }
        String[] strings = input.split(" ");
        int[] nums = new int[strings.length];
        for (int i = 0; i < strings.length; i++) {
            nums[i] = Integer.parseInt(strings[i]);
        }

        StringBuilder sb =  new StringBuilder();
        for (int i = 0; i < nums.length; i++) {
            for (int j = 0; j < nums.length; j++) {
                int fir = nums[i];
                int sec = nums[j];
                if (comNum(fir,sec)){
                    int tem = fir;
                    nums[j] = fir;
                    nums[i] = sec;
                }
            }
        }
        for (int i = 0; i < nums.length; i++) {
            sb.append(nums[i]);
        }
        String result = sb.toString();
        while (result.startsWith("0") && result.length() > 1){
            result = result.replaceFirst("0","");
        }
        System.out.println(result);
    }
}
