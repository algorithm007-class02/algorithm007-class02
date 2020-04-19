package com.algorithm.thirdWeek;

import java.util.ArrayList;
import java.util.List;

/**
 * 给定一个 N 叉树，返回其节点值的前序遍历。
 */
public class Preorder {

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

        System.out.println(preorder(n1));
    }

    public static List<Integer> preorder(Node root) {
        if(root == null) {
            return new ArrayList<>();
        }

        List<Integer> resList = new ArrayList<>();
        resList.add(root.val);
        if(root.children != null) {
            for(Node node : root.children) {
                resList.addAll(preorder(node));
            }
        }

        return resList;
    }
}

