package com.app.luan.leetcode;

import java.util.HashMap;
import java.util.Map;

public class 二数相加 {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode answer =  new ListNode();
        ListNode result =  new ListNode();
        answer.next = result;
        if (l1 == null && l2 == null){
            return result;
        }
        int flag = 0, sum = 0;
        ListNode ans1 = l1, ans2 = l2;
        while (ans1 != null || ans2 != null || flag == 1){
            if (ans1 == null && ans2 == null){
                result.next = new ListNode(flag);
                break;
            }
            if (ans1 == null){
                sum = ans2.val + flag;
                if (sum > 9){
                    flag = 1;
                    sum = sum - 10;
                }else {
                    flag = 0;
                }
                result.next = new ListNode(sum);
                result = result.next;
                ans2 = ans2.next;
                continue;
            }
            if (ans2 == null){
                sum = ans1.val + flag;
                if (sum > 9){
                    flag = 1;
                    sum = sum - 10;
                }else {
                    flag = 0;
                }
                result.next = new ListNode(sum);
                result = result.next;
                ans1 = ans1.next;
                continue;
            }
            sum = ans1.val + ans2.val + flag;
            if (sum > 9){
                flag = 1;
                sum = sum - 10;
            }else {
                flag = 0;
            }
            result.next = new ListNode(sum);
            result = result.next;
            ans2 = ans2.next;
            ans1 = ans1.next;

        }
        return answer.next.next;
    }

    //leetcode作者
    class Solution {
        public int[] twoSum(int[] nums, int target) {
            Map<Integer, Integer> map = new HashMap<>();
            for(int i = 0; i< nums.length; i++) {
                if(map.containsKey(target - nums[i])) {
                    return new int[] {map.get(target-nums[i]),i};
                }
                map.put(nums[i], i);
            }
            throw new IllegalArgumentException("No two sum solution");
        }
    }

}
