package com.yequan.leetcode.queue.mycirculardeque_641;

/**
 * @author : Administrator
 * @date : 2020/3/22
 */
public class MyCircularDeque {

    /**
     * 设计思路:
     * 1.使用数组存储
     * 2.front,rear指针指示头尾位置
     *  front:队头所在位置:当队头插入时,先将指针往前移(front-1+capacity) % capacity,再赋值;当队头删除时,front移动,即(front+1)%capacity
     *  rear:队尾元素的下一个位置: 当队尾插入时,先赋值,再移动位置(rear+1)%capacity; 当队尾删除时,移动rear为(rear-1+capacity)%capacity
     */

    /**
     * 双端队列容量
     */
    private int capacity;
    /**
     * 使用数组实现双端队列
     */
    private int[] array;
    /**
     * 指向头节点
     */
    private int front;
    /**
     * 指向尾节点下一个位置
     */
    private int rear;

    /**
     * Initialize your data structure here. Set the size of the deque to be k.
     */
    public MyCircularDeque(int k) {
        capacity = k + 1;
        array = new int[capacity];
        front = 0;
        rear = 0;
    }

    /**
     * 当队头插入时,先将指针往前移(front-1+capacity) % capacity,再赋值
     * Adds an item at the front of Deque. Return true if the operation is successful.
     */
    public boolean insertFront(int value) {
        if (isFull()) {
            return false;
        }
        front = (front - 1 + capacity) % capacity;
        array[front] = value;
        return true;
    }

    /**
     * 当队尾插入时,先赋值,再移动位置(rear+1)%capacity
     * Adds an item at the rear of Deque. Return true if the operation is successful.
     */
    public boolean insertLast(int value) {
        if (isFull()) {
            return false;
        }
        array[rear] = value;
        rear = (rear + 1) % capacity;
        return true;
    }

    /**
     * 出队:当队头删除时,front移动,即(front+1)%capacity
     * Deletes an item from the front of Deque. Return true if the operation is successful.
     */
    public boolean deleteFront() {
        if (isEmpty()) {
            return false;
        }
        front = (front + 1) % capacity;
        return true;
    }

    /**
     * 当队尾删除时,移动rear为(rear-1+capacity)%capacity
     * Deletes an item from the rear of Deque. Return true if the operation is successful.
     */
    public boolean deleteLast() {
        if (isEmpty()) {
            return false;
        }
        rear = (rear - 1 + capacity) % capacity;
        return true;
    }

    /**
     * Get the front item from the deque.
     */
    public int getFront() {
        if (isEmpty()) {
            return -1;
        }
        return array[front];
    }

    /**
     * Get the last item from the deque.
     */
    public int getRear() {
        if (isEmpty()) {
            return -1;
        }
        return array[(rear - 1 + capacity) % capacity];
    }

    /**
     * Checks whether the circular deque is empty or not.
     */
    public boolean isEmpty() {
        return front == rear;
    }

    /**
     * Checks whether the circular deque is full or not.
     */
    public boolean isFull() {
        return (rear + 1) % capacity == front;
    }
}
