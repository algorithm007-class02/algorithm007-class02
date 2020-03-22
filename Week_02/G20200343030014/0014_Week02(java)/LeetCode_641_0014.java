class MyCircularDeque {

    private int[] ring;

    private int capacity;

    private int head;

    private int tail;


    public MyCircularDeque(int k) {
        capacity = k + 1; // 因为环形队列需要一个空位判断队列为空
        ring = new int[capacity];
    }


    public boolean insertFront(int value) {
        if (isFull()) {
            return false;
        }

        head = (head + capacity - 1) % capacity; // 移动到前一位
        ring[head] = value;
        return true;
    }


    public boolean insertLast(int value) {
        if (isFull()) {
            return false;
        }

        ring[tail] = value;
        tail = (tail + 1) % capacity;
        return true;
    }


    public boolean deleteFront() {
        if (isEmpty()) {
            return false;
        }

        head = (head + 1) % capacity;
        return true;
    }


    public boolean deleteLast() {
        if (isEmpty()) {
            return false;
        }

        tail = (tail + capacity - 1) % capacity;
        return true;
    }


    public int getFront() {
        if (isEmpty()) {
            return -1;
        }

        return ring[head];
    }


    public int getRear() {
        if (isEmpty()) {
            return -1;
        }

        return ring[(tail + capacity - 1) % capacity];
    }


    public boolean isEmpty() {
        return head == tail;
    }

    public boolean isFull() {
        return (tail + 1) % capacity == head;
    }
}

