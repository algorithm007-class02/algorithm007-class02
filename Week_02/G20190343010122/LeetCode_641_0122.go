package homework

type MyCircularDeque struct {
	values []int
	capacity int
	count int
	headIndex int
	tailIndex int
}


/** Initialize your data structure here. Set the size of the deque to be k. */
func Constructor(k int) MyCircularDeque {
	circularDeque := MyCircularDeque{}
	circularDeque.capacity = k
	circularDeque.count = 0
	circularDeque.headIndex = 0
	circularDeque.tailIndex = 0
	circularDeque.values = make([]int, k)


	return circularDeque
}


/** Adds an item at the front of Deque. Return true if the operation is successful. */
func (this *MyCircularDeque) InsertFront(value int) bool {
	if this.IsFull(){
		return false
	}

	this.headIndex = (this.headIndex -1 + this.capacity)%this.capacity
	this.values[this.headIndex] = value
	this.count++

	return true
}


/** Adds an item at the rear of Deque. Return true if the operation is successful. */
func (this *MyCircularDeque) InsertLast(value int) bool {
	if this.IsFull(){
		return false
	}

	this.values[this.tailIndex] = value
	this.tailIndex = (this.tailIndex+1)%this.capacity
	this.count++

	return true
}


/** Deletes an item from the front of Deque. Return true if the operation is successful. */
func (this *MyCircularDeque) DeleteFront() bool {

	if this.IsEmpty(){
		return false
	}

	this.headIndex = (this.headIndex+1)%this.capacity

	this.count--

	return true
}


/** Deletes an item from the rear of Deque. Return true if the operation is successful. */
func (this *MyCircularDeque) DeleteLast() bool {
	if this.IsEmpty(){
		return false
	}

	this.tailIndex = (this.tailIndex-1 + this.capacity)%this.capacity

	this.count --
	return true
}


/** Get the front item from the deque. */
func (this *MyCircularDeque) GetFront() int {
	if this.count == 0{
		return -1
	}

	return this.values[this.headIndex]
}

/** Get the last item from the deque. */
func (this *MyCircularDeque) GetRear() int {
	if this.count == 0{
		return -1
	}

	return this.values[(this.tailIndex-1+this.capacity)%this.capacity]
}


/** Checks whether the circular deque is empty or not. */
func (this *MyCircularDeque) IsEmpty() bool {
	return this.count == 0
}


/** Checks whether the circular deque is full or not. */
func (this *MyCircularDeque) IsFull() bool {
	return this.capacity == this.count
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
