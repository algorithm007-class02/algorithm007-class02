package Week_03.G20200343040246;

import java.util.*;

class LeetCode_590_0246 {

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
    public List<Integer> preorder1(Node root) {
        List<Integer> res = new ArrayList<>();
        helper(root, res);
        return res;
    }

    public void helper(Node root, List<Integer> res) {
        if (root == null) return;
        res.add(root.val);
        for (Node child : root.children) helper(child, res);
    }

    // 2. iteration
    public List<Integer> preorder2(Node root) {
        List<Integer> res = new ArrayList<>();
        if (root == null) return res;

        Stack<Node> stack = new Stack<>();
        stack.add(root);
        while (!stack.isEmpty()) {
            root = stack.pop();
            res.add(root.val);
            if (root.children.size() > 0) {
                for (int i = root.children.size(); i > 0; i--) {
                    stack.add(root.children.get(i));
                }
            }
        }
        return res;
    }

}