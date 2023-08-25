package com.helloworld.demo.exercise;

public class SinglyLinkedList {

    int size;
    ListNode head;

    public SinglyLinkedList() {
        head = new ListNode(0);
        size = 0;
    }

    public int get(int index) {
        if (index < 0 || index >= size)
            return -1;
        ListNode curr = head;
        for (int i = 0; i < index + 1; i++) {
            curr = curr.next;
        }
        return curr.val;
    }

    public void addAtHead(int val) {
        addAtIndex(0, val);
    }

    public void addAtTail(int val) {
        addAtIndex(size, val);
    }

    public void addAtIndex(int index, int val) {
        if (index > size) {
            return;
        }
        ListNode prev = head;
        ListNode toAdd = new ListNode(val);
        for (int i = 0; i < index; i++) {
            prev = prev.next;
        }
        toAdd.next = prev.next;
        prev.next = toAdd;
        ++size;
    }

    public void deleteAtIndex(int index) {
        if (index < 0 || index >= size) {
            return;
        }

        ListNode pred = head;
        for (int i = 0; i < index; ++i) pred = pred.next;

        pred.next = pred.next.next;
        size--;
    }

    public static void main(String[] args) {

        SinglyLinkedList obj = new SinglyLinkedList();

        obj.addAtHead(1);
        obj.addAtTail(2);
        obj.addAtIndex(1, 5);
//        obj.deleteAtIndex(0);

        ListNode head = obj.head;
        while (head != null) {
            System.out.print(head.val + "->");
            head = head.next;
        }
        System.out.println();
        System.out.println(obj.get(0));
    }
}

