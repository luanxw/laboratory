package com.app.luan.Test;

import java.util.ArrayList;
import java.util.List;

public class Test1 {

    public static void main(String[] args) {
        int[] nums = {1,2,2,3,4,5,6,7,8,9};
        int target = 7;
        List<List<Integer>> result = new ArrayList<>();
        for (int i = 0; i < nums.length; i++) {
            List<Integer> temp = new ArrayList<>();
            int tatal = nums[i];
            int j = i+1;
            temp.add(nums[i]);
            if (tatal == target){
                result.add(temp);
                temp = new ArrayList<>();
                continue;
            }
            if (tatal > target){
                temp = new ArrayList<>();
                continue;
            }
            while (j+1 < nums.length){
                if (tatal+nums[j] == target){
                    temp.add(nums[j]);
                    result.add(temp);
                    temp = new ArrayList<>();
                    break;
                }
                if (tatal+nums[j] > target){
                    temp = new ArrayList<>();
                    break;
                }
                temp.add(nums[j]);
                tatal = tatal + nums[j];
                j++;
            }
        }
        for (List<Integer> item : result){
            System.out.println(item.toString());
        }
    }
}
