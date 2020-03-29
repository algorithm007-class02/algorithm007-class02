/**
 * 641. 设计循环双端队列
 * 
 * */

//链表实现
struct node{
    int data;
    struct node* next;
    struct node* prev;
};

typedef struct {
    int len;
    int cnt;
    struct node* head;
    struct node* tail;
} MyCircularDeque;

/** Initialize your data structure here. Set the size of the deque to be k. */

MyCircularDeque* myCircularDequeCreate(int k) {
    MyCircularDeque* deque = malloc(sizeof(MyCircularDeque));
    struct node* head = malloc(sizeof(struct node));
    struct node* tail = malloc(sizeof(struct node));
    head->next = tail;
    head->prev = NULL;
    tail->prev = head;
    tail->next = NULL;

    deque->len = k;
    deque->cnt = 0;
    deque->head = head;
    deque->tail = tail;

    return deque;
}

/** Adds an item at the front of Deque. Return true if the operation is successful. */
bool myCircularDequeInsertFront(MyCircularDeque* obj, int value) {
    if(obj->cnt >= obj->len)
        return false;

    struct node* n = malloc(sizeof(struct node));
    n->data = value;
    n->next = obj->head->next;
    n->prev = obj->head;
    
    n->next->prev   = n;
    obj->head->next = n;
    obj->cnt++;

    return true;
}

/** Adds an item at the rear of Deque. Return true if the operation is successful. */
bool myCircularDequeInsertLast(MyCircularDeque* obj, int value) {
    if(obj->cnt >= obj->len)
        return false;

    struct node* n = malloc(sizeof(struct node));
    n->data = value;
    n->next = obj->tail;
    n->prev = obj->tail->prev;

    n->prev->next   = n;
    obj->tail->prev = n;
    obj->cnt++;

    return true;
}

/** Deletes an item from the front of Deque. Return true if the operation is successful. */
bool myCircularDequeDeleteFront(MyCircularDeque* obj) {
    if(obj->cnt == 0)
        return false;

    struct node* first = obj->head->next;
    obj->head->next   = first->next;
    first->next->prev = obj->head;
    free(first);
    obj->cnt--;

    return true;
}

/** Deletes an item from the rear of Deque. Return true if the operation is successful. */
bool myCircularDequeDeleteLast(MyCircularDeque* obj) {
    if(obj->cnt == 0) 
        return false;
    
    struct node* last = obj->tail->prev;
    last->prev->next = obj->tail;
    obj->tail->prev  = last->prev;
    free(last);
    obj->cnt--;

    return true;
}

/** Get the front item from the deque. */
int myCircularDequeGetFront(MyCircularDeque* obj) {
    return (obj->cnt>0)?obj->head->next->data:-1;
}

/** Get the last item from the deque. */
int myCircularDequeGetRear(MyCircularDeque* obj) {
    return (obj->cnt>0)?obj->tail->prev->data:-1;
}

/** Checks whether the circular deque is empty or not. */
bool myCircularDequeIsEmpty(MyCircularDeque* obj) {
    return obj->cnt == 0;
}

/** Checks whether the circular deque is full or not. */
bool myCircularDequeIsFull(MyCircularDeque* obj) {
    return obj->cnt >= obj->len;
}

void myCircularDequeFree(MyCircularDeque* obj) {
    while(obj->head != NULL) {
        struct node* n = obj->head;
        obj->head = n->next;
        free(n);
    }
    free(obj);
}

/**
 * Your MyCircularDeque struct will be instantiated and called as such:
 * MyCircularDeque* obj = myCircularDequeCreate(k);
 * bool param_1 = myCircularDequeInsertFront(obj, value);
 
 * bool param_2 = myCircularDequeInsertLast(obj, value);
 
 * bool param_3 = myCircularDequeDeleteFront(obj);
 
 * bool param_4 = myCircularDequeDeleteLast(obj);
 
 * int param_5 = myCircularDequeGetFront(obj);
 
 * int param_6 = myCircularDequeGetRear(obj);
 
 * bool param_7 = myCircularDequeIsEmpty(obj);
 
 * bool param_8 = myCircularDequeIsFull(obj);
 
 * myCircularDequeFree(obj);
*/


//数组实现

typedef struct {
    int len;
    int cnt;
    int head;
    int tail;
    int *data;
} MyCircularDeque;

/** Initialize your data structure here. Set the size of the deque to be k. */

MyCircularDeque* myCircularDequeCreate(int k) {
    int *data = malloc(sizeof(int)*k);
    MyCircularDeque* deque = malloc(sizeof(MyCircularDeque));
    deque->len  = k;
    deque->cnt  = 0;
    deque->data = data;
    deque->head = 0;
    deque->tail = 1;

    return deque;
}

/** Adds an item at the front of Deque. Return true if the operation is successful. */
bool myCircularDequeInsertFront(MyCircularDeque* obj, int value) {
    if(obj->cnt >= obj->len) 
        return false;
    obj->data[obj->head] = value;
    ++obj->cnt;
    obj->head = (obj->head-1+obj->len)%obj->len;
    return true;
}

/** Adds an item at the rear of Deque. Return true if the operation is successful. */
bool myCircularDequeInsertLast(MyCircularDeque* obj, int value) {
    if(obj->cnt >= obj->len) 
        return false;
    obj->data[obj->tail] = value;
    ++obj->cnt;
    obj->tail = (obj->tail+1+obj->len)%obj->len;
    return true;
}

/** Deletes an item from the front of Deque. Return true if the operation is successful. */
bool myCircularDequeDeleteFront(MyCircularDeque* obj) {
    if(obj->cnt == 0) 
        return false;
    obj->cnt--;
    obj->head = (obj->head+1+obj->len)%obj->len;
    return true;
}

/** Deletes an item from the rear of Deque. Return true if the operation is successful. */
bool myCircularDequeDeleteLast(MyCircularDeque* obj) {
    if(obj->cnt == 0)
        return false;
    obj->cnt--;
    obj->tail = (obj->tail-1+obj->len)%obj->len;
    return true;
}

/** Get the front item from the deque. */
int myCircularDequeGetFront(MyCircularDeque* obj) {
    return (obj->cnt == 0)?-1:obj->data[(obj->head+1+obj->len)%obj->len];
}

/** Get the last item from the deque. */
int myCircularDequeGetRear(MyCircularDeque* obj) {
    return (obj->cnt == 0)?-1:obj->data[(obj->tail-1+obj->len)%obj->len];
}

/** Checks whether the circular deque is empty or not. */
bool myCircularDequeIsEmpty(MyCircularDeque* obj) {
    return (obj->cnt == 0);
}

/** Checks whether the circular deque is full or not. */
bool myCircularDequeIsFull(MyCircularDeque* obj) {
    return (obj->cnt >= obj->len);
}

void myCircularDequeFree(MyCircularDeque* obj) {
    free(obj->data);
    free(obj);
}