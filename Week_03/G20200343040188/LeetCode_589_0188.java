package com.leetcode.tree;

import java.util.*;

/**
 * 589. N叉树的前序遍历
 * 给定一个 N 叉树，返回其节点值的前序遍历。
 * 当前节点 -> 左子树 -> 右自述
 *
 * 例如，给定一个 3叉树
 * 返回其前序遍历: [1,3,5,6,2,4]。
 *
 * 说明: 递归法很简单，你可以使用迭代法完成此题吗?
 */
public class L589NthTreePreTrav {
    /**
     * 递归解法
     */
    public List<Integer> preorder1(Node root) {
        List<Integer> result = new ArrayList<>();
        dfs(root, result);
        return result;
    }

    void dfs(Node node, List<Integer> result) {
        if (node == null) {
            return;
        }

        result.add(node.val);
        for (Node child : node.children) {
            dfs(child, result);
        }
    }

    /**
     * 迭代解法
     */
    public List<Integer> preorder(Node root) {
        LinkedList<Integer> result = new LinkedList<>();
        if (root == null) {
            return result;
        }

        Stack<Node> stack = new Stack<>();
        Stack<Node> reverse = new Stack<>();
        stack.push(root);

        while (!stack.empty()) {
            Node node = stack.pop();
            result.add(node.val);

            if (node.children == null) {
                continue;
            }

            // 将children反序添加到堆栈中
            for (Node child : node.children) {
                reverse.push(child);
            }
            while (!reverse.empty()) {
                stack.push(reverse.pop());
            }
        }
        return result;
    }
}
