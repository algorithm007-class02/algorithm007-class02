class MyCircularDeque {
public:
    /** Initialize your data structure here. Set the size of the deque to be k. */
    vector<int> v;
    int size;
    MyCircularDeque(int k) {
        size=k;
    }
    
    /** Adds an item at the front of Deque. Return true if the operation is successful. */
    bool insertFront(int value) {
        if (v.size()==size) return false;
        v.insert(v.begin(),value);
        return true;
    }
    
    /** Adds an item at the rear of Deque. Return true if the operation is successful. */
    bool insertLast(int value) {
        if (v.size()==size) return false;
        v.push_back(value);
        return true;
    }
    
    /** Deletes an item from the front of Deque. Return true if the operation is successful. */
    bool deleteFront() {
        if (v.size()==0) return false;
        v.erase(v.begin(),v.begin()+1);
        return true;
    }
    
    /** Deletes an item from the rear of Deque. Return true if the operation is successful. */
    bool deleteLast() {
        if (v.size()==0) return false;
        v.erase(v.end()-1,v.end());
        return true;
    }
    
    /** Get the front item from the deque. */
    int getFront() {
        if (v.size()==0) return -1;
        return v[0];
    }
    
    /** Get the last item from the deque. */
    int getRear() {
        if (v.size()==0) return -1;
        return v[v.size()-1];
    }
    
    /** Checks whether the circular deque is empty or not. */
    bool isEmpty() {
        return v.size()==0?true:false;
    }
    
    /** Checks whether the circular deque is full or not. */
    bool isFull() {
        return v.size()==size?true:false;
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