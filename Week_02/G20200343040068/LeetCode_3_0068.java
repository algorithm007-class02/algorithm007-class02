//脑子一团浆糊，学习优秀代码。。
class MyCircularDeque {

        /** Initialize your data structure here. Set the size of the deque to be k. */
        int deque[];
        int front;
        int rear;

        public MyCircularDeque(int k) {
            deque = new int[k];
            front = rear = -1;
        }

        /** Adds an item at the front of Deque. Return true if the operation is successful. */
        public boolean insertFront(int value) {
            if(isFull())
                return false;
            if(rear == -1 && front == -1){
                rear = front = 0;
                deque[rear] = value;
            }else{
                if(front == 0){
                    front = deque.length - 1;
                }else{
                    front--;
                }
                deque[front] = value;
            }
            return true;
        }

        /** Adds an item at the rear of Deque. Return true if the operation is successful. */
        public boolean insertLast(int value) {
            if(isFull())
                return false;
            if(rear == -1 && front == -1){
                rear = front = 0;
                deque[rear] = value;
            }else{
                rear = (rear + 1) % deque.length;
                deque[rear] = value;
            }
            return true;
        }

        /** Deletes an item from the front of Deque. Return true if the operation is successful. */
        public boolean deleteFront() {
            if(isEmpty())
                return false;
            if(front == rear){
                front = rear = -1;
            }else{
                front = (front + 1) % deque.length;
            }
            return true;
        }

        /** Deletes an item from the rear of Deque. Return true if the operation is successful. */
        public boolean deleteLast() {
            if(isEmpty())
                return false;
            if(front == rear){
                front = rear = -1;
            }else{
                if(rear == 0){
                    rear = deque.length - 1;
                }else{
                    rear--;
                }
            }
            return true;
        }

        /** Get the front item from the deque. */
        public int getFront() {
            if(isEmpty())
                return -1;
            return deque[front];
        }

        /** Get the last item from the deque. */
        public int getRear() {
            if(isEmpty())
                return -1;
            return deque[rear];
        }

        /** Checks whether the circular deque is empty or not. */
        public boolean isEmpty() {
            return (front == -1 && rear == -1);
        }

        /** Checks whether the circular deque is full or not. */
        public boolean isFull() {
            return (front == (rear + 1) % deque.length);
        }
    }