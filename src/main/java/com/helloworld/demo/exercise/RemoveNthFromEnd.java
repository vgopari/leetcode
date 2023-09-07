package com.helloworld.demo.exercise;

/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
class RemoveNthFromEnd {
    public ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode p1 = head;
        int len = 0;

        //find the length of the list
        while (p1 != null) {
            len += 1;
            p1 = p1.next;
        }

        //t0 remove the first node
        if(len == n) {
            return head.next;
        }
        //find node to remove - index = length -n - 1
        int removeNode = len - n - 1;
        p1 = head;
        for (int i = 0; i < removeNode; i++) {
            p1 = p1.next;
        }

        p1.next = p1.next.next;
        
        return head;
    }
}