package com.app.luan.Test;

import org.springframework.util.ObjectUtils;

import java.util.Scanner;

public class HuaWeiTest {
    public static void main(String[] args) {
        String input;
        Scanner in = new Scanner(System.in);
        input = in.nextLine();
        if (ObjectUtils.isEmpty(input) || input.length() ==0){
            return;
        }
        String[] strings = input.split(",");
        int[] cars = new int[strings.length];
        for (int i = 0; i < strings.length; i++) {
            cars[i] = Integer.parseInt(strings[i]);
        }
        int nums = 0;
        int len = cars.length;
        for (int i = 0; i < len; i++) {
            if (cars[i] == 0) {
                continue;
            }
            //优先判断是否为卡车
            if (i + 2 < len) {
                if (cars[i] == 1 && cars[i + 1] == 1 && cars[i + 2] == 1) {
                    nums++;
                    i = i + 2;
                    continue;
                }
            }
            //其次判断是否为货车
            if (i + 1 < len) {
                if (cars[i] == 1 && cars[i + 1] == 1) {
                    nums++;
                    i = i + 1;
                    continue;
                }
            }
            //最后为小汽车
            nums++;
        }
        System.out.println(nums);
    }
}
