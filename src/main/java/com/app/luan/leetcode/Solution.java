package com.app.luan.leetcode;

class Solution {
    public String longestPalindrome(String s) {
        String ans = "";
        for (int i = 0; i< s.length(); i++) {
            String anws1 = checkStirng(s,i,i);
            String anws2 = checkStirng(s,i,i+1);
            ans = anws1.length() > ans.length() ? anws1:ans;
            ans = anws2.length() > ans.length() ? anws2:ans;
        }
        return ans;
    }
    
    public String checkStirng(String s,int i,int j){
        while (i >= 0 && j < s.length() && s.charAt(i) == s.charAt(j)){
            i--; j++;
        }
        return s.substring(i+1,j);
    }

    String palindrome(String s, int l, int r) {
        // 防止索引越界
        while (l >= 0 && r < s.length()
                && s.charAt(l) == s.charAt(r)) {
            // 向两边展开
            l--; r++;
        }
        // 返回以 s[l] 和 s[r] 为中心的最长回文串
        return s.substring(l + 1, r);
    }

    public static void main(String[] args) {
      String  s = "babad";
      Solution solution = new Solution();
        String palindrome = solution.longestPalindrome(s);
        System.out.println(palindrome);
    }
}