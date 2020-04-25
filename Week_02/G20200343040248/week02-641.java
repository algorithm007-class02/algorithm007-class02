//Swift实现
class MyCircularDeque {
    var arr = [Int]();
    var front,rear,cap : Int;
    /** Initialize your data structure here. Set the size of the deque to be k. */
    init(_ k: Int) {
        arr = [Int](repeating: 0, count: k+1);
        front = 0;
        rear = 0;
        cap = k + 1;
    }

    /** Adds an item at the front of Deque. Return true if the operation is successful. */
    func insertFront(_ value: Int) -> Bool {
        if(isFull()) {return false};
        arr[front] = value;
        front = (front + 1) % cap;
        return true;
    }

    /** Adds an item at the rear of Deque. Return true if the operation is successful. */
    func insertLast(_ value: Int) -> Bool {
        if(isFull()) {return false};
        rear = (rear - 1 + cap) % cap;
        arr[rear] = value;
        return true;
    }

    /** Deletes an item from the front of Deque. Return true if the operation is successful. */
    func deleteFront() -> Bool {
        if(isEmpty()) {return false};
        front = (front - 1 + cap) % cap;
        return true;
    }

    /** Deletes an item from the rear of Deque. Return true if the operation is successful. */
    func deleteLast() -> Bool {
        if(isEmpty()) {return false};
        rear = (rear + 1) % cap;
        return true;
    }

    /** Get the front item from the deque. */
    func getFront() -> Int {
        if(isEmpty()) {return -1};
        return arr[(front - 1 + cap) % cap] ;
    }

    /** Get the last item from the deque. */
    func getRear() -> Int {
        if(isEmpty()) {return -1};
        return arr[rear];
    }

    /** Checks whether the circular deque is empty or not. */
    func isEmpty() -> Bool {
        return front == rear;
    }

    /** Checks whether the circular deque is full or not. */
    func isFull() -> Bool {
        return (front + 1) % cap == rear;
    }
}

/**
 * Your MyCircularDeque object will be instantiated and called as such:
 * let obj = MyCircularDeque(k)
 * let ret_1: Bool = obj.insertFront(value)
 * let ret_2: Bool = obj.insertLast(value)
 * let ret_3: Bool = obj.deleteFront()
 * let ret_4: Bool = obj.deleteLast()
 * let ret_5: Int = obj.getFront()
 * let ret_6: Int = obj.getRear()
 * let ret_7: Bool = obj.isEmpty()
 * let ret_8: Bool = obj.isFull()
 */

//抄作业答案才实现的，脑瓜子转不过来，使用数组来实现了，保存每次front和rear的更改。
//取余是为了防止超出数组空间，引起错误。