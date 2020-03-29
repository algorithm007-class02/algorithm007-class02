class MyCircularDeque {

    int size;
    int cap;
    int []queue;
    int front;
    int rear;

    public MyCircularDeque(int k) {
        this.size = 0;
        this.cap = k;
        this.queue = new int[cap];
        this.front = this.rear = -1;
    }

    public boolean insertFront(int value) {
        if(isFull()) return false;
        if(size == 0) {
            front = rear = 0;
        } else {
            front = (front - 1 + cap) % cap;
        }
        queue[front] = value;
        size++;
        return true;
    }

    public boolean insertLast(int value) {
        if(isFull()) return false;
        rear = (rear + 1) % cap;
        queue[rear] = value;
        if(size == 0) front = rear;
        size++;
        return true;
    }

    public boolean deleteFront() {
        if(isEmpty()) return false;
        if(size == 1) front = rear = -1;
        else front = (front + 1) % cap;
        size--;
        return true;
    }

    public boolean deleteLast() {
        if(isEmpty()) return false;
        if(size == 1) front = rear = -1;
        else rear = (rear - 1 + cap) % cap;
        size--;
        return true;
    }

    public int getFront() {
        if(isEmpty()) return -1;
        return queue[front];
    }

    public int getRear() {
        if(isEmpty()) return -1;
        return queue[rear];
    }

    public boolean isEmpty() {
        return size == 0;
    }

    public boolean isFull() {
        return size == cap;
    }
}
//public class MyCircularDeque {
//
//    private int[] array;
//
//    private int size;
//
//    private int index;
//
//    /**
//     * 构造函数,双端队列的大小为k
//     */
//    public MyCircularDeque(int k) {
//        array = new int[k];
//        size = k;
//        index = 0;
//    }
//
//    /**
//     * 将一个元素添加到双端队列头部。 如果操作成功返回 true
//     * [0,1,2,3,4]
//     */
//    public boolean insertFront(int value) {
//        if (!isFull()) {
//
//            for (int i = index; i > 0; i--) {
//                array[i] = array[i - 1];
//            }
//            array[0] = value;
//            index++;
//            return true;
//        }
//        return false;
//    }
//
//    /**
//     * 将一个元素添加到双端队列尾部。如果操作成功返回 true
//     */
//    public boolean insertLast(int value) {
//        if (!isFull()) {
//            array[index] = value;
//            index++;
//            return true;
//        }
//        return false;
//    }
//
//    /**
//     * 从双端队列头部删除一个元素。 如果操作成功返回 true
//     */
//    public boolean deleteFront() {
//        if (isEmpty()) {
//            return false;
//        }
//
//        for (int i = 0; i < index - 1; i++) {
//            array[i] = array[i + 1];
//        }
//
//        array[index - 1] = 0;
//
//        index--;
//        return true;
//    }
//
//    /**
//     * 从双端队列尾部删除一个元素。如果操作成功返回 true
//     */
//    public boolean deleteLast() {
//        if (isEmpty()) {
//            return false;
//        }
//
//        array[index - 1] = 0;
//        index--;
//        return true;
//    }
//
//    /**
//     * 从双端队列头部获得一个元素。如果双端队列为空，返回 -1
//     */
//    public int getFront() {
//        if (isEmpty()) {
//            return -1;
//        }
//        return array[0];
//    }
//
//    /**
//     * 获得双端队列的最后一个元素。 如果双端队列为空，返回 -1
//     */
//    public int getRear() {
//        if (isEmpty()) {
//            return -1;
//        }
//        return array[index - 1];
//    }
//
//    /**
//     * 检查双端队列是否为空
//     */
//    public boolean isEmpty() {
//        return index == 0;
//    }
//
//    /**
//     * 检查双端队列是否满了
//     */
//    public boolean isFull() {
//        return index == size;
//    }
//}