package com.app.luan.leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class 四数之和 {

    public static void main(String[] args) {
//        int[] nums = {1,0,-1,0,-2,2};
//        int[] nums = {0,0,0,0,0,0};
        int[] nums = {-3,-4,-5,0,-5,-2,5,2,-3};
        int target = 3;
        List<List<Integer>> reslt = new ArrayList<>();

        int length = nums.length;
        if (length < 4){
            System.out.println(reslt);
//            return reslt;
        }
        Arrays.sort(nums);
        for (int i = 0; i < length-3 ; i++) {
            if (i !=0 && nums[i] == nums[i-1]){
                continue;
            }
            for (int j = i+1; j < length-2; j++) {
                if (j!= i+1 && nums[j]==nums[j-1]){
                    continue;
                }
                int sum = nums[i]+nums[j];
                int m = j+1, n = length-1;
                while (m < n){
                    if (m > j+1 && nums[m] == nums[m-1]){
                        m++;
                        continue;
                    }
                    if (n != length-1 && nums[n] == nums[n+1]){
                        n--;
                        continue;
                    }
                    int temp_sum = sum + nums[n]+ nums[m];
                    if (temp_sum > target){
                        n--;
                        continue;
                    }else if (temp_sum < target){
                        m++;
                        continue;
                    }
                    List<Integer> temp_reslt = new ArrayList<>();
                    temp_reslt.add(nums[i]);
                    temp_reslt.add(nums[j]);
                    temp_reslt.add(nums[m]);
                    temp_reslt.add(nums[n]);
                    reslt.add(temp_reslt);
                    n--;
                }
            }
        }
        System.out.println(reslt);
//        return reslt;
    }
}
