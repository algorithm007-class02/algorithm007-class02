typedef struct {
    int capture;
    int usecnt;
    int head;
    int tail;
    int *data;
} MyCircularDeque;

bool myCircularDequeIsEmpty(MyCircularDeque* obj);
bool myCircularDequeIsFull(MyCircularDeque* obj);

/** Initialize your data structure here. Set the size of the deque to be k. */

MyCircularDeque* myCircularDequeCreate(int k) {
    if (k == 0)
        return NULL;
    
    MyCircularDeque *circularQ = (MyCircularDeque *)malloc(sizeof(MyCircularDeque));
    if (circularQ == NULL)
        return NULL;
    
    memset(circularQ, 0, sizeof(MyCircularDeque));

    circularQ->data = (int *)malloc(sizeof(int) * k);
    memset(circularQ->data, 0, sizeof(sizeof(int) * k));
    circularQ->data[0] = -1;

    circularQ->head = 0;
    circularQ->tail = 0;
    circularQ->capture = k;
    circularQ->usecnt = 0;

    return circularQ;
}

/** Adds an item at the front of Deque. Return true if the operation is successful. */
bool myCircularDequeInsertFront(MyCircularDeque* obj, int value) {
    if (myCircularDequeIsFull(obj))    
        return false;
    
    if (!myCircularDequeIsEmpty(obj))
        obj->head == 0 ? (obj->head = obj->capture-1) : obj->head--;

    obj->data[obj->head] = value;
    obj->usecnt++;

    return true;
}

/** Adds an item at the rear of Deque. Return true if the operation is successful. */
bool myCircularDequeInsertLast(MyCircularDeque* obj, int value) {
    if (myCircularDequeIsFull(obj))    
        return false;
    
    if (!myCircularDequeIsEmpty(obj))
        obj->tail = (obj->tail+1)%obj->capture;

    obj->data[obj->tail] = value;
    obj->usecnt++;

    return true;
}

/** Deletes an item from the front of Deque. Return true if the operation is successful. */
/* 删除元素时, 需要判断head和tail位置来决定是否移动, 要区分最后一个元素情况 */
bool myCircularDequeDeleteFront(MyCircularDeque* obj) {
    if (myCircularDequeIsEmpty(obj))
        return false;
    
    obj->data[obj->head] = -1;
    obj->usecnt--;

    if (!myCircularDequeIsEmpty(obj))
        obj->head = (obj->head+1)%obj->capture;

    return true;
}

/** Deletes an item from the rear of Deque. Return true if the operation is successful. */
bool myCircularDequeDeleteLast(MyCircularDeque* obj) {
    if (myCircularDequeIsEmpty(obj))
        return false;

    obj->data[obj->tail] = -1;
    obj->usecnt--;
    
    if (!myCircularDequeIsEmpty(obj))
        obj->tail == 0 ? (obj->tail = obj->capture-1) : obj->tail--;
  
    return true;
}

/** Get the front item from the deque. */
int myCircularDequeGetFront(MyCircularDeque* obj) {
    return obj->data[obj->head];
}

/** Get the last item from the deque. */
int myCircularDequeGetRear(MyCircularDeque* obj) {
    return obj->data[obj->tail];
}

/** Checks whether the circular deque is empty or not. */
bool myCircularDequeIsEmpty(MyCircularDeque* obj) {
    return obj->head == obj->tail && obj->data[obj->head] == -1;
}

/** Checks whether the circular deque is full or not. */
bool myCircularDequeIsFull(MyCircularDeque* obj) {
    return (obj->tail + 1)%obj->capture == obj->head;
}

void myCircularDequeFree(MyCircularDeque* obj) {
    if (obj->data)
        free(obj->data);
    
    free(obj);
    obj = NULL;

    return ;
}
