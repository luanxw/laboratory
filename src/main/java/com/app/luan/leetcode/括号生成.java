package com.app.luan.leetcode;

import java.util.ArrayList;
import java.util.List;

public class 括号生成 {
    List<String> result =  new ArrayList<>();
    public List<String> generateParenthesis(int n) {
        int left=0, right=0;
        StringBuffer ans = new StringBuffer();
        backTrack(n, left, right,ans);
        return result;
    }
    public void backTrack(int n, int left, int right, StringBuffer ans){
        if (left == n && right == n){
            result.add(ans.toString());
        }
        if (left < n){
            ans.append("(");
            backTrack(n,left+1, right, ans);
            ans.deleteCharAt(ans.length()-1);
        }
        if (left > right && right < n){
            ans.append(")");
            backTrack(n,left, right+1, ans);
            ans.deleteCharAt(ans.length()-1);
        }
    }

    public static void main(String[] args) {
        括号生成 aa = new 括号生成();
        System.out.println(aa.generateParenthesis(3));
    }
}
