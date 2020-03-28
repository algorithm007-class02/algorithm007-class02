package com.leetcode.tree;

import java.util.*;

public class L144BinaryTreePreOrder {
    List<Integer> result = new ArrayList<>();

    public List<Integer> preorderTraversal1(TreeNode root) {
        dfs(root);
        return result;
    }

    void dfs(TreeNode node) {
        if (node == null) {
            return;
        }

        result.add(node.val);
        dfs(node.left);
        dfs(node.right);
    }

    public List<Integer> preorderTraversal(TreeNode root) {
        List<Integer> result = new ArrayList<>();
        if (root == null) {
            return result;
        }

        Stack<TreeNode> stack = new Stack<>();

        stack.push(root);
        while (!stack.empty()) {
            TreeNode node = stack.pop();
            result.add(node.val);
            if (node.right != null) {
                stack.push(node.right);
            }
            if (node.left != null) {
                stack.push(node.left);
            }
        }
        return result;
    }
}
