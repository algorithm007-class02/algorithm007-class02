package com.algorithm.thirdWeek;

import java.util.ArrayList;
import java.util.List;

/**
 * 给定一个 N 叉树，返回其节点值的层序遍历。 (即从左到右，逐层遍历)。
 *
 * 例如，给定一个 3叉树 :
 *
 *  
 *
 * 返回其层序遍历:
 *
 * [
 *      [1],
 *      [3,2,4],
 *      [5,6]
 * ]
 *  
 *
 * 说明:
 *
 * 树的深度不会超过 1000。
 * 树的节点总数不会超过 5000。
 */
public class LevelOrder {

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

        System.out.println(levelOrder(n1));
    }

    static List<List<Integer>> list = new ArrayList<>();
    public static List<List<Integer>> levelOrder(Node root) {
        if(root == null) {
            return new ArrayList<>();
        }

        levelList(root, 0);

        return list;
    }

    private static void levelList(Node root, int level) {
        if(list.size() <= level) {
            list.add(new ArrayList<>());
        }
        list.get(level).add(root.val);
        for(Node node : root.children) {
            levelList(node, level+1);
        }
    }

}
