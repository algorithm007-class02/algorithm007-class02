class MyCircularDeque {
private:
    int maxSize;
    stack<int> stack1;
    stack<int> stack2;
public:
    /** Initialize your data structure here. Set the size of the deque to be k. */
    MyCircularDeque(int k) {
        maxSize = k;
    }
    
    /** Adds an item at the front of Deque. Return true if the operation is successful. */
    bool insertFront(int value) {
        if(isFull()) return false;
        stack2.push(value);
        return true;
    }
    
    /** Adds an item at the rear of Deque. Return true if the operation is successful. */
    bool insertLast(int value) {
        if(isFull()) return false;
        stack1.push(value);
        return true;
    }
    
    /** Deletes an item from the front of Deque. Return true if the operation is successful. */
    bool deleteFront() {
        if(isEmpty()) return false;
        if(stack2.empty()){moveFromStack1ToStack2();}
        stack2.pop();
        return true;
    }
    
    /** Deletes an item from the rear of Deque. Return true if the operation is successful. */
    bool deleteLast() {
        if(isEmpty()) return false;
        if(stack1.empty()) {moveFromStack2ToStack1();}
        stack1.pop();
        return true;
    }
    
    /** Get the front item from the deque. */
    int getFront() {
        if(isEmpty()) return -1;
        if(stack2.empty()) {moveFromStack1ToStack2();}
        return stack2.top();
    }
    
    /** Get the last item from the deque. */
    int getRear() {
        if(isEmpty()) return -1;
        if(stack1.empty()) {moveFromStack2ToStack1();}
        return stack1.top();
    }
    
    /** Checks whether the circular deque is empty or not. */
    bool isEmpty() {
        return stack1.empty() && stack2.empty();
    }
    
    /** Checks whether the circular deque is full or not. */
    bool isFull() {
        return stack1.size() + stack2.size() >= maxSize;
    }

    void moveFromStack1ToStack2(){
        while(!stack1.empty()){
            stack2.push(stack1.top());
            stack1.pop();
        }
    }

    void moveFromStack2ToStack1(){
        while(!stack2.empty()){
            stack1.push(stack2.top());
            stack2.pop();
        }
    }
};

/**
 * Your MyCircularDeque object will be instantiated and called as such:
 * MyCircularDeque* obj = new MyCircularDeque(k);
 * bool param_1 = obj->insertFront(value);
 * bool param_2 = obj->insertLast(value);
 * bool param_3 = obj->deleteFront();
 * bool param_4 = obj->deleteLast();
 * int param_5 = obj->getFront();
 * int param_6 = obj->getRear();
 * bool param_7 = obj->isEmpty();
 * bool param_8 = obj->isFull();
 */