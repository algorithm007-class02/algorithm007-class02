//数组实现
#include <iostream>
#include <vector>

using namespace std;

class MyCircularDeque {
public:
    /** Initialize your data structure here. Set the size of the deque to be k. */
    MyCircularDeque(int k) {
        capcity = k + 1;
        front = 0;
        rear = 0;
        data.assign(capcity, 0);
    }
    
    /** Adds an item at the front of Deque. Return true if the operation is successful. */
    bool insertFront(int value) {
        if (isFull()) {
            return false;
        }
        front = (front - 1 + capcity) % capcity;
        data[front] = value;
        return true;
    }
    
    /** Adds an item at the rear of Deque. Return true if the operation is successful. */
    bool insertLast(int value) {
        if (isFull()) {
            return false;
        }
        data[rear] = value;
        rear = (rear + 1) %capcity;
        return  true;
    }
    
    /** Deletes an item from the front of Deque. Return true if the operation is successful. */
    bool deleteFront() {
        if (isEmpty()) {
            return false;
        }
        front = (front + 1) % capcity;
        return true;
    }
    
    /** Deletes an item from the rear of Deque. Return true if the operation is successful. */
    bool deleteLast() {
        if (isEmpty()) {
            return false;
        }
        rear = (rear - 1 + capcity) % capcity;
        return true;
    }
    
    /** Get the front item from the deque. */
    int getFront() {
        if (isEmpty())
            return -1;
        return data[front];
    }
    
    /** Get the last item from the deque. */
    int getRear() {
        if (isEmpty())
            return -1;
        return data[(rear - 1 + capcity) % capcity];
    }
    
    /** Checks whether the circular deque is empty or not. */
    bool isEmpty() {
        return rear == front;
    }
    
    /** Checks whether the circular deque is full or not. */
    bool isFull() {
        return (rear + 1) % capcity == front;
    }

private:
    int capcity;
    int front;
    int rear;
    vector<int> data;
};

//利用双向链表实现
class MyCircularDeque {
    struct node {
        node(int value, node* last, node* next) {
            this->value = value;
            this->last = last;
            this->next = next;
        }
        int value;
        node* last;
        node* next;
    };
public:
    /** Initialize your data structure here. Set the size of the deque to be k. */
    MyCircularDeque(int k) {
        capcity = k;
        used = 0;
        head = NULL;
        tail = NULL;
    }
    
    /** Adds an item at the front of Deque. Return true if the operation is successful. */
    bool insertFront(int value) {
        if (isFull())
            return false;

        head = new node(value, NULL, head);
        if (head->next) {
            head->next->last = head;
        }
        else {
            tail = head;
        }
        used++;
        return true;
    }
    
    /** Adds an item at the rear of Deque. Return true if the operation is successful. */
    bool insertLast(int value) {
        if (isFull())
            return false;

        if (tail) {
            tail->next = new node(value, tail, NULL);
            tail = tail->next;
        }
        else {
            tail = new node(value, NULL, NULL);
            head = tail;
        }
        used++;
        return true;
    }
    
    /** Deletes an item from the front of Deque. Return true if the operation is successful. */
    bool deleteFront() {
        if (!isEmpty()) {
            node* temp = head->next;
            delete head;
            head = temp;
            if (!head) {
                tail = NULL;
            }
            else {
                head->last = NULL;
            }
            used--;
            return true;
        }
        return false;
    }
    
    /** Deletes an item from the rear of Deque. Return true if the operation is successful. */
    bool deleteLast() {
        if (!isEmpty()) {
            if (tail->last) {
                tail = tail->last;
                delete tail->next;
                tail->next = NULL;
            }
            else {
                delete tail;
                head = tail  =NULL;
            }
            used--;
            return true;
        }
        return false;
    }
    
    /** Get the front item from the deque. */
    int getFront() {
        if (isEmpty())
            return -1; 
        return head->value;
    }
    
    /** Get the last item from the deque. */
    int getRear() {
        if (isEmpty())
            return -1;
        return tail->value;
    }
    
    /** Checks whether the circular deque is empty or not. */
    bool isEmpty() {
        return head == NULL;
    }
    
    /** Checks whether the circular deque is full or not. */
    bool isFull() {
        return used == capcity;
    }

private:
    int capcity;
    int used;
    node* head;
    node* tail;
};