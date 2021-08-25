package com.app.luan.leetcode;

public class 两两交换链表中的节点 {

    public static ListNode swapPairs(ListNode head) {
        if (head.next == null){
            return head;
        }
        ListNode preHead = new ListNode();
        preHead.next = head;
        ListNode pre = preHead, first = preHead.next, second = first.next;
        while (second != null){
            first.next = second.next;
            second.next = first;
            pre.next = second;
            //继续遍历
            pre = first;
            first = pre.next;
            if (first == null){
                break;
            }
            second = first.next;
        }
        return preHead.next;
    }
    public static void main(String[] args) {
        ListNode head = new ListNode(1, new ListNode(2, new ListNode(3, new ListNode(4))));
//        ListNode head = new ListNode(1, new ListNode(2));
//        ListNode head = new ListNode(1);
        swapPairs(head);
    }
}
