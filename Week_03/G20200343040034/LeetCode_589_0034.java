package com.alang.learn.week3;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Stack;

/***
 *给定一个 N 叉树，返回其节点值的前序遍历。
 *
 * 例如，给定一个 3叉树 :
 *
 *
 *
 *
 *
 *
 *
 * 返回其前序遍历: [1,3,5,6,2,4]
 */
public class LeetCode_589_0034 {
    public static void main(String[] args) {
        Solution solution = new Solution();
        Node node = new Node(1);
        Node node1 = new Node(3);
        Node node2 = new Node(2);
        Node node3 = new Node(4);
        Node node4 = new Node(5);
        Node node5 = new Node(6);
        node.children = new ArrayList<>();
        node.children.add(node1);
        node.children.add(node2);
        node.children.add(node3);
        node1.children = new ArrayList<>();
        node1.children.add(null);
        node1.children.add(node4);
        node1.children.add(node5);
        System.out.println(solution.preorder(node));
        System.out.println(solution.preorder1(node));
    }

    static class Node {
        public int val;
        public List<Node> children;

        public Node() {
        }

        public Node(int _val) {
            val = _val;
        }

        public Node(int _val, List<Node> _children) {
            val = _val;
            children = _children;
        }
    }

    static class Solution {
        public List<Integer> preorder(Node root) {
            ArrayList<Integer> res = new ArrayList<>();
            if (root == null) return res;
            Stack<Node> stack = new Stack<>();
            stack.add(root);
            while (!stack.isEmpty()) {
                Node current = stack.pop();
                res.add(current.val);
                if (current.children != null) {
                    for (int i = current.children.size() - 1; i >= 0; i--) {
                        if (current.children.get(i) != null) {
                            stack.push(current.children.get(i));
                        }
                    }
                }
            }
            return res;
        }

        public List<Integer> preorder1(Node root) {
            ArrayList<Integer> res = new ArrayList<>();
            if (root == null) return res;
            helper(root, res);
            return res;
        }

        private void helper(Node root, List<Integer> res) {
            res.add(root.val);
            int size = root.children == null ? 0 : root.children.size();
            Node child;
            for (int i = 0; i < size; i++) {
                child = root.children.get(i);
                if (child == null) continue;
                helper(child, res);
            }
        }
    }
}
