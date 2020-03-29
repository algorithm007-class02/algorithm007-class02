import java.util.Deque;
import java.util.LinkedList;
import java.util.Stack;

/**
 * ReWriteDeque
 */
public class RewriteDeque {
    public static void main(String[] args) {
        RewriteDeque q = new RewriteDeque();
        q.DequeTest();
        q.DequeTest1();
        q.StrackTest();
    }

    public void DequeTest(){
        Deque<String> deque = new LinkedList<String>();
        deque.push("a");
        deque.push("b");
        deque.push("c");
        System.out.println(deque);

        String str = deque.peek();
        System.out.println(str);
        System.out.println(deque);

        while(deque.size() > 0){
            System.out.println(deque.pop());
        }
        System.out.println(deque);
    }

    public void DequeTest1(){
        Deque<String> deque = new LinkedList<String>();
        deque.addFirst("a");
        deque.addFirst("b");
        deque.addFirst("c");
        System.out.println(deque);

        String str = deque.peekFirst();
        System.out.println(str);
        System.out.println(deque);

        while(deque.size() > 0){
            System.out.println(deque.removeFirst());
        }
        System.out.println(deque);
    }

    public void StrackTest(){
        Stack<Integer> stack = new Stack<>();
        stack.push(1);
        stack.push(2);
        stack.push(4);
        stack.push(3);
        stack.push(5);
        System.out.println(stack);
        System.out.println(stack.search(4));

        stack.pop();
        stack.pop();
        Integer topElement = stack.peek();
        System.out.println(topElement);
        System.out.println("3的位置" + stack.search(3));

    }
}

