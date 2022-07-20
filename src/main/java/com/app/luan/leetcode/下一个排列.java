package com.app.luan.leetcode;

import java.util.Arrays;

public class 下一个排列 {

    public static void nextPermutation(int[] nums) {
        int length = nums.length;
        if (length < 2){
            return;
        }
        for (int i = length-1; i > 0 ; i--) {
            if (nums[i-1] < nums[i]){
                //找到需要交换点地点
                for(int j = length-1; j > 0 ; j--){
                    if (nums[j] > nums[i-1]){
                        int temp= nums[i-1];
                        nums[i-1] = nums[j];
                        nums[j] = temp;
                        Arrays.sort(nums,i,length);
                        return;
                    }
                }
            }
        }
        Arrays.sort(nums);
    }

    public static void main(String[] args) {
        int[] num ={1,2,3};
        nextPermutation(num);
        System.out.println("运行结束了！！！");
    }
}
