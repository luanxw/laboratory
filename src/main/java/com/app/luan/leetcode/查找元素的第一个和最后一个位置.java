package com.app.luan.leetcode;

public class 查找元素的第一个和最后一个位置 {
    public int[] searchRange(int[] nums, int target) {
        int[] answers = {-1, -1};
        int left = 0, right = nums.length-1;
        while (left <= right){
            if (nums[left] < target){
                left++;
                continue;
            }
            if (nums[right] > target){
                right--;
                continue;
            }
            if (nums[left] ==target && nums[right] == target){
                answers[0] = left;
                answers[1] = right;
                return answers;
            }
        }
        return answers;
    }

    public int[] searchRange2(int[] nums, int target){
        int[] answers = {-1, -1};
        if (nums == null){
            return answers;
        }
        int left = 0, right = nums.length-1;
        while (left <= right){
            int mid = (left+right)/2;
            if (nums[mid] < target){
                left = mid+1;
                continue;
            }
            if (nums[left] >= target || left > 0){
                left = left-1;
                continue;
            }
            while (left < right){
                mid = (left+right)/2;
                if (nums[mid] > target){
                    right = mid-1;
                    continue;
                }
                if (nums[mid] == target || right < nums.length-2){
                    right++;
                    continue;
                }
                if (nums[left] == target && nums[right] == target){
                    answers[0] = left;
                    answers[1] = right;
                    return answers;
                }
            }

        }
        return answers;
    }

    public static void main(String[] args) {
        int[] res = {5,7,7,8,8,10};
        查找元素的第一个和最后一个位置 aa = new 查找元素的第一个和最后一个位置();
        int[] ints = aa.searchRange2(res, 8);
        System.out.println("结果是 :"+ints[0]+" "+ints[1]);
    }
}
