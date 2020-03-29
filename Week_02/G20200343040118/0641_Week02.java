class MyCircularDeque {
      private int top;
    private int end;
    private Integer[] nums = null;
    private int length;
    /** Initialize your data structure here. Set the size of the deque to be k. */
    public MyCircularDeque(int k) {
        length = k + 1;
        top = 0 ;
        end = 0 ;
        nums = new Integer[length];
    }
    
    /** Adds an item at the front of Deque. Return true if the operation is successful. */
    public boolean insertFront(int value) {
        if(isFull()){
            return false;
        }
        end = (end - 1 + length) % length;
        nums[end] = value;
        return true;
    }
    
    /** Adds an item at the rear of Deque. Return true if the operation is successful. */
    public boolean insertLast(int value) {
          if(isFull()){
            return false;
        }
        nums[top] = value;
        top = (top + 1 ) % length;
        return true;
    }
    
    /** Deletes an item from the front of Deque. Return true if the operation is successful. */
    public boolean deleteFront() {
         if(isEmpty()){
            return false;
        }
        end = (end + 1)%length;
        return true;
    }
    
    /** Deletes an item from the rear of Deque. Return true if the operation is successful. */
    public boolean deleteLast() {
        if(isEmpty()){
            return false;
        }
        top = (top - 1 + length) % length;
        return true;
    }
    
    /** Get the front item from the deque. */
    public int getFront() {
        if(isEmpty()){
            return -1;
        }
        return nums[end];
    }
    
    /** Get the last item from the deque. */
    public int getRear() {
    if(isEmpty()){
            return -1;
        }
        return nums[(top-1 + length) % length];
    }
    
    /** Checks whether the circular deque is empty or not. */
    public boolean isEmpty() {
        return top == end;
    }
    
    /** Checks whether the circular deque is full or not. */
    public boolean isFull() {
        return (top + 1)%length == end;
    }
}

/**
 * Your MyCircularDeque object will be instantiated and called as such:
 * MyCircularDeque obj = new MyCircularDeque(k);
 * boolean param_1 = obj.insertFront(value);
 * boolean param_2 = obj.insertLast(value);
 * boolean param_3 = obj.deleteFront();
 * boolean param_4 = obj.deleteLast();
 * int param_5 = obj.getFront();
 * int param_6 = obj.getRear();
 * boolean param_7 = obj.isEmpty();
 * boolean param_8 = obj.isFull();
 */