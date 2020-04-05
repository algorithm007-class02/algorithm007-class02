package week_03;

import java.util.NoSuchElementException;

public class BinaryHeap {
	private final static int d = 2;

	private int heap[];

	private int size;

	public BinaryHeap(int capacity) {
		this.size = 0;
		this.heap = new int[capacity + 1];
	}

	public boolean isEmpty() {
		return this.size == 0;
	}

	public boolean isFull() {
		return this.size == this.heap.length;
	}

	public void insert(int value) {
		if (isFull()) {
			throw new NoSuchElementException("Heap is full");
		}
		this.heap[this.size++] = value;
		heapifyUp(this.size-1);

	}

	public int finaMax() {
		if (isEmpty()) {
			throw new NoSuchElementException("Heap is empty");
		}

		return this.heap[0];
	}

	public int deleteMax() {
		return delete(0);
	}

	public String toString() {
		
		StringBuilder s = new StringBuilder("[");

		for (int i = 0; i < this.size; i++) {

			if (s.length() > 1) {
				s.append(",");
			}

			s.append(this.heap[i]);
		}

		s.append("]");

		return s.toString();
	}

	private int delete(int x) {
		if (isEmpty()) {
			throw new NoSuchElementException("Heap is empty");
		}

		int ret = this.heap[x];

		this.heap[x] = this.heap[this.size - 1];

		this.size--;
		heapifyDown(x);

		return ret;

	}

	private int calcParentIndex(int index) {
		return (index - 1) / d;
	}

	private int calcChildIndex(int parentIndex, int childOffset) {
		return parentIndex * d + childOffset;
	}

	private int calcMaxChildIndex(int parentIndex) {

		int l = calcChildIndex(parentIndex, 1);
		int r = calcChildIndex(parentIndex, 2);

		if (this.heap[l] > this.heap[r]) {
			return l;
		} else
			return r;

	}

	private void heapifyUp(int index) {

		int insertValue = this.heap[index];

		while (index > 0) {
			int parentIndex = calcParentIndex(index);

			if (insertValue > this.heap[parentIndex]) {
				this.heap[index] = this.heap[parentIndex];
				index = parentIndex;
			} else {
				break;
			}
		}
		this.heap[index] = insertValue;
	}

	private void heapifyDown(int index) {
		int tempValue = this.heap[index];

		while (calcChildIndex(index, 1) < this.size) {
			int maxChildIndex = calcMaxChildIndex(index);

			if (tempValue >= this.heap[maxChildIndex])
				break;

			this.heap[index] = this.heap[maxChildIndex];
			index = maxChildIndex;
		}

		this.heap[index] = tempValue;
	}

	
	public static void main(String[] args) {
		 BinaryHeap maxHeap = new BinaryHeap(10);
	        maxHeap.insert(10);
	        maxHeap.insert(4);
	        maxHeap.insert(9);
	        maxHeap.insert(1);
	        maxHeap.insert(7);
	        maxHeap.insert(5);
	        maxHeap.insert(3);


	        System.out.println(maxHeap.toString());
	        maxHeap.delete(5);
	        System.out.println(maxHeap.toString());
	        maxHeap.delete(2);
	        System.out.println(maxHeap.toString());
	}
}
