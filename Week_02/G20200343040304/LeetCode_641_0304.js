/**
 * Initialize your data structure here. Set the size of the deque to be k.
 * @param {number} k
 */

class Node {
  constructor(value) {
    this.value = value;
    this.pre = null;
    this.next = null;
  }
}

var MyCircularDeque = function (k) {
  this.size = 0;
  this.maxSize = k;
  this.head = null;
  this.tail = null;
};

/**
 * Adds an item at the front of Deque. Return true if the operation is successful. 
 * @param {number} value
 * @return {boolean}
 */
MyCircularDeque.prototype.insertFront = function (value) {
  const node = new Node(value);
  if (this.isFull()) {
    return false;
  }
  if (this.isEmpty()) {
    this.head = node;
    this.tail = node;
  } else {
    node.next = this.head;
    this.head.pre = node;
    this.head = node;
  }
  this.size++;
  return true;
};

/**
 * Adds an item at the rear of Deque. Return true if the operation is successful. 
 * @param {number} value
 * @return {boolean}
 */
MyCircularDeque.prototype.insertLast = function (value) {
  const node = new Node(value);
  if (this.isFull()) {
    return false;
  }
  if (this.isEmpty()) {
    this.head = node;
    this.tail = node;
  } else {
    this.tail.next = node;
    node.pre = this.tail;
    this.tail = node;
  }
  this.size++;
  return true;
};

/**
 * Deletes an item from the front of Deque. Return true if the operation is successful.
 * @return {boolean}
 */
MyCircularDeque.prototype.deleteFront = function () {
  if (this.isEmpty()) {
    return false;
  }
  if (this.size === 1) {
    this.head = this.tail = null;
    this.size = 0;
    return true;
  }
  const firstNode = this.head.next;
  firstNode.pre = null;
  this.head = firstNode;
  this.size--;
  return true;
};

/**
 * Deletes an item from the rear of Deque. Return true if the operation is successful.
 * @return {boolean}
 */
MyCircularDeque.prototype.deleteLast = function () {
  if (this.isEmpty()) {
    return false;
  }
  if (this.size === 1) {
    this.head = this.tail = null;
    this.size = 0;
    return true;
  }
  const lastNode = this.tail.pre;
  lastNode.next = null;
  this.tail = lastNode;
  this.size--;
  return true;
};

/**
 * Get the front item from the deque.
 * @return {number}
 */
MyCircularDeque.prototype.getFront = function () {
  if (this.isEmpty()) {
    return -1;
  }
  return this.head.value;
};

/**
 * Get the last item from the deque.
 * @return {number}
 */
MyCircularDeque.prototype.getRear = function () {
  if (this.isEmpty()) {
    return -1;
  }
  return this.tail.value;
};

/**
 * Checks whether the circular deque is empty or not.
 * @return {boolean}
 */
MyCircularDeque.prototype.isEmpty = function () {
  if (this.size === 0) {
    return true;
  }
  return false;
};

/**
 * Checks whether the circular deque is full or not.
 * @return {boolean}
 */
MyCircularDeque.prototype.isFull = function () {
  if (this.size === this.maxSize) {
    return true;
  }
  return false;
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