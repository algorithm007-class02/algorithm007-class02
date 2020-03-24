/**
 * 
 */
package train;

/**
 * @author Jarod.xu
 *
 */
public class lc_cn_641_MyCircularDeque {
	private int c;

	private int[] items;

	private int head = 0;

	private int tail = 0;

	public lc_cn_641_MyCircularDeque(int capacity) {
		// 浪费一个
		this.c = capacity + 1;
		this.items = new int[capacity];
	}

	public boolean insertFront(int value) {
		if ((this.tail + 1) % this.c == this.head)
			return false;
		this.head = (this.head - 1 + this.c) % this.c;
		this.items[this.head] = value;
		return true;
	}

	public boolean insertLast(int value) {
		if ((this.tail + 1) % this.c == this.head)
			return false;

		this.items[this.tail] = value;
		this.tail = (this.tail + 1) % this.c;
		return true;
	}

	public boolean deleteFront() {
		if (this.tail == this.head)
			return false;

		this.head = (this.head + 1) % this.c;
		return true;
	}

	public boolean deleteLast() {
		if (this.tail == this.head)
			return false;
		this.tail = (this.tail - 1 + this.c) % this.c;
		return true;
	}

	public int getFront() {
		if (this.head == this.tail) {
			return -1;
		}

		return this.items[this.head];
	}

	public int getRear() {
		if (this.head == this.tail) {
			return -1;
		}

		return this.items[(this.tail - 1 + this.c) % this.c];
	}

	public boolean isEmpty() {
		return this.head == this.tail;
	}

	public boolean isFull() {
		return (this.tail + 1) % this.c == this.head;
	}
}
