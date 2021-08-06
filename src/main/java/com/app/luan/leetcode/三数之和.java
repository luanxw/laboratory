package com.app.luan.leetcode;

import com.alibaba.fastjson.JSON;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class 三数之和 {
    public static void main(String[] args) {
        int[] nums = {1,0,-1,2,-1,-4};
//        int[] nums = {-1,0,1,2,-1,-4};
//        int[] nums = {2,-2,0,1,-1,3};
        List<List<Integer>> result = new ArrayList<>();
        int length = nums.length, sum , pre = 0;
        if (length == 0){
            return;
        }
        Arrays.sort(nums);
        for (int i=0; i<length;i++){
            if (i != 0 && nums[i-1] == nums[i]){
                continue;
            }
            for (int j=i+1; j<length;j++){
                if (j> i+1 && nums[j] == nums[j-1]){
                    continue;
                }
                int target = -nums[i];
                int k = length-1;
                while (k > j && nums[j] + nums[k] > target){
                    k--;
                }
                if (k == j){
                    break;
                }
                if (target == nums[j] + nums[k]){
                        List<Integer> temp = new ArrayList<>();
                        temp.add(nums[i]);
                        temp.add(nums[j]);
                        temp.add(nums[k]);
                        result.add(temp);
                    }
//                for (int k = length-1; k > 0; k--){
//                    if (k > j &&  nums[j] + nums[k] > target) {
//                        continue;
//                    }
//                    if (k == j){
//                        break;
//                    }
//                    if (target == nums[j] + nums[k]){
//                        List<Integer> temp = new ArrayList<>();
//                        temp.add(nums[i]);
//                        temp.add(nums[j]);
//                        temp.add(nums[k]);
//                        result.add(temp);
//                        break;
//                    }
//                }
            }
        }
        System.out.println("结果是："+ JSON.toJSONString(result));
    }
}
