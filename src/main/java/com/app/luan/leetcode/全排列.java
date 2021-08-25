package com.app.luan.leetcode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class 全排列 {

    List<List<Integer>> res = new LinkedList<>();

    public List<List<Integer>> permute(int[] nums) {
        soultions(nums, new LinkedList<>());
        return res;
    }

    public void soultions(int[] nums, List<Integer> ans){
        if(nums.length == ans.size()){
            res.add(new ArrayList<>(ans));
            return;
        }
        for (int num : nums) {
            if (ans.contains(num)) {
                continue;
            }
            ans.add(num);
            soultions(nums, ans);
            ans.remove(ans.size()-1);
        }
    }

    public static void main(String[] args) {
        int[] nums = {1, 2, 3};
        全排列 排列 =  new 全排列();
        System.out.println(排列.permute(nums));;
    }
}
