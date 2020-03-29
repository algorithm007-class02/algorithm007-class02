/**
 * 用数组实现
 */
class MyListCircularDeque {

    private int[] container;

    private int size;

    private int capacity;

    private int headPre;

    private int tailNext;

    /** Initialize your data structure here. Set the size of the deque to be k. */
    public MyCircularDeque(int k) {
        this.container = new int[k];
        this.size = 0;
        this.capacity = k;
        this.headPre = k - 1;
        this.tailNext = 0;
    }

    /** Adds an item at the front of Deque. Return true if the operation is successful. */
    public boolean insertFront(int value) {
        if (isFull()) { return false; }
        container[headPre] = value;
        size++;
        headPre = (headPre - 1 + capacity) % capacity;
        return true;
    }

    /** Adds an item at the rear of Deque. Return true if the operation is successful. */
    public boolean insertLast(int value) {
        if (isFull()) { return false; }
        container[tailNext] = value;
        size++;
        tailNext = (tailNext + 1) % capacity;
        return true;
    }

    /** Deletes an item from the front of Deque. Return true if the operation is successful. */
    public boolean deleteFront() {
        if (isEmpty()) { return false; }
        headPre = (headPre + 1) % capacity;
        size--;
        return true;
    }

    /** Deletes an item from the rear of Deque. Return true if the operation is successful. */
    public boolean deleteLast() {
        if (isEmpty()) { return false; }
        tailNext = (tailNext - 1 + capacity) % capacity;
        size--;
        return true;
    }

    /** Get the front item from the deque. */
    public int getFront() {
        if (isEmpty()) { return -1; }
        return container[(headPre + 1) % capacity];
    }

    /** Get the last item from the deque. */
    public int getRear() {
        if (isEmpty()) { return -1; }
        return container[(tailNext - 1 + capacity) % capacity];
    }

    /** Checks whether the circular deque is empty or not. */
    public boolean isEmpty() {
        return size == 0;
    }

    /** Checks whether the circular deque is full or not. */
    public boolean isFull() {
        return size == capacity;
    }
}

/**
 * 用链表实现
 */
class MyLinkNodeCircularDeque {

    private LinkNode fakeHead;

    private LinkNode fakeTail;

    private int size;

    private int capacity;

    /** Initialize your data structure here. Set the size of the deque to be k. */
    public MyCircularDeque(int k) {
        this.size = 0;
        this.capacity = k;
        this.fakeHead = new LinkNode(-1);
        this.fakeTail = new LinkNode(-1);
        this.fakeHead.next = this.fakeTail;
        this.fakeTail.pre = this.fakeHead;
    }

    /** Adds an item at the front of Deque. Return true if the operation is successful. */
    public boolean insertFront(int value) {
        if (isFull()) { return false; }
        LinkNode node = new LinkNode(value);
        node.next = fakeHead.next;
        node.pre = fakeHead;
        fakeHead.next.pre = node;
        fakeHead.next = node;
        size++;
        return true;
    }

    /** Adds an item at the rear of Deque. Return true if the operation is successful. */
    public boolean insertLast(int value) {
        if (isFull()) { return false; }
        LinkNode node = new LinkNode(value);
        node.pre = fakeTail.pre;
        node.next = fakeTail;
        fakeTail.pre.next = node;
        fakeTail.pre = node;
        size++;
        return true;
    }

    /** Deletes an item from the front of Deque. Return true if the operation is successful. */
    public boolean deleteFront() {
        if (isEmpty()) { return false; }
        fakeHead.next.next.pre = fakeHead;
        fakeHead.next = fakeHead.next.next;
        size--;
        return true;
    }

    /** Deletes an item from the rear of Deque. Return true if the operation is successful. */
    public boolean deleteLast() {
        if (isEmpty()) { return false; }
        fakeTail.pre.pre.next = fakeTail;
        fakeTail.pre = fakeTail.pre.pre;
        size--;
        return true;
    }

    /** Get the front item from the deque. */
    public int getFront() {
        return fakeHead.next.val;
    }

    /** Get the last item from the deque. */
    public int getRear() {
        return fakeTail.pre.val;
    }

    /** Checks whether the circular deque is empty or not. */
    public boolean isEmpty() {
        return size == 0;
    }

    /** Checks whether the circular deque is full or not. */
    public boolean isFull() {
        return size == capacity;
    }
}

class LinkNode {
    public int val;
    public LinkNode pre;
    public LinkNode next;

    public LinkNode(int val){
        this.val = val;
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