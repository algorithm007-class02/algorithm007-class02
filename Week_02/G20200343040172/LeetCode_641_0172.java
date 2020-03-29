package week02.g20200343040172;


/**
 * LeetCode-641 设计循环双端队列
 */

class MyCircularDeque {

    private int size;
    private int cap;
    private int[] queue;
    private int front;
    private int rear;

    /**
     * Initialize your data structure here. Set the size of the deque to be k.
     */
    public MyCircularDeque(int k) {
        this.size = 0;
        this.cap = k;
        this.queue = new int[cap];
        this.front = this.rear = -1;
    }

    /**
     * Adds an item at the front of Deque. Return true if the operation is successful.
     */
    public boolean insertFront(int value) {
        if (isFull()) {
            return false;
        }
        if (size == 0) {
            front = rear = 0;
        } else {
            //TODO 为什么要这么求front?
            front = (front - 1 + cap) % cap;
        }
        queue[front] = value;
        size++;
        return true;
    }

    /**
     * Adds an item at the rear of Deque. Return true if the operation is successful.
     */
    public boolean insertLast(int value) {
        if (isFull()) {
            return false;
        }
        //TODO 为什么要这么求rear?
        rear = (rear + 1) % cap;
        queue[rear] = value;
        if (size == 0) {
            front = rear;
        }
        size++;
        return true;
    }

    /**
     * Deletes an item from the front of Deque. Return true if the operation is successful.
     */
    public boolean deleteFront() {
        if (isEmpty()) {
            return false;
        }
        if (size == 1) {
            front = rear = -1;
        } else {
            front = (front + 1) % cap;
        }
        size--;
        return true;
    }

    /**
     * Deletes an item from the rear of Deque. Return true if the operation is successful.
     */
    public boolean deleteLast() {
        if (isEmpty()) {
            return false;
        }
        if (size == 1) {
            front = rear = -1;
        } else {
            rear = (rear - 1 + cap) % cap;
        }
        size--;
        return true;
    }

    /**
     * Get the front item from the deque.
     */
    public int getFront() {
        if (isEmpty()) {
            return -1;
        }
        return queue[front];
    }

    /**
     * Get the last item from the deque.
     */
    public int getRear() {
        if (isEmpty()) {
            return -1;
        }
        return queue[rear];
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
        return size == cap;
    }
}


