class MyCircularDeque {
    /**
     * 使用双指针控制头尾，并且空出来一个位置用来区别队列是空还是满的情况
     */
    private int[] data;
    private int front;
    private int last;
    private int length;
    

    /** Initialize your data structure here. Set the size of the deque to be k. */
    public MyCircularDeque(int k) {
        this.length = k + 1;
        data = new int[this.length];
        this.front = 0;
        this.last = 0;
        
    }
    
    /** Adds an item at the front of Deque. Return true if the operation is successful. */
    public boolean insertFront(int value) {
        if (isFull()) {
            return false;
        }
        front = (front - 1 + length) % length;
        data[front] = value;
        return true;
    }
    
    /** Adds an item at the rear of Deque. Return true if the operation is successful. */
    public boolean insertLast(int value) {
        if (isFull()) {
            return false;
        }
        data[last] = value;
        last = (last + 1) % length;
        return true;
    }
    
    /** Deletes an item from the front of Deque. Return true if the operation is successful. */
    public boolean deleteFront() {
        if (isEmpty()) {
            return false;
        } else {
            front = (front + 1) % length;
            return true;
        }
    }
    
    /** Deletes an item from the rear of Deque. Return true if the operation is successful. */
    public boolean deleteLast() {
         if (isEmpty()) {
            return false;
        }
        last = (last - 1 + length) % length;
        return true;
    }
    
    /** Get the front item from the deque. */
    public int getFront() {
        if (isEmpty()) {
            return -1;
        }
        return this.data[front];
    }
    
    /** Get the last item from the deque. */
    public int getRear() {
         if (isEmpty()) {
            return -1;
        }
        return this.data[(last - 1 + length) % length];
    }
    
    /** Checks whether the circular deque is empty or not. */
    public boolean isEmpty() {
        return front == last;
    }
    
    /** Checks whether the circular deque is full or not. */
    public boolean isFull() {
        return (last + 1) % length  == front;
    }
}

/**
 * Your MyCircularDeque object will be instantiated and called as such:
 * MyCircularDeque obj = new MyCircularDeque(k);
 * boolean param_1 = obj.insertFront(value);
 * boolean param_2 = obj.insertLast(value);
 * boolean param_3 = obj.deleteFront();
 * boolean param_4 = obj.deleteLast();
 * int param_5 = obj.getFront();
 * int param_6 = obj.getRear();
 * boolean param_7 = obj.isEmpty();
 * boolean param_8 = obj.isFull();
 */