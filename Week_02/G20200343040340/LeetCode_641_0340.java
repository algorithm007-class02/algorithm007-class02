/**
 * 641.设计循环双端队列
 */
class MyCircularDeque {
    int[] myqueue ;
    int front; //头指针
    int rear; //尾指针
    int size; //当前大小
    int capacity; //队列容量

    /** Initialize your data structure here. Set the size of the deque to be k. */
    public MyCircularDeque(int k) {
        this.myqueue = new int[k];
        this.front = 0;
        this.rear = 0;
        this.size = 0;
        this.capacity = k;
    }

    /** Adds an item at the front of Deque. Return true if the operation is successful. */
    public boolean insertFront(int value) {
        if(isFull()) return  false;
        else {
            front = (front + capacity -1)% capacity;
            myqueue[front] = value;
            size++;
            return true;
        }
    }

    /** Adds an item at the rear of Deque. Return true if the operation is successful. */
    public boolean insertLast(int value) {
        if(isFull()) return  false;
        else {
            myqueue[rear] = value;
            rear = (rear+1+capacity)%capacity;
            size++;
            return true;
        }

    }

    /** Deletes an item from the front of Deque. Return true if the operation is successful. */
    public boolean deleteFront() {
        if(isEmpty()) return false;
        else {
            front = (front+1) % capacity;
            size--;
            return true;
        }

    }

    /** Deletes an item from the rear of Deque. Return true if the operation is successful. */
    public boolean deleteLast() {
        if(isEmpty()) return false;
        else {
            rear = (rear - 1 + capacity) % capacity;
            size--;
            return true;
        }
    }

    /** Get the front item from the deque. */
    public int getFront() {
        if(isEmpty()) return -1;
        else return myqueue[front];
    }

    /** Get the last item from the deque. */
    public int getRear() {
        if(isEmpty()) return -1;
        else return myqueue[(rear - 1 + capacity) % capacity];
    }

    /** Checks whether the circular deque is empty or not. */
    public boolean isEmpty() {
        return (rear == front) && size == 0;
    }

    /** Checks whether the circular deque is full or not. */
    public boolean isFull() {
        return rear == front && size == capacity;
    }
}