/*
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
*/

/*双向链表实现法*/
typedef struct tagData{
    int value;
}DATA;

typedef struct tagListNode{
    struct tagListNode *preNode;
    struct tagListNode *nextNode;
    DATA data;
}LIST_NODE;

class MyCircularDeque {
private:
    LIST_NODE *head;
    LIST_NODE *tail;
    int maxNodeNum;
    int curNodeNum;

public:
    /** Initialize your data structure here. Set the size of the deque to be k. */
    MyCircularDeque(int k) {
        this->head = (LIST_NODE *)malloc(sizeof(LIST_NODE));
        this->tail = (LIST_NODE *)malloc(sizeof(LIST_NODE));

        maxNodeNum = k;
        curNodeNum = 0;

        head->nextNode = tail;
        tail->preNode = head;

        head->preNode = NULL;
        tail->nextNode = NULL;
    }   
    /** Adds an item at the front of Deque. Return true if the operation is successful. */
    bool insertFront(int value) {
        if(this->curNodeNum >= this->maxNodeNum)
        {
            return false;
        }

        LIST_NODE *newNode = (LIST_NODE *)malloc(sizeof(LIST_NODE));
        newNode->data.value = value;

        LIST_NODE *oldNode = this->head->nextNode;

        newNode->nextNode = oldNode;
        this->head->nextNode = newNode;

        newNode->preNode = this->head;
        oldNode->preNode = newNode;

        this->curNodeNum++;

        return true;
    }
    
    /** Adds an item at the rear of Deque. Return true if the operation is successful. */
    bool insertLast(int value) {
        if(this->curNodeNum >= this->maxNodeNum)
        {
            return false;
        }

        LIST_NODE *newNode = (LIST_NODE *)malloc(sizeof(LIST_NODE));
        newNode->data.value = value;

        LIST_NODE *oldNode = this->tail->preNode;

        newNode->nextNode = tail;
        this->tail->preNode = newNode;

        newNode->preNode = oldNode;
        oldNode->nextNode = newNode;

        this->curNodeNum++;

        return true;
    }
    
    /** Deletes an item from the front of Deque. Return true if the operation is successful. */
    bool deleteFront() {
        if(0 >= this->curNodeNum)
        {
            return false;
        }

        LIST_NODE *deleteNode = head->nextNode;
        LIST_NODE *oldNode = head->nextNode->nextNode;

        head->nextNode = oldNode;
        oldNode->preNode = head;

        free(deleteNode);

        this->curNodeNum--;
        return true;
    }
    
    /** Deletes an item from the rear of Deque. Return true if the operation is successful. */
    bool deleteLast() {
        if(0 >= this->curNodeNum)
        {
            return false;
        }

        LIST_NODE *deleteNode = tail->preNode;
        LIST_NODE *oldNode = tail->preNode->preNode;

        tail->preNode = oldNode;
        oldNode->nextNode = tail;

        free(deleteNode);

        this->curNodeNum--;
        return true;
    }
    
    /** Get the front item from the deque. */
    int getFront() {
        if(0 >= this->curNodeNum)
        {
            return -1;
        }

        return head->nextNode->data.value;
    }
    
    /** Get the last item from the deque. */
    int getRear() {
        if(0 >= this->curNodeNum)
        {
            return -1;
        }

        return tail->preNode->data.value;
    }
    
    /** Checks whether the circular deque is empty or not. */
    bool isEmpty() {
        if(0 >= this->curNodeNum)
        {
            return true;
        }
        return false;
    }
    
    /** Checks whether the circular deque is full or not. */
    bool isFull() {
        if(this->curNodeNum >= this->maxNodeNum)
        {
            return true;
        }
        return false;
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