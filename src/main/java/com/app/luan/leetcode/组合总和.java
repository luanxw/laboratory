//package com.app.luan.leetcode;
//
//import java.util.ArrayList;
//import java.util.Arrays;
//import java.util.List;
//
//public class 组合总和 {
//
//
//    static List<List<Integer>> result = new ArrayList<>();
//    static   List<Integer> answers = new ArrayList<>();
//    public static List<List<Integer>> combinationSum(int[] candidates, int target) {
//        int sum = 0, flag = 0;
//        int length = candidates.length;
//        List<Integer> res = new ArrayList<>();
//
//        //递归比较好解决
////        while (sum < target && flag < length){
////
////        }
//        for (int i = 0; i < length; i++) {
//            sum = sum + candidates[i];
//            if (sum == target){
//                res.add(candidates[i]);
//                answers.add(new ArrayList<>(res));
//                res.clear();
//                continue;
//            }
//            if (sum > target){
//                continue;
//            }
//            for (int j = 0; j < length; j++) {
//
//            }
//        }
//        return result;
//    }
//
//    public static void combinationSum2(int[] candidates,int index, int target){
//        for (int i = index; i < candidates.length; i++) {
//            if (candidates[i] > target){
//                return ;
//            }
//            if (candidates[i] <= target){
//                if (candidates[i] == target){
//                    answers.add(candidates[i]);
//                    result.add(new ArrayList<>(answers));
//                    return ;
//                }
//                answers.add(candidates[i]);
//                combinationSum2(candidates, index,target-candidates[i]);
//                answers.remove(answers.size()-1);
////                answers.remove(answers.size()-1);
////                answers.clear();
//                break;
//            }
//
//        }
//        return;
//    }
//
//        public static void main(String[] args) {
//        int[] num ={2,3,6,7};
////        int[] num ={1};
//        List<List<Integer>> list = combinationSum(num, 7);
//        System.out.println(list);
//        System.out.println("运行结束了！！！");
//    }
//}
