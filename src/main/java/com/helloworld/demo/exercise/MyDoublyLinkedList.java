package com.helloworld.demo.exercise;

public class MyDoublyLinkedList {

    int size;
    DoublyListNode head, tail;

    public MyDoublyLinkedList() {
        size = 0;

        head = new DoublyListNode(0);
        tail = new DoublyListNode(0);
        head.next = tail;
        tail.prev = head;
    }

    public int get(int index) {
        if(index >= size || index < 0) {
            return -1;
        }

        DoublyListNode curr = head;

        if(index + 1 < size - index) {

            for (int i = 0; i < index + 1; ++i) {
                curr = curr.next;
            }
        } else {
            curr = tail;
            for (int i=0; i < size - index; ++i) {
                curr = curr.prev;
            }
        }
        return curr.val;
    }

    public void addAtHead(int val) {
        DoublyListNode predecessor = head, successor = head.next;

        size += 1;
        DoublyListNode toAdd = new DoublyListNode(val);
        toAdd.prev = predecessor;
        toAdd.next = successor;
        predecessor.next = toAdd;
        successor.prev = toAdd;

    }

    public void addAtTail(int val) {
        DoublyListNode successor = tail, predecessor = tail.prev;

        size += 1;
        DoublyListNode toAdd = new DoublyListNode(val);
        toAdd.prev = predecessor;
        toAdd.next = successor;
        predecessor.next = toAdd;
        successor.prev = toAdd;

    }

    public void addAtIndex(int index, int val) {

        if(index > size) {
            return;
        }

        if (index < 0) {
            index = 0;
        }

        DoublyListNode predecessor, successor;

        if(index < size - index) {
            predecessor = head;
            for (int i = 0; i < index; ++i) {
                predecessor = predecessor.next;
            }
            successor = predecessor.next;
        } else {
            successor = tail;
            for (int i=0; i< size - index; ++i) {
                successor = successor.prev;
            }
            predecessor = successor.prev;
        }

        size += 1;
        DoublyListNode toAdd = new DoublyListNode(val);

        toAdd.prev = predecessor;
        toAdd.next = successor;
        predecessor.next = toAdd;
        successor.prev = toAdd;

    }

    public void deleteAtIndex(int index) {
        if (index < 0) {
            return;
        }
        if (index >= size) {
            return;
        }

        DoublyListNode predecessor, successor;
        if(index < size - index) {
            predecessor = head;
            for(int i = 0; i < index; ++i) {
                predecessor = predecessor.next;
            }
            successor = predecessor.next.next;
        } else {
            successor = tail;
            for(int i = 0; i < size - index - 1; ++i) {
                successor = successor.prev;
            }
            predecessor = successor.prev.prev;
        }
        size--;
        predecessor.next = successor;
        successor.prev = predecessor;
    }
}

/**
 * Your MyLinkedList object will be instantiated and called as such:
 * MyLinkedList obj = new MyLinkedList();
 * int param_1 = obj.get(index);
 * obj.addAtHead(val);
 * obj.addAtTail(val);
 * obj.addAtIndex(index,val);
 * obj.deleteAtIndex(index);
 */