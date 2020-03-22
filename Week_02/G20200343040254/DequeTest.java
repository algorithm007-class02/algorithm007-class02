/**
 * 
 */
package week02;

import java.util.Deque;
import java.util.LinkedList;

/**
 * @author Jarod.xu
 *
 */
public class DequeTest {
	public static void main(String[] args) {
		Deque<String> deque = new LinkedList<>();

		System.out.println("Stack----FIFO------------------------------------------------");
		deque.push("a");
		deque.push("b");
		deque.push("c");

		System.out.println(deque);

		String str = deque.peek();
		System.out.println(str);

		System.out.println(deque);
		while (deque.size() > 0) {
			System.out.println(deque.pop());
		}

		System.out.println(deque);

		System.out.println("Deque----FIFO===Stack------------------------------------------------");
		deque.addFirst("a");
		deque.addFirst("b");
		deque.addFirst("c");

		System.out.println(deque);

		String str2 = deque.peek();
		System.out.println(str2);
		
		System.out.println(deque);
		while (!deque.isEmpty()) {
			System.out.println(deque.pollFirst());
		}

		System.out.println(deque);

		System.out.println("Deque----LIFO==Stack------------------------------------------------");

		deque.addLast("c");
		deque.addLast("b");
		deque.addLast("a");

		System.out.println(deque);

		String str3 = deque.peek();
		System.out.println(str3);

		System.out.println(deque);
		while (!deque.isEmpty()) {
			System.out.println(deque.pollFirst());
		}

		System.out.println(deque);
	}
}
