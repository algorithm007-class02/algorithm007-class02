//设计循环双端队列
//front 队头的第一个有效元素的位置 
//rear 队尾最后一个有效元素的下一个位置，经典做法。 
class MyCircularDeque {
public:
    MyCircularDeque(int k) {
        capacity = k+1;
        arr = new int[capacity];
        front = 0;
        rear = 0;
    }
    
    bool insertFront(int value) {
        if(isFull())
            return false;
        front = (front-1+capacity)%capacity;
        arr[front] = value;
        return true;
    }
    
    bool insertLast(int value) {
        if(isFull())
            return false;
        arr[rear] = value;
        rear = (rear+1)%capacity;
        return true;
    }
    
    bool deleteFront() {
        if(isEmpty())
            return false;
        front = (front+1)%capacity;
        return true;
    }
    
    bool deleteLast() {
        if(isEmpty())
            return false;
        rear = (rear-1 + capacity)%capacity;
        return true;
    }
    
    int getFront() {
        if(isEmpty())
            return -1;
        return arr[front];
    }
    
    int getRear() {
        if(isEmpty())
            return -1;
        return arr[(rear-1+capacity)%capacity];
    }
    
    bool isEmpty() {
        return front==rear;
    }
    
    bool isFull() {
        return (rear+1)%capacity == front;  //经典做法
    }
private:
    int* arr;
    int front;    
    int rear;
    int capacity;    
};
