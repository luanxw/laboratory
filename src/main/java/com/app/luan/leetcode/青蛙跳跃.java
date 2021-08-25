package com.app.luan.leetcode;

public class 青蛙跳跃 {
    public boolean jumpGame(int[] A){
        int length = A.length;
        boolean[] result  = new boolean[length-1];
        for (int i = 0; i < length; i++) {
            result[i]=false;
            if (i==0) {
                result[i] = true;
                continue;
            }
            for (int j = 0; j > i; j++) {
                if (result[j] && i-j <= A[j]){
                    result[i] = true;
                    break;
                }
            }

        }
        return result[length-1];
    }
}
