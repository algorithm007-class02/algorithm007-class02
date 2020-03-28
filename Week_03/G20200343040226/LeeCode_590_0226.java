package com.logic;

import java.util.LinkedList;
import java.util.List;
import java.util.Stack;

/**
 * @Auther: welllu
 * @Date: 2020/3/28 16:40
 * @Description:
 */
public class LeeCode_590_0226 {

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
        LinkedList<Integer> res = new LinkedList<> ();
        Stack<Node> stack = new Stack<>();

        if(root != null) {
            stack.add(root);
        }

        while(stack.size() > 0) {
            Node node = stack.pop();
            res.addFirst(node.val);
            for(Node child: node.children) {
                stack.add(child);
            }
        }

        return res;
    }



}
