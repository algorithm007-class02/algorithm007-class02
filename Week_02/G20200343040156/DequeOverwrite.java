public static void main(String[] args) {
        // write your code here

        Deque<String> deque = new LinkedList<>();
//        deque.push("a");
//        deque.push("b");
//        deque.push("c");
        deque.push("b");
        deque.addFirst("c");
        deque.addLast("a");
        System.out.println(deque);
        String str = deque.peek();
        System.out.println(str);
        System.out.println(deque);
        while(deque.size()>0){
        System.out.println(deque.pop());

        }
        System.out.println(deque);
        }