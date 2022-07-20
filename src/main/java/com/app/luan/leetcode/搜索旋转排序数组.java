package com.app.luan.leetcode;

public class 搜索旋转排序数组 {
    public static int search(int[] nums, int target) {

        int legnth = nums.length;
        if (nums[0] == target){
            return 0;
        }
        if (legnth == 1){
            return -1;
        }
        if (nums[0] < target){
            for (int i = 1; i < legnth; i++) {
                if (nums[i] > nums[i-1] && target == nums[i]){
                    return i;
                }
            }
        }else {
            if (nums[legnth-1] == target){
                return legnth-1;
            }
            for (int i = legnth-2; i > 0; i--) {
                if (nums[i] < nums[i+1] && target == nums[i]){
                    return i;
                }
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        int[] nums = {4,5,6,7,0,1,2};
        System.out.println(search(nums,0));
    }
}
