package com.alang.learn;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/***
 *设计实现双端队列。
 * 你的实现需要支持以下操作：
 *
 * MyCircularDeque(k)：构造函数,双端队列的大小为k。
 * insertFront()：将一个元素添加到双端队列头部。 如果操作成功返回 true。
 * insertLast()：将一个元素添加到双端队列尾部。如果操作成功返回 true。
 * deleteFront()：从双端队列头部删除一个元素。 如果操作成功返回 true。
 * deleteLast()：从双端队列尾部删除一个元素。如果操作成功返回 true。
 * getFront()：从双端队列头部获得一个元素。如果双端队列为空，返回 -1。
 * getRear()：获得双端队列的最后一个元素。 如果双端队列为空，返回 -1。
 * isEmpty()：检查双端队列是否为空。
 * isFull()：检查双端队列是否满了。
 * 示例：
 *
 * MyCircularDeque circularDeque = new MycircularDeque(3); // 设置容量大小为3
 * circularDeque.insertLast(1);			        // 返回 true
 * circularDeque.insertLast(2);			        // 返回 true
 * circularDeque.insertFront(3);			        // 返回 true
 * circularDeque.insertFront(4);			        // 已经满了，返回 false
 * circularDeque.getRear();  				// 返回 2
 * circularDeque.isFull();				        // 返回 true
 * circularDeque.deleteLast();			        // 返回 true
 * circularDeque.insertFront(4);			        // 返回 true
 * circularDeque.getFront();				// 返回 4
 *
 *
 *
 * 提示：
 *
 * 所有值的范围为 [1, 1000]
 * 操作次数的范围为 [1, 1000]
 * 请不要使用内置的双端队列库。
 */
public class LeetCode_641_0034 {
    public static void main(String[] args) {
        int k = 4;
        MyCircularArrayDeque arrayDeque = new MyCircularArrayDeque(k);
        assert arrayDeque.insertFront(1);
        arrayDeque.insertLast(2);
        assert arrayDeque.getFront() == 1;
        arrayDeque.insertLast(3);
        assert arrayDeque.getFront() == 1;
        arrayDeque.insertFront(0);
        assert !arrayDeque.insertLast(4);
        assert !arrayDeque.insertFront(-1);
        assert arrayDeque.getFront() == 0;
        assert arrayDeque.deleteLast();
        assert arrayDeque.getRear() == 2;

        MyCircularLinkedListDeque linkedListDeque = new MyCircularLinkedListDeque(k);
        System.out.println(linkedListDeque.insertFront(1));
        System.out.println(linkedListDeque.insertLast(2));
        System.out.println(linkedListDeque.getFront());
        System.out.println(linkedListDeque.insertLast(3));
        System.out.println(linkedListDeque.getFront());
        System.out.println(linkedListDeque.insertFront(0));
        System.out.println(linkedListDeque.insertLast(4));
        System.out.println(linkedListDeque.insertFront(-1));
        System.out.println(linkedListDeque.getFront());
        System.out.println(linkedListDeque.deleteLast());
        System.out.println(linkedListDeque.getRear());
    }


    static class MyCircularArrayDeque {
        private int capacity;
        private int[] data;
        private int front;
        private int rear;
        private int size;
        /** Initialize your data structure here. Set the size of the deque to be k. */
        public MyCircularArrayDeque(int k) {
            this.capacity = k;
            this.data = new int[capacity];
            this.front = 0;
            this.rear = 0;
            this.size = 0;
        }

        /** Adds an item at the front of Deque. Return true if the operation is successful. */
        public boolean insertFront(int value) {
            if(size == capacity) return false;
            front = (front-1+capacity)%capacity;
            data[front] = value;
            size++;
            return true;
        }

        /** Adds an item at the rear of Deque. Return true if the operation is successful. */
        public boolean insertLast(int value) {
            if(size == capacity) return false;
            data[rear] = value;
            rear = (rear+1)%capacity;
            size++;
            return true;
        }

        /** Deletes an item from the front of Deque. Return true if the operation is successful. */
        public boolean deleteFront() {
            if(size==0) return false;
            front = (front+1)%capacity;
            return true;
        }

        /** Deletes an item from the rear of Deque. Return true if the operation is successful. */
        public boolean deleteLast() {
            if(size == 0) return false;
            rear = (rear+capacity -1)%capacity;
            size--;
            return true;
        }

        /** Get the front item from the deque. */
        public int getFront() {
            if(size == 0) return -1;
            return data[front];
        }

        /** Get the last item from the deque. */
        public int getRear() {
            if(size == 0) return -1;
            return data[(rear-1+capacity)%capacity];
        }

        /** Checks whether the circular deque is empty or not. */
        public boolean isEmpty() {
            return size == 0 ;
        }

        /** Checks whether the circular deque is full or not. */
        public boolean isFull() {
            return size == capacity;
        }
    }

    static class MyCircularLinkedListDeque {
        private int capacity;
        private int size = 0;
        ListNode head;
        ListNode tail;

        /**
         * Initialize your data structure here. Set the size of the deque to be k.
         */
        public MyCircularLinkedListDeque(int k) {
            this.capacity = k;
            this.head = new ListNode(-1);
            this.tail = new ListNode(-1);
            head.next = tail;
            tail.prev = head;
        }

        /**
         * Adds an item at the front of Deque. Return true if the operation is successful.
         */
        public boolean insertFront(int value) {
            if (size  ==  capacity) return false;
            size++;
            ListNode node = new ListNode(value);
            node.prev = head;
            node.next = head.next;
            head.next.prev = node;
            head.next = node;
            return true;
        }

        /**
         * Adds an item at the rear of Deque. Return true if the operation is successful.
         */
        public boolean insertLast(int value) {
            if (size == capacity) return false;
            size++;
            ListNode node = new ListNode(value);
            node.prev = tail.prev;
            node.next = tail;
            tail.prev.next = node;
            tail.prev = node;
            return true;
        }

        /**
         * Deletes an item from the front of Deque. Return true if the operation is successful.
         */
        public boolean deleteFront() {
            if (size == 0) return false;
            head.next.next.prev = head;
            head.next = head.next.next;
            size--;
            return true;
        }

        /**
         * Deletes an item from the rear of Deque. Return true if the operation is successful.
         */
        public boolean deleteLast() {
            if (size == 0) return false;
            tail.prev.prev.next = tail;
            tail.prev = tail.prev.prev;
            size--;
            return true;
        }

        /**
         * Get the front item from the deque.
         */
        public int getFront() {
            return head.next.val;
        }

        /**
         * Get the last item from the deque.
         */
        public int getRear() {
            return tail.prev.val;
        }

        /**
         * Checks whether the circular deque is empty or not.
         */
        public boolean isEmpty() {
            return size == 0;
        }

        /**
         * Checks whether the circular deque is full or not.
         */
        public boolean isFull() {
            return size == capacity;
        }

        static class ListNode {
            int val;
            ListNode next;
            ListNode prev;

            public ListNode(int val) {
                this.val = val;
            }
        }
    }
}
