type MyCircularDeque struct {
    data []int
    cap int
    count int
    head int
    tail int
}


/** Initialize your data structure here. Set the size of the deque to be k. */
func Constructor(k int) MyCircularDeque {
    t := MyCircularDeque{}
    t.data = make([]int, k)
    t.cap = k
    t.count = 0
    t.head = -1
    t.tail = -1
    return t
}


/** Adds an item at the front of Deque. Return true if the operation is successful. */
func (this *MyCircularDeque) InsertFront(value int) bool {
    if this.count == this.cap {
        return false
    }
    this.head = (this.head - 1 + this.cap) % this.cap
    this.data[this.head] = value
    if this.tail == - 1 {
        this.tail = this.head
    }
    this.count++
    return true
}


/** Adds an item at the rear of Deque. Return true if the operation is successful. */
func (this *MyCircularDeque) InsertLast(value int) bool {
    if this.count == this.cap {
        return false
    }
    this.tail = (this.tail + 1 + this.cap) % this.cap
    this.data[this.tail] = value
    if this.head == - 1 {
        this.head = this.tail
    }
    this.count++
    return true
}


/** Deletes an item from the front of Deque. Return true if the operation is successful. */
func (this *MyCircularDeque) DeleteFront() bool {
    if this.count == 0 {
        return false
    }
    this.data[this.head] = 0
    this.head = (this.head + 1 + this.cap) % this.cap
    this.count--
    return true
}


/** Deletes an item from the rear of Deque. Return true if the operation is successful. */
func (this *MyCircularDeque) DeleteLast() bool {
    if this.count == 0 {
        return false
    }
    this.data[this.tail] = 0
    this.tail = (this.tail - 1 + this.cap) % this.cap
    this.count--
    return true
}


/** Get the front item from the deque. */
func (this *MyCircularDeque) GetFront() int {
    if this.count == 0 {
        return -1
    }
    return this.data[this.head]
}


/** Get the last item from the deque. */
func (this *MyCircularDeque) GetRear() int {
    if this.count == 0 {
        return -1
    }
    return this.data[this.tail]
}


/** Checks whether the circular deque is empty or not. */
func (this *MyCircularDeque) IsEmpty() bool {
    return this.count == 0
}


/** Checks whether the circular deque is full or not. */
func (this *MyCircularDeque) IsFull() bool {
    return this.count == this.cap
}


/**
 * Your MyCircularDeque object will be instantiated and called as such:
 * obj := Constructor(k);
 * param_1 := obj.InsertFront(value);
 * param_2 := obj.InsertLast(value);
 * param_3 := obj.DeleteFront();
 * param_4 := obj.DeleteLast();
 * param_5 := obj.GetFront();
 * param_6 := obj.GetRear();
 * param_7 := obj.IsEmpty();
 * param_8 := obj.IsFull();
 */
 