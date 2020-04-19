package Week_03.G20200343040246;

import java.util.*;

class LeetCode_589_0246 {

    class Node {
        public int val;
        public List<Node> children;

        public Node() {}
        public Node(int _val) {
            val = _val;
        }
        public Node(int _val, List<Node> _children) {
            val = _val;
            children = _children;
        }
    };

    public static void main(String[] args) {
        
    }

    // 1. recursion
    public List<Integer> postorder1(Node root) {
        List<Integer> res = new ArrayList<>();
        helper(root, res);
        return res;
    }

    public void helper(Node root, List<Integer> res) {
        if (root == null) return;
        for (Node child : root.children) {
            helper(child, res);
        }
        res.add(root.val);
    }

    // 2. iteration
    public List<Integer> postoder2(Node root) {
        List<Integer> res = new ArrayList<>();
        if (root == null) return res;

        Stack<Node> stack1 = new Stack<>();
        Stack<Node> stack2 = new Stack<>();
        stack1.add(root);

        while(!stack1.isEmpty()) {
            Node top = stack1.pop();
            stack2.push(top);
            for (Node child : top.children) {
                stack1.push(child);
            }
        }

        while(!stack2.isEmpty()) {
            res.add(stack2.pop().val);
        }
        return res;
    }

}