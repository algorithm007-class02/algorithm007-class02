package com.alang.learn.week3;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/***
 *给定一个 N 叉树，返回其节点值的后序遍历。
 *
 * 例如，给定一个 3叉树 :
 *
 *
 *
 *
 *
 *
 *
 * 返回其后序遍历: [5,6,3,2,4,1].
 */
public class LeetCode_590_0034 {
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
        System.out.println(solution.postorder(node));
        System.out.println(solution.postorder1(node));
    }

    static  class Node {
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
    }

    static class Solution {
        public List<Integer> postorder(Node root) {
            LinkedList<Integer> res = new LinkedList<>();
            if(root == null)return res;
            LinkedList<Node> queue = new LinkedList<Node>();
            queue.add(root);
            while(!queue.isEmpty()){
                Node current = queue.pollLast();
                res.addFirst(current.val);
                if(current.children != null){
                    for(Node child:current.children){
                        if(child != null){
                            queue.add(child);
                        }
                    }
                }
            }
            return res;
        }

        public List<Integer> postorder1(Node root) {
            ArrayList<Integer> res = new ArrayList<>();
            if(root == null)return res;
            helper(root,res);
            return res;
        }
        private void helper(Node root,List<Integer> res){
            int size = root.children == null?0:root.children.size();
            Node child;
            for(int i = 0;i<size;i++){
                child = root.children.get(i);
                if(child == null)continue;
                helper(child,res);
            }
            res.add(root.val);
        }
    }
}
