package com.heiko;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

//给定一个 N 叉树，返回其节点值的后序遍历。
//
// 例如，给定一个 3叉树 :
//
// 返回其后序遍历: [5,6,3,2,4,1].
public class LeetCode_590_0100 {
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

    public List<Integer> postorder(Node root) {
        ArrayList<Integer> results = new ArrayList<>();
        if (root == null) return results;

        Stack<Node> stackCurrent = new Stack<>();
        Stack<Node> stackReserved = new Stack<>();

        stackCurrent.add(root);
        while (!stackCurrent.isEmpty()) {
            Node top = stackCurrent.pop();
            stackReserved.push(top);
            for (int i = 0; i < top.children.size(); i++) {
                stackCurrent.push(top.children.get(i));
            }
        }

        while (!stackReserved.isEmpty()) {
            results.add(stackReserved.pop().val);
        }
        return results;
    }
}

