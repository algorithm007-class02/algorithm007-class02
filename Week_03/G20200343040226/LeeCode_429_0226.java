package com.logic;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * @Auther: welllu
 * @Date: 2020/3/28 18:05
 * @Description:
 */
public class LeeCode_429_0226 {


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


    public List<List<Integer>> levelOrder(Node root) {
        List<List<Integer>> list = new ArrayList<> ();

        Queue<Node> nodeList = new LinkedList<> ();

        if(root == null) return list;

        nodeList.add(root);

        while (!nodeList.isEmpty()) {
            int count = nodeList.size();
            List<Integer> temp = new ArrayList<>();

            while(count -- > 0) {
                Node node = nodeList.poll();
                temp.add(node.val);
                for (Node child: node.children) {
                    nodeList.add(child);
                }
            }
            list.add(temp);
        }

        return list;
    }
}
