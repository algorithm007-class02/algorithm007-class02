package com.leetcode.tree;

import java.util.*;

/**
 * 590. N叉树的后序遍历
 * 给定一个 N 叉树，返回其节点值的后序遍历。
 * 左子树 -> 右子树 -> 根
 *
 * 说明: 递归法很简单，你可以使用迭代法完成此题吗?
 */
public class L590NthTreePostTrav {
    /**
     * 递归解法
     */
    public List<Integer> postorder1(Node root) {
        List<Integer> result = new ArrayList<>();
        dfs(root, result);
        return result;
    }

    void dfs(Node node, List<Integer> result) {
        if (node == null) {
            return;
        }

        for (Node child : node.children) {
            dfs(child, result);
        }
        result.add(node.val);
    }

    /**
     * 迭代解法
     */
    public List<Integer> postorder(Node root) {
        LinkedList<Integer> result = new LinkedList<>();
        if (root == null) {
            return result;
        }

        Stack<Node> stack = new Stack<>();
        stack.push(root);

        while (!stack.empty()) {
            Node node = stack.pop();
            result.addFirst(node.val);

            for (Node child : node.children) {
                stack.push(child);
            }
        }
        return result;
    }
}
