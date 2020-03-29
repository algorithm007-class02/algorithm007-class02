import java.util.*


// homework : re-write the Deque
/**
 * the original code
 * Deque<String> deque = new LinkedList<String>();
 * deque.push("a");
 * deque.push("b");
 * deque.push("c");
 * System.out.println(deque);
 *
 * String str = deque.peek();
 * System.out.println(str);
 * System.out.println(deque);
 *
 * while (deque.size() > 0) {
 *     System.out.println(deque.pop());
 * }
 * System.out.println(deque);
 */
public class Deque {

    public static void main(String[] args) {
        Deque<String> deque = new LinkedList<String>();
        deque.addFirst("a");
        deque.addLast("b");
        deque.addLast("c");
        System.out.println(deque);

        String str = deque.peekFirst();
        System.out.println(str);
        System.out.println(deque);

        while (deque.size() > 0) {
            System.out.println(deque.removeFirst());
        }
        System.out.println(deque);
    }
}