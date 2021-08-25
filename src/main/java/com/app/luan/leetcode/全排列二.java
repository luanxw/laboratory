package com.app.luan.leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class 全排列二 {

    List<List<Integer>> answers =  new ArrayList<>();
    public List<List<Integer>> permuteUnique(int[] nums) {
        List<Integer> unique  = new ArrayList<>();
        boolean[] visit = new boolean[nums.length];
        backtrack(nums, visit, 0 ,unique);
        return answers;
    }
    private void backtrack(int[] nums, boolean[] visit , int index, List<Integer> unique){
        if (unique.size() == nums.length){
            answers.add(new ArrayList<>(unique));
            return;
        }
        for (int i = 0; i < nums.length; i++) {
            if (visit[i] || (i > 0 && nums[i] == nums[i-1] && !visit[i-1])){
                continue;
            }
            visit[i] = true;
            unique.add(nums[i]);
            backtrack(nums, visit,index+1 ,unique);
            visit[i] = false;
            unique.remove(index);
        }
    }

    public static void main(String[] args) {
        全排列二 aa = new 全排列二();
//        int[] nums = {1,1,2};
        int[] nums = {3,3,0,3};
//        System.out.println(aa.permuteUnique(nums));
        Solution s = new Solution();
        System.out.println(s.permuteUnique(nums));;
    }

     static class Solution {
        boolean[] vis;
        public  List<List<Integer>> permuteUnique(int[] nums) {
            List<List<Integer>> ans = new ArrayList<List<Integer>>();
            List<Integer> perm = new ArrayList<Integer>();
            vis = new boolean[nums.length];
            Arrays.sort(nums);
            backtrack(nums, ans, 0, perm);
            return ans;
        }

        public void backtrack(int[] nums, List<List<Integer>> ans, int idx, List<Integer> perm) {
            if (idx == nums.length) {
                ans.add(new ArrayList<Integer>(perm));
                return;
            }
            for (int i = 0; i < nums.length; ++i) {
                if (vis[i] || (i > 0 && nums[i] == nums[i - 1] && !vis[i - 1])) {
                    continue;
                }
                perm.add(nums[i]);
                vis[i] = true;
                backtrack(nums, ans, idx + 1, perm);
                vis[i] = false;
                perm.remove(idx);
            }
        }
    }

}
