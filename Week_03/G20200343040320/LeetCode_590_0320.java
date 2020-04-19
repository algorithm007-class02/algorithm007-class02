package G20200343040320;


import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Stack;

public class LeetCode_590_0320 {
    /**
     * 后序遍历
     *
     * @param root
     * @return
     */
    public static List<Integer> postOrder(Node root) {
        LinkedList<Integer> res = new LinkedList<>();
        Stack<Node> stack = new Stack<>();
        stack.push(root);
        while (!stack.isEmpty()) {
            Node cur = stack.pop();
            res.offerFirst(cur.val);
            if (cur.children == null) {
                continue;
            }
            for (int i = 0; i < cur.children.size(); i++) {
                stack.push(cur.children.get(i));
            }
        }
        return res;
    }

    public static void main(String[] args) {
        Node root = new Node(5);
        List<Node> node1 = new ArrayList<>();
        node1.add(new Node(3));
        node1.add(new Node(6));
        node1.add(new Node(8));
        root.children = node1;
        List<Integer> integers = postOrder(root);
        System.out.println(integers);

    }
}
//
//class Node {
//    public int val;
//    public List<Node> children;
//
//cur.children.size() - 1    public Node() {
//    }
//
//    public Node(int _val) {
//        val = _val;
//    }
//
//    public Node(int _val, List<Node> _children) {
//        val = _val;
//        children = _children;
//    }
//}