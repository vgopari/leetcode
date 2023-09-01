package com.helloworld.demo.exercise;

import java.util.HashSet;
import java.util.Set;

public class LinkedListIntersection {

    public static ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        Set<ListNode> visited = new HashSet<ListNode>();

        while (headB != null && headB.next != null) {
            visited.add(headB);
            headB = headB.next;
        }
        while (headA != null && headA.next != null) {
            if (visited.contains(headA)) {
                return headA;
            }
            headA = headA.next;
        }
        return null;
    }
}
