package com.practice.cyc.java.leetcode;

/**
 * @author: lengyue
 * @decription:
 * @time: 2020/3/22
 */
public class MyCircularDeque {

    private int size;
    private int k;
    private ListNode head;
    private ListNode tail;

    /** Initialize your data structure here. Set the size of the deque to be k. */
    public MyCircularDeque(int k) {
        this.size = 0;
        this.k = k;
        this.head = new ListNode(-1);
        this.tail = new ListNode(-1);
        head.pre = tail;
        tail.next = head;
    }

    /** Adds an item at the front of Deque. Return true if the operation is successful. */
    public boolean insertFront(int value) {
        if (size == k) {
            return false;
        }
        ListNode node = new ListNode(value);
        node.next = head;
        node.pre = head.pre;
        head.pre.next = node;
        head.pre = node;
        size ++;
        return true;
    }

    /** Adds an item at the rear of Deque. Return true if the operation is successful. */
    public boolean insertLast(int value) {
        if (size == k) return false;
        ListNode node = new ListNode(value);
        node.next = tail.next;
        tail.next.pre = node;
        tail.next = node;
        node.pre = tail;
        size ++;
        return true;
    }

    /** Deletes an item from the front of Deque. Return true if the operation is successful. */
    public boolean deleteFront() {
        if (size == 0) return false;
        head.pre.pre.next = head;
        head.pre = head.pre.pre;
        size --;
        return true;
    }

    /** Deletes an item from the rear of Deque. Return true if the operation is successful. */
    public boolean deleteLast() {
        if (size == 0) return false;
        tail.next.next.pre = tail;
        tail.next = tail.next.next;
        size --;
        return true;
    }

    /** Get the front item from the deque. */
    public int getFront() {
        return head.pre.val;
    }

    /** Get the last item from the deque. */
    public int getRear() {
        return tail.next.val;
    }

    /** Checks whether the circular deque is empty or not. */
    public boolean isEmpty() {
        return size == 0;
    }

    /** Checks whether the circular deque is full or not. */
    public boolean isFull() {
        return size == k;
    }

    private static class ListNode<E> {
        int val;
        ListNode next;
        ListNode pre;
        ListNode(int x) {
            this.val = x;
        }
    }

}
