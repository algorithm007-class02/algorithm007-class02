package com.logic;

import java.util.LinkedList;
import java.util.List;

/**
 * @Auther: welllu
 * @Date: 2020/3/28 16:42
 * @Description:
 */
public class LeeCode_589_0226 {

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

    public List<Integer> preorder(Node root) {
        List<Integer> output = new LinkedList<> ();
        dfs(root,output);
        return output;
    }

    private void dfs(Node node, List<Integer> list) {
        // terminator
        if(node != null) {
            list.add(node.val);
            //process data

            //subproblems
            if(node.children != null && node.children.size() > 0) {
                for(Node child: node.children) {
                    dfs(child, list);
                }
            }
        }

        // restore the current level
    }
}
