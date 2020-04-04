package com.wxs.algorithm1.week03;

import java.util.Arrays;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

/**
 * 类描述  ：
 * 创建人  : 吴绪森
 * 创建时间：2020-03-28
 * 修改人  ：
 * 修改时间：
 * 修改备注：
 * 版    本： V1.0
 */

public class LeetCode_589_0316 {


    public static void main(String[] args) {


        Node node1 = new Node();
        node1.val = 1;



        Node node2 = new Node();
        node2.val = 2;

        Node node3 = new Node();
        node3.val = 3;


        Node node4 = new Node();
        node4.val = 4;

        node1.children = Arrays.asList(node3,node2,node4);


        Node node5 = new Node();
        node5.val = 5;

        Node node6 = new Node();
        node6.val = 6;

        node3.children = Arrays.asList(node5,node6);


        LeetCode_589_0316 preorder589 = new LeetCode_589_0316();

        preorder589.preorder(node1);


    }



    public List<Integer> preorder(Node root) {


        LinkedList<Node> stack = new LinkedList<>();

        LinkedList<Integer> list = new LinkedList<>();

        stack.add(root);

        while (!stack.isEmpty()) {
            Node node = stack.pollLast();
            list.add(node.val);
            Collections.reverse(node.children);
            for (Node child : node.children) {
                if (child != null) {
                    stack.add(child);
                }
            }


        }

        return list;

    }


}
