/**

641. 设计循环双端队列

设计实现双端队列。
你的实现需要支持以下操作：

MyCircularDeque(k)：构造函数,双端队列的大小为k。
insertFront()：将一个元素添加到双端队列头部。 如果操作成功返回 true。
insertLast()：将一个元素添加到双端队列尾部。如果操作成功返回 true。
deleteFront()：从双端队列头部删除一个元素。 如果操作成功返回 true。
deleteLast()：从双端队列尾部删除一个元素。如果操作成功返回 true。
getFront()：从双端队列头部获得一个元素。如果双端队列为空，返回 -1。
getRear()：获得双端队列的最后一个元素。 如果双端队列为空，返回 -1。
isEmpty()：检查双端队列是否为空。
isFull()：检查双端队列是否满了。


所有值的范围为 [1, 1000]
操作次数的范围为 [1, 1000]
请不要使用内置的双端队列库。

*/

// 使用双向链表

template<class T> 
struct Node {
	T element;
	Node<T>* next;
	Node<T>* pre;

	Node() {}
	Node(const T& ele) { 
		this->element = ele;
		this->next = NULL;
		this->pre = NULL;
	}
};

class MyCircularDeque {

private:
	int capacity;
	int listSize;
	Node<int>* head;
	Node<int>* tail;

public:
    /** Initialize your data structure here. Set the size of the deque to be k. */
    MyCircularDeque(int k) {
    	capacity = k;
    	head = NULL;
    	tail = NULL;
    	listSize = 0;
    }
    
    /** Adds an item at the front of Deque. Return true if the operation is successful. */
    bool insertFront(int value) {

    	if (listSize + 1 > capacity) {
    		return false;
    	}

    	listSize++;


    	Node<int> *node = new Node(value);
    	if (head == NULL) {
    		head = node;
    		tail = node;
    	} else {
    		head->pre = node;
    		node->next = head;
    		head = node;
    	}

    	return true;
    }
    
    /** Adds an item at the rear of Deque. Return true if the operation is successful. */
    bool insertLast(int value) {

    	if (listSize + 1 > capacity) {
    		return false;
    	}

    	listSize++;

    	Node<int> *node = new Node(value);
    	if (tail == NULL) {
    		head = node;
    		tail = node;
    	} else {
    		tail->next = node;
    		node->pre = tail;
    		tail = node;
    	}

    	return true;
    }
    
    /** Deletes an item from the front of Deque. Return true if the operation is successful. */
    bool deleteFront() {

    	if (head == NULL) {
    		return false;
    	}

    	listSize--;

    	if (listSize <= 0 || head->next == NULL) {
    		head = NULL;
    		tail = NULL;
    	} else {
    		Node<int> *pre = head;
    		head = head->next;
    		head->pre = NULL;
    		delete pre;
    	}
        return true;
    }
    
    /** Deletes an item from the rear of Deque. Return true if the operation is successful. */
    bool deleteLast() {

    	if (tail == NULL) 
            return false;

    	listSize--;

    	if (listSize<=0) {
    		head  = NULL;
    		tail = NULL;
    	}  else {
    		Node<int>* next = tail;
    		tail = tail->pre;
    		tail->next = NULL;
    		delete next;
    	}

        return true;
    }
    
    /** Get the front item from the deque. */
    int getFront() {
        if (head)
            return head->element;
        return -1;
    }
    
    /** Get the last item from the deque. */
    int getRear() {

        if (tail) 
            return tail->element;

        return -1;
    }
    
    /** Checks whether the circular deque is empty or not. */
    bool isEmpty() {

    	return !(listSize > 0);
    }
    
    /** Checks whether the circular deque is full or not. */
    bool isFull() {

    	return listSize == capacity;
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