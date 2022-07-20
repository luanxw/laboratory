package com.app.luan;

import org.junit.Test;

import java.util.Scanner;

public class HuaWeiTest {

    @Test
    public void test1(){
        String input ;int index =0;
        Scanner in = new Scanner(System.in);
        input = in.nextLine();
        String[] strings = input.split(",");
        int[] cars = new int[strings.length];
        for (int i = 0; i < strings.length; i++) {
            cars[i] = Integer.parseInt(strings[i]);
        }
        System.out.println(cars.toString());
    }

}
