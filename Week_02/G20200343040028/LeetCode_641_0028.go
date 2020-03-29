package G20200343040028

type MyCircularDeque struct {
	Val  []int
	Size int
}

/** Initialize your data structure here. Set the size of the deque to be k. */
func Constructor(k int) MyCircularDeque {
	return MyCircularDeque{Val: make([]int, 0, k), Size: k}
}

/** Adds an item at the front of Deque. Return true if the operation is successful. */
func (d *MyCircularDeque) InsertFront(value int) bool {
	return d.Insert(value, 0)
}

/** Adds an item at the rear of Deque. Return true if the operation is successful. */
func (d *MyCircularDeque) InsertLast(value int) bool {
	return d.Insert(value, 1)
}

func (d *MyCircularDeque) Insert(value, pos int) bool {
	// 1.验证容量
	if d.IsFull() {
		return false
	}
	if pos == 0 {
		d.Val = append(d.Val, 0)
		copy(d.Val[1:], d.Val[0:len(d.Val)-1])
		d.Val[0] = value
	} else {
		d.Val = append(d.Val, value)
	}
	return true
}

/** Deletes an item from the front of Deque. Return true if the operation is successful. */
func (d *MyCircularDeque) DeleteFront() bool {
	return d.Delete(0)
}

/** Deletes an item from the rear of Deque. Return true if the operation is successful. */
func (d *MyCircularDeque) DeleteLast() bool {
	return d.Delete(1)
}

func (d *MyCircularDeque) Delete(pos int) bool {
	if d.IsEmpty() {
		return false
	}
	if pos == 0 {
		d.Val = d.Val[1:]
	} else {
		d.Val = d.Val[:len(d.Val)-1]
	}
	return true
}

/** Get the front item from the deque. */
func (d *MyCircularDeque) GetFront() int {
	if d.IsEmpty() {
		return -1
	}
	return d.Val[0]
}

/** Get the last item from the deque. */
func (d *MyCircularDeque) GetRear() int {
	if d.IsEmpty() {
		return -1
	}
	return d.Val[len(d.Val)-1]
}

/** Checks whether the circular deque is empty or not. */
func (d *MyCircularDeque) IsEmpty() bool {
	return len(d.Val) == 0
}

/** Checks whether the circular deque is full or not. */
func (d *MyCircularDeque) IsFull() bool {
	return len(d.Val) == d.Size
}

/**
 * Your MyCircularDequeLinkNode object will be instantiated and called as such:
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
