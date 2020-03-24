class MyCircleDeque {
    /**
     * 双向链表
     */
    class Node{

        int val;
        Node pre = null;
        Node next;

        Node(int val){
            this.val = val;
            this.pre = null;
            this.next = null;
        }
    }

    Node firstNode = null;
    Node lastNode = null;
    int capacity;
    int size;

    /**
     * 定义容量为k的循环双端队列
     * @param k
     */
    MyCircleDeque(int k){
        this.capacity = k;
        this.size = 0;
    }

    public boolean isFull(){
        return capacity == size ? true : false;
    }


    /**
     * 头插法
     * @param value
     * @return
     */
    public boolean insertFront(int value) {
        if(isFull())
            return false;
        Node newNode = new Node(value);
        if(null == firstNode){
            firstNode = newNode;
            lastNode = newNode;
        }else{
            newNode.next = firstNode;
            firstNode.pre = newNode;
            firstNode = newNode;
        }
        size++;
        return true;
    }

    /**
     * 尾插法
     * @param value
     * @return
     */
    public boolean insertLast(int value) {
        if(isFull())
            return false;
        Node newNode = new Node(value);
        if(null == lastNode){
            firstNode = newNode;
            lastNode = newNode;
        }else{
            newNode.pre = lastNode;
            lastNode.next = newNode;
            lastNode = newNode;
        }
        size++;
        return true;
    }

    /**
     * 从头部删除一个元素
     * @return
     */

    public boolean deleteFront(){
        if(isEmpty()) return false;
        if (size == 1) {
            firstNode = null;
            lastNode = null;
        } else {
            firstNode = firstNode.next;
            firstNode.pre = null;
        }
        size--;
        return true;
    }

    /**
     * 从尾部删除一个元素
     * @return
     */
    public boolean deleteLast(){
        if(isEmpty()) return false;
        if (size == 1) {
            firstNode = null;
            lastNode = null;
        } else {
            lastNode = lastNode.pre;
            lastNode.next = null;
        }
        size--;
        return true;
    }

    /**
     * 判断队列是否为空
     * @return
     */
    public boolean isEmpty() {
        return size == 0 ? true : false;
    }

    public int getFront(){
        if(isEmpty()) return -1;
        else return firstNode.val;
    }

    public int getRear(){
        if(isEmpty()) return -1;
        else return lastNode.val;
    }

    public static void main(String[] args) {
        MyCircleDeque deque = new MyCircleDeque(3);
        System.out.println(deque.isEmpty());//true
        System.out.println(deque.insertLast(1));//true
        System.out.println(deque.insertLast(2));//true
        System.out.println(deque.insertFront(3));//true
        System.out.println(deque.insertFront(4));//false
        System.out.println(deque.getFront());//3
        System.out.println(deque.isFull());//true
        System.out.println(deque.deleteFront());//true
        System.out.println(deque.getFront());//1
        System.out.println(deque.getRear());//2
    }
}

class MyCircleDeque2 {
    /**
     * 数组实现
     */

    int[] arr;
    //头指针
    int first;
    //尾指针
    int last;
    //实际大小
    int size;
    //容量
    int capacity;

    MyCircleDeque2(int k){
        capacity= k;
        arr = new int[capacity];
        size = first = last = 0;
    }

    public boolean isFull(){
        return size == capacity;
    }

    public boolean isEmpty(){
        return size == 0;
    }

    public boolean insertFront(int value){
        if(isFull()) return false;
        //移动first指针，如原来指向1，头插后，first指向first-1的位置
        arr[first] = value;
        first = (first - 1 + capacity) % capacity;
        size++;
        return true;
    }

    public boolean insertLast(int value){
        if(isFull()) return false;
        //尾指针向后移动一位
        last = (last + 1) % capacity;
        arr[last] = value;
        size++;
        return true;
    }


    public boolean deleteFront(){
        if(isEmpty()) return false;
        //删除第一个元素，first指针向后移动一位
        first = (first + 1) % arr.length;
        size--;
        return true;
    }

    /**
     * 最后一位删除
     * @return
     */
    public boolean deleteLast(){
        if(isEmpty()) return false;
        //删除最后一个元素，last指针前移一位
        last = (last - 1 + arr.length) % arr.length;
        size--;
        return true;
    }

    public int getFront(){
        return isEmpty() ? -1 : arr[(first + 1) % capacity];
    }

    public int getRear(){
        return isEmpty() ? -1 : arr[last];
    }

    public static void main(String[] args) {
        MyCircleDeque2 deque = new MyCircleDeque2(3);
        System.out.println(deque.isEmpty());//true
        System.out.println(deque.insertLast(1));//true
        System.out.println(deque.insertLast(2));//true
        System.out.println(deque.insertFront(3));//true
        System.out.println(deque.insertFront(4));//false
        System.out.println(deque.getFront());//3
        System.out.println(deque.getRear());//3
        System.out.println(deque.deleteLast());//true
        System.out.println(deque.getRear());//3
        System.out.println(deque.deleteFront());//true
        System.out.println(deque.getRear());//1
        System.out.println(deque.getRear());//2
    }
}