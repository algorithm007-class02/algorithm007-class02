package com.algorithm.thirdWeek;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 给定一个 N 叉树，返回其节点值的后序遍历。
 */
public class Postorder {

    public static void main(String[] args) {
        Node n1 = new Node(1);
        Node n2 = new Node(2);
        Node n3 = new Node(3);
        Node n4 = new Node(4);
        Node n5 = new Node(5);
        Node n6 = new Node(6);

        List<Node> children1 = new ArrayList<>();
        children1.add(n3);
        children1.add(n2);
        children1.add(n4);
        n1.children = children1;

        List<Node> children3 = new ArrayList<>();
        children3.add(n5);
        children3.add(n6);
        n3.children = children3;


        System.out.println(postorder(n1));
    }

    public static List<Integer> postorder(Node root) {
        if(root == null) {
            return new ArrayList<>();
        }
        if(root.children == null) {
            return Arrays.asList(root.val);
        }

        List<Integer> resList = new ArrayList<>();
        List<Node> list = root.children;
        for(Node node : list) {
            resList.addAll(postorder(node));
        }
        resList.add(root.val);

        return resList;
    }
}

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
}
