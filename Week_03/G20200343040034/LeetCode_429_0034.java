package com.alang.learn.week3;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/***
 给定一个 N 叉树，返回其节点值的层序遍历。 (即从左到右，逐层遍历)。

 例如，给定一个 3叉树 :

  



  

 返回其层序遍历:

 [
 [1],
 [3,2,4],
 [5,6]
 ]
  

 说明:

 树的深度不会超过 1000。
 树的节点总数不会超过 5000。

 来源：力扣（LeetCode）
 链接：https://leetcode-cn.com/problems/n-ary-tree-level-order-traversal
 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class LeetCode_429_0034 {
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
        System.out.println(solution.levelOrder(node));
        System.out.println(solution.levelOrder1(node));
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
        public List<List<Integer>> levelOrder(Node root) {
            ArrayList<List<Integer>> res = new ArrayList<>();
            if (root == null) return res;
            LinkedList<Node> queue = new LinkedList<>();
            queue.add(root);
            Node current;
            while (!queue.isEmpty()) {
                int size = queue.size();
                ArrayList<Integer> list = new ArrayList<>();
                for (int i = 0; i < size; i++) {
                    current = queue.pollFirst();
                    if (current == null) continue;
                    list.add(current.val);
                    if (current.children != null) {
                        queue.addAll(current.children);
                    }
                }
                res.add(list);
            }
            return res;
        }

        public List<List<Integer>> levelOrder1(Node root) {
            ArrayList<List<Integer>> res = new ArrayList<>();
            if (root == null) return res;
            helper(root, 0, res);
            return res;
        }

        public void helper(Node node, int level, List<List<Integer>> res) {
            if (res.size() == level) {
                res.add(new ArrayList<>());
            }
            res.get(level).add(node.val);
            if (node.children != null) {
                for (Node n : node.children) {
                    if (n != null) helper(n, level + 1, res);
                }
            }
        }
    }
}
