/* design-circular-deque */

/**
 * 数组实现方式
 */
class MyCircularDeque {

    private int[] ring;

    private int capacity;

    private int head;

    private int tail;

    /**
     * Initialize your data structure here. Set the size of the deque to be k.
     */
    public MyCircularDeque(int k) {
        capacity = k + 1; // 因为环形队列需要一个空位判断队列为空
        ring = new int[capacity];
    }

    /**
     * Adds an item at the front of Deque. Return true if the operation is successful.
     */
    public boolean insertFront(int value) {
        if (isFull()) {
            return false;
        }

        head = (head + capacity - 1) % capacity; // 移动到前一位
        ring[head] = value;
        return true;
    }

    /**
     * Adds an item at the rear of Deque. Return true if the operation is successful.
     */
    public boolean insertLast(int value) {
        if (isFull()) {
            return false;
        }

        ring[tail] = value;
        tail = (tail + 1) % capacity;
        return true;
    }

    /**
     * Deletes an item from the front of Deque. Return true if the operation is successful.
     */
    public boolean deleteFront() {
        if (isEmpty()) {
            return false;
        }

        head = (head + 1) % capacity;
        return true;
    }

    /**
     * Deletes an item from the rear of Deque. Return true if the operation is successful.
     */
    public boolean deleteLast() {
        if (isEmpty()) {
            return false;
        }

        tail = (tail + capacity - 1) % capacity; // 移动到前一位
        return true;
    }

    /**
     * Get the front item from the deque.
     */
    public int getFront() {
        if (isEmpty()) {
            return -1;
        }

        return ring[head];
    }

    /**
     * Get the last item from the deque.
     */
    public int getRear() {
        if (isEmpty()) {
            return -1;
        }

        return ring[(tail + capacity - 1) % capacity];
    }

    /**
     * Checks whether the circular deque is empty or not.
     */
    public boolean isEmpty() {
        return head == tail;
    }

    /**
     * Checks whether the circular deque is full or not.
     */
    public boolean isFull() {
        return (tail + 1) % capacity == head;
    }
}

/**
 * 双指针实现方式
 */
class Node {

    Node next, prev;
    int val;

    public Node(int val) {
        this.val = val;
    }
}

class MyCircularDeque_1 {

    Node head;
    int capacity;
    int size;

    /**
     * Initialize your data structure here. Set the size of the deque to be k.
     */
    public MyCircularDeque_1(int k) {
        head = new Node(-1);
        head.next = head;
        head.prev = head;
        size = 0;
        capacity = k;
    }

    /**
     * Adds an item at the front of Deque. Return true if the operation is successful.
     */
    public boolean insertFront(int value) {

        if (size == capacity) {
            return false;
        }

        Node node = new Node(value);
        node.next = head.next;
        node.prev = head;
        head.next.prev = node;
        head.next = node;

        size++;

        return true;
    }

    /**
     * Adds an item at the rear of Deque. Return true if the operation is successful.
     */
    public boolean insertLast(int value) {

        if (size == capacity) {
            return false;
        }

        Node node = new Node(value);
        node.prev = head.prev;
        node.next = head;
        head.prev.next = node;
        head.prev = node;

        size++;

        return true;
    }

    /**
     * Deletes an item from the front of Deque. Return true if the operation is successful.
     */
    public boolean deleteFront() {


        if (size == 0) {
            return false;
        }

        head.next.next.prev = head;
        head.next = head.next.next;
        size--;

        return true;
    }

    /**
     * Deletes an item from the rear of Deque. Return true if the operation is successful.
     */
    public boolean deleteLast() {

        if (size == 0) {
            return false;
        }

        head.prev.prev.next = head;
        head.prev = head.prev.prev;

        size--;

        return true;
    }

    /**
     * Get the front item from the deque.
     */
    public int getFront() {

        if (size == 0) {
            return -1;
        }

        return head.next.val;
    }

    /**
     * Get the last item from the deque.
     */
    public int getRear() {

        if (size == 0) {
            return -1;
        }

        return head.prev.val;
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
}