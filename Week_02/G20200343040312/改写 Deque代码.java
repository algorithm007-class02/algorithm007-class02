import java.util.Deque;
import java.util.LinkedList;

/**
 * 用 add first 或 add last 这套新的 API 改写 Deque 的代码*/

public class text {
    public static void main(String[] args) {
        Deque<String> deque = new LinkedList<String>();
        deque.addFirst("A");
        deque.addFirst("B");
        deque.addFirst("C");
        System.out.println(deque);

        String strf = deque.peekFirst();
        String strl = deque.peekLast();
        System.out.println(strf);
        System.out.println(strl);
        System.out.println(deque);

        while (deque.size()>0){
            System.out.println(deque.removeFirst());
        }
        System.out.println(deque);
        /**
         * [C, B, A]
         * C
         * A
         * [C, B, A]
         * C
         * B
         * A
         * []*/
    }
}