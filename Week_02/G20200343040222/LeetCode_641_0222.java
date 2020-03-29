
public class LeetCode_641_0222 {

    private int[] queue;

    private int cnt;

    private int head;

    private int tail;

    /** Initialize your data structure here. Set the size of the deque to be k. */
    public MyCircularDeque(int k) {
        this.queue = new int[k];
    }

    /** Adds an item at the front of Deque. Return true if the operation is successful. */
    public boolean insertFront(int value) {
        if (isFull()) {
            return false;
        }
        head = (head - 1 + queue.length) % queue.length;
        this.queue[head] = value;
        cnt++;
        return true;

    }

    /** Adds an item at the rear of Deque. Return true if the operation is successful. */
    public boolean insertLast(int value) {
        if (isFull()) {
            return false;
        }
        queue[tail] = value;
        tail = (tail + 1) % queue.length;
        cnt++;
        return true;
    }

    /** Deletes an item from the front of Deque. Return true if the operation is successful. */
    public boolean deleteFront() {
        if (isEmpty()) {
            return false;
        }
        this.head = (this.head + 1) % this.queue.length;
        this.cnt--;
        return true;
    }

    /** Deletes an item from the rear of Deque. Return true if the operation is successful. */
    public boolean deleteLast() {
        if (isEmpty()) {
            return false;
        }
        this.tail = (this.tail - 1 + this.queue.length) % this.queue.length;
        this.cnt--;
        return true;
    }

    /** Get the front item from the deque. */
    public int getFront() {
        if (isEmpty()) {
            return -1;
        }
        return this.queue[head];
    }

    /** Get the last item from the deque. */
    public int getRear() {
        if (isEmpty()) {
            return -1;
        }
        return this.queue[(tail - 1 + queue.length) % queue.length];
    }

    /** Checks whether the circular deque is empty or not. */
    public boolean isEmpty() {
        return this.cnt == 0;
    }

    /** Checks whether the circular deque is full or not. */
    public boolean isFull() {
        return this.queue.length == this.cnt;
    }
}