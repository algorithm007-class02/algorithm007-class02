// 641. 设计循环双端队列
// 解法：利使用双端链表数据结构实现
// 难点：主要在于双端链表的构造上：Node结构体、size大小、capacity链表容量、head头指针、tail尾指针。
class MyCircularDeque {
public:
	struct Node {
		int val;
		Node *prev;
		Node *next;
		Node() : val(-1), next(NULL), prev(NULL) {}
		Node(int value) : val(value), next(NULL), prev(NULL) {}
	};
	int size;
	int capacity;
	Node *head;
	Node *tail;
	/** Initialize your data structure here. Set the size of the deque to be k. */
	MyCircularDeque(int k) {
		size = 0;
		capacity = k;
		head = new Node();
		tail = new Node();
		head->next = tail;
		tail->prev = head;
	}
	
	/** Adds an item at the front of Deque. Return true if the operation is successful. */
	bool insertFront(int value) {
		if (isFull()) return false;
		Node *node = new Node(value);
		node->prev = head;
		node->next = head->next;
		node->next->prev = node;
		node->prev->next = node;
		++size;
		return true;
	}
	
	/** Adds an item at the rear of Deque. Return true if the operation is successful. */
	bool insertLast(int value) {
		if (isFull()) return false;
		Node *node = new Node(value);
		node->prev = tail->prev;
		node->next = tail;
		node->next->prev = node;
		node->prev->next = node;
		++size;
		return true;
	}
	
	/** Deletes an item from the front of Deque. Return true if the operation is successful. */
	bool deleteFront() {
		if (isEmpty()) return false;
		Node *node = head->next;
		node->next->prev = node->prev;
		node->prev->next = node->next;
		delete node;
		node = NULL;
		--size;
		return true;
	}
	
	/** Deletes an item from the rear of Deque. Return true if the operation is successful. */
	bool deleteLast() {
		if (isEmpty()) return false;
		Node *node = tail->prev;
		node->prev->next = tail;
		node->next->prev = node->prev;
		delete node;
		node = NULL;
		--size;
		return true;
	}
	
	/** Get the front item from the deque. */
	int getFront() {
		if (isEmpty()) return -1;
		Node *node = head->next;
		return node->val;
	}
	
	/** Get the last item from the deque. */
	int getRear() {
		if (isEmpty()) return -1;
		Node *node = tail->prev;
		return node->val;
	}
	
	/** Checks whether the circular deque is empty or not. */
	bool isEmpty() {
		return size == 0;
	}
	
	/** Checks whether the circular deque is full or not. */
	bool isFull() {
		return size == capacity;
	}
};