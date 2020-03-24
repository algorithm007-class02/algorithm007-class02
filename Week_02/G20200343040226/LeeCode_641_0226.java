package com.logic;

/**
 * @Auther: welllu
 * @Date: 2020/3/21 23:39
 * @Description:
 */
public class LeeCode_641_0226 {

    int[] storage;
    int front = 0;
    int last = 0;
    int size = 0;
    int capicity = 0;

    public LeeCode_641_0226(int k) {
        capicity = k + 1;
        storage = new int[capicity];
    }


    /** Adds an item at the front of Deque. Return true if the operation is successful. */
    public boolean insertFront(int value) {
        if(isFull ()) {
            return false;
        }
        front = (front - 1 + capicity) % capicity;
        storage[front] = value;
        return true;
    }

    /** Adds an item at the rear of Deque. Return true if the operation is successful. */
    public boolean insertLast(int value) {
        if(isFull ()) {
            return false;
        }
        storage[last] = value;
        last = (last + 1) % capicity;
        return true;
    }

    /** Deletes an item from the front of Deque. Return true if the operation is successful. */
    public boolean deleteFront() {
        if(isEmpty ()) return false;
        front = (front + 1) % capicity;
        return true;
    }

    /** Deletes an item from the rear of Deque. Return true if the operation is successful. */
    public boolean deleteLast() {
        if(isEmpty ()) return false;
        last = (last - 1 + capicity) % capicity;
        return true;
    }

    /** Get the front item from the deque. */
    public int getFront() {
        if(isEmpty ()) return -1;
        return storage[front];
    }

    /** Get the last item from the deque. */
    public int getRear() {
        if(isEmpty ()) return -1;
        return storage[(last - 1 + capicity) % capicity];
    }

    /** Checks whether the circular deque is empty or not. */
    public boolean isEmpty() {
        return (front == last);
    }

    /** Checks whether the circular deque is full or not. */
    public boolean isFull() {
        return (last + 1) % capicity == front;
    }
}
