package com.app.luan.leetcode;

import java.util.Arrays;

public class 最接近的三数之和 {

    public static void main(String[] args) {
        int[] nums = {1,1,-1,-1,3};
        if (nums.length == 0){
            return;
        }
        Arrays.sort(nums);
        int target = -1, sum = 0, result = 0, pre = 0, next = 0;
        int leng = nums.length;
        for (int i = 0; i < leng; i++) {
            for (int j = i+1; j < leng; j++) {
                int k = leng -1;
                while (k > j){
                    if (k == j){
                        break;
                    }
                    sum = nums[i]+nums[j]+nums[k];
                    next = Math.abs(target-sum);
                    if (i==0 && j==1 && k==leng-1){
                        pre = next;
                        result = sum;
                    }
                    if (next < pre){
                        pre = next;
                        result = sum;
                    }
                    System.out.println(result+"，间隔："+next);
                    k--;
                }
            }
        }
//        System.out.println(result);

    }
}
