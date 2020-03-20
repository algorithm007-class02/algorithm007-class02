//<?php
/**
 * @lc app=leetcode.cn id=641 lang=php
 * @author 刘兵兵 <lbbniu@gmail.com>
 * 641. 设计循环双端队列
 * 设计实现双端队列。
 * 你的实现需要支持以下操作：
 * 
 * MyCircularDeque(k)：构造函数,双端队列的大小为k。
 * insertFront()：将一个元素添加到双端队列头部。 如果操作成功返回 true。
 * insertLast()：将一个元素添加到双端队列尾部。如果操作成功返回 true。
 * deleteFront()：从双端队列头部删除一个元素。 如果操作成功返回 true。
 * deleteLast()：从双端队列尾部删除一个元素。如果操作成功返回 true。
 * getFront()：从双端队列头部获得一个元素。如果双端队列为空，返回 -1。
 * getRear()：获得双端队列的最后一个元素。 如果双端队列为空，返回 -1。
 * isEmpty()：检查双端队列是否为空。
 * isFull()：检查双端队列是否满了。
 * 
 * 链接：https://leetcode-cn.com/problems/design-circular-deque/
 * 队头入队的时候，front要-1, 队尾出队的时候last -1, -1的时候都需要加上长度在对长度取余，实现循环。
 */
class MyCircularDeque {
    private $data = [];
    private $front = 0;
    private $last = 0;
    private $cap;
    /**
     * Initialize your data structure here. Set the size of the deque to be k.
     * @param Integer $k
     */
    function __construct($k) {
        $this->front = 0;
        $this->last = 0;
        $this->cap = $k + 1;
    }
  
    /**
     * Adds an item at the front of Deque. Return true if the operation is successful.
     * @param Integer $value
     * @return Boolean
     */
    function insertFront($value) {
        if ($this->isFull()) return false;
        $this->front = ($this->front - 1 + $this->cap) % $this->cap;
        $this->data[$this->front] = $value;
        return true;        
    }
  
    /**
     * Adds an item at the rear of Deque. Return true if the operation is successful.
     * @param Integer $value
     * @return Boolean
     */
    function insertLast($value) {
        if ($this->isFull()) return false; 
        $this->data[$this->last] = $value;
        $this->last = ($this->last + 1) % $this->cap;
        return true;
    }
  
    /**
     * Deletes an item from the front of Deque. Return true if the operation is successful.
     * @return Boolean
     */
    function deleteFront() {
        if ($this->isEmpty()) return false; 
        $this->front = ($this->front + 1) % $this->cap;
        return true;
    }
  
    /**
     * Deletes an item from the rear of Deque. Return true if the operation is successful.
     * @return Boolean
     */
    function deleteLast() {
        if ($this->isEmpty()) return false;
        $this->last = ($this->last - 1 + $this->cap) % $this->cap;
        return true;
    }
  
    /**
     * Get the front item from the deque.
     * @return Integer
     */
    function getFront() {
        if ($this->isEmpty()) return -1;
        return $this->data[$this->front];
    }
  
    /**
     * Get the last item from the deque.
     * @return Integer
     */
    function getRear() {
        if ($this->isEmpty()) return -1;
        return $this->data[($this->last - 1 + $this->cap) % $this->cap];
    }
  
    /**
     * Checks whether the circular deque is empty or not.
     * @return Boolean
     */
    function isEmpty() {
        return $this->front == $this->last;        
    }
  
    /**
     * Checks whether the circular deque is full or not.
     * @return Boolean
     */
    function isFull() {
        return $this->front == ($this->last + 1) % $this->cap;
    }
}

/**
 * Your MyCircularDeque object will be instantiated and called as such:
 * $obj = MyCircularDeque($k);
 * $ret_1 = $obj->insertFront($value);
 * $ret_2 = $obj->insertLast($value);
 * $ret_3 = $obj->deleteFront();
 * $ret_4 = $obj->deleteLast();
 * $ret_5 = $obj->getFront();
 * $ret_6 = $obj->getRear();
 * $ret_7 = $obj->isEmpty();
 * $ret_8 = $obj->isFull();
 */
// @lc code=end