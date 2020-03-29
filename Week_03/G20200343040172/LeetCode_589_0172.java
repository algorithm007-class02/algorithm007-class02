package week03.g20200343040172;

import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

/**
 * https://leetcode-cn.com/problems/n-ary-tree-preorder-traversal/description/
 * 本周作业
 * LeetCode-589 N ary tree preorder traversal N叉树的前序遍历
 */
public class LeetCode_589_0172 {

    List<Integer> list = new ArrayList<>();

    /**
     * 使用递归
     *
     * @param root
     * @return
     */
    public List<Integer> preorder_1(Node root) {
        if (root == null) {
            return list;
        }
        list.add(root.val);
        for (Node node : root.children) {
            preorder_1(node);
        }
        return list;
    }

    /**
     * 使用迭代的方法，使用了Stack和List
     * @param root
     * @return
     */
    public List<Integer> preorder_2(Node root) {
        LinkedList<Node> stack = new LinkedList<>();
        LinkedList<Integer> output = new LinkedList<>();
        if (root == null) {
            return output;
        }

        stack.add(root);
        while (!stack.isEmpty()) {
            Node node = stack.pollLast();
            output.add(node.val);
            Collections.reverse(node.children);
            for (Node item : node.children) {
                stack.add(item);
            }
        }
        return output;
    }
}

class Node {
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

