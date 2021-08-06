package com.app.luan.leetcode;


public class 删除链表的倒数第N个节点_2 {
    //如果想实现一次遍历完成，唯有以空间换时间
    public static ListNode remove(ListNode head, int n){
        if (head == null || n < 1){
            return head;
        }
        ListNode pre_node = new ListNode(0);
        pre_node.next = head;
        ListNode fast = pre_node;
        ListNode slow = pre_node;
        for (int i = 0; i <= n; i++) {
            fast = fast.next;
        }
        while (fast.next != null){
            slow = slow.next;
            fast = fast.next;
        }
        slow.next = slow.next.next;
        return pre_node.next;
    }

    public static  ListNode remove1(ListNode head, int n){
        ListNode dummyHead = new ListNode(0);
        dummyHead.next = head;

        // 慢指针初始指向虚拟头结点
        ListNode slow = dummyHead;
        // 快指针初始指向虚拟头结点
        ListNode fast = dummyHead;

        // 快指针先向前移动n+1步
        for(int i = 0; i <= n; i++) {
            fast = fast.next;
        }

        // 快慢指针同时向前移动，直到快指针指向null
        while (fast!=null){
            fast = fast.next;
            slow = slow.next;
        }

        // 慢指针的下一个节点即待删除节点
        ListNode delNode = slow.next;
        // 慢指针的后继指针指向待删除节点的下一个节点
        // 这样就将待删除节点删除了
        slow.next = delNode.next;
        delNode.next = null;
        return dummyHead.next;

    }


    public static void main(String[] args) {
        ListNode head = new ListNode(1, new ListNode(2, new ListNode(3, new ListNode(4 ,new ListNode(5)))));
//        ListNode head = new ListNode(1, new ListNode(2));
//        ListNode head = new ListNode(1);
        remove(head,2);
    }

}
