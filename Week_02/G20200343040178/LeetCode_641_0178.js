/*
 * @Author: mingxing.huang
 * @Date: 2020-03-20 14:59:51
 */
/**
 * 设计实现双端队列。
   你的实现需要支持以下操作：
   MyCircularDeque(k)：构造函数,双端队列的大小为k。
   insertFront()：将一个元素添加到双端队列头部。 如果操作成功返回 true。
   insertLast()：将一个元素添加到双端队列尾部。如果操作成功返回 true。
   deleteFront()：从双端队列头部删除一个元素。 如果操作成功返回 true。
   deleteLast()：从双端队列尾部删除一个元素。如果操作成功返回 true。
   getFront()：从双端队列头部获得一个元素。如果双端队列为空，返回 -1。
   getRear()：获得双端队列的最后一个元素。 如果双端队列为空，返回 -1。
   isEmpty()：检查双端队列是否为空。
   isFull()：检查双端队列是否满了。
 * Initialize your data structure here. Set the size of the deque to be k.
 * @param {number} k
 */
var MyCircularDeque = function(k) {
  // 用数组实现双端队列
  this.q = [];
  this.size = k;
};

/**
 * Adds an item at the front of Deque. Return true if the operation is successful.
 * @param {number} value
 * @return {boolean}
 */
MyCircularDeque.prototype.insertFront = function(value) {
  if (this.isFull()) {
    return false;
  }
  this.q.splice(0, 0, value);
  return true;
};

/**
 * Adds an item at the rear of Deque. Return true if the operation is successful.
 * @param {number} value
 * @return {boolean}
 */
MyCircularDeque.prototype.insertLast = function(value) {
  if (this.isFull()) {
    return false;
  }
  this.q.push(value);
  return true;
};

/**
 * Deletes an item from the front of Deque. Return true if the operation is successful.
 * @return {boolean}
 */
MyCircularDeque.prototype.deleteFront = function() {
  if (this.isEmpty()) {
    return false;
  }
  this.q.splice(0, 1);
  return true;
};

/**
 * Deletes an item from the rear of Deque. Return true if the operation is successful.
 * @return {boolean}
 */
MyCircularDeque.prototype.deleteLast = function() {
  if (this.isEmpty()) {
    return false;
  }
  this.q.pop();
  return true;
};

/**
 * Get the front item from the deque.
 * @return {number}
 */
MyCircularDeque.prototype.getFront = function() {
  if (this.isEmpty()) {
    return -1;
  }
  return this.q[0];
};

/**
 * Get the last item from the deque.
 * @return {number}
 */
MyCircularDeque.prototype.getRear = function() {
  if (this.isEmpty()) {
    return -1;
  }
  return this.q[this.q.length - 1];
};

/**
 * Checks whether the circular deque is empty or not.
 * @return {boolean}
 */
MyCircularDeque.prototype.isEmpty = function() {
  return this.q.length === 0;
};

/**
 * Checks whether the circular deque is full or not.
 * @return {boolean}
 */
MyCircularDeque.prototype.isFull = function() {
  return this.q.length === this.size;
};

/**
 * Your MyCircularDeque object will be instantiated and called as such:
 * var obj = new MyCircularDeque(k)
 * var param_1 = obj.insertFront(value)
 * var param_2 = obj.insertLast(value)
 * var param_3 = obj.deleteFront()
 * var param_4 = obj.deleteLast()
 * var param_5 = obj.getFront()
 * var param_6 = obj.getRear()
 * var param_7 = obj.isEmpty()
 * var param_8 = obj.isFull()
 */
