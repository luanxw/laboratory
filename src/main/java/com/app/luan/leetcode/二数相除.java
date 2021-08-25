package com.app.luan.leetcode;

import static com.fasterxml.jackson.databind.deser.std.UntypedObjectDeserializer.Vanilla.std;

public class 二数相除 {
    public int divide(int dividend, int divisor) {
        //--------处理越界-------
        long res = 0;

        //--------处理正负-------
        int flag = 1;
        if ((dividend ^ divisor) < 0){
            flag=-1;
        }
        long a = Math.abs((long)dividend);
        long b = Math.abs((long)divisor);

        //--------优化时间复杂度-------
        while(a >= b){
            long temp = b;
            long i = 1;
            while(a >= temp){
                res += i;
                a -= temp;
                i <<= 1;
//                temp <<= 1;
                temp = temp << 1;
            }
        }
        return res > Integer.MAX_VALUE ? flag == 1 ? Integer.MAX_VALUE : Integer.MIN_VALUE : (int)res * flag;
    }

    public static void main(String[] args) {
        二数相除 ss = new 二数相除();
//        System.out.println(ss.divide(-2147483648, -1));
        System.out.println(ss.divide(-30,3));
//        System.out.println(ss.divide(-1,1));
    }
}
