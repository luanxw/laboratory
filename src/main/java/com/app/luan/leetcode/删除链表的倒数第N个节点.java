package com.app.luan.leetcode;

import java.util.HashMap;
import java.util.Map;

public class 删除链表的倒数第N个节点 {
    //如果想实现一次遍历完成，唯有以空间换时间
    public static ListNode remove(ListNode head, int n){
        if (head == null || n < 1){
            return head;
        }
        if (head.next == null){
            if (n==0){
                return head;
            }
            if (n==1){
                return null;
            }
        }
        ListNode foreach = head;
        int length = 0;
        Map<Integer, ListNode> record = new HashMap<>();
        for (int i = 0; foreach != null; i++,length++) {
            ListNode data = null;
            if (i ==0){
                data = foreach;
            }else {
                data = foreach;
            }
            record.put(i, data);
            foreach = data.next;
        }
        if (n == 1){
            record.get(length-2).next = null;
        }else  if(n == length){
            head = record.get(1);
        }else {
            record.get(length-n-1).next = record.get(length-n+1);
        }
        return head;
    }
    public static void main(String[] args) {
//        ListNode head = new ListNode(1, new ListNode(2, new ListNode((3))));
        ListNode head = new ListNode(1, new ListNode(2));
        remove(head,1);
    }

}
