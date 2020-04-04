package com.leetcode.tree;


import java.util.HashMap;
import java.util.HashSet;
import java.util.Set;
import java.util.Stack;

public class L236CommAncestor {

    /**
     * 递归方法
     */
    public TreeNode lowestCommonAncestor(TreeNode node, TreeNode p, TreeNode q) {
        if (node == null || p == node || q == node) {
            return node;
        }

        TreeNode left = lowestCommonAncestor(node.left, p, q);
        TreeNode right = lowestCommonAncestor(node.right, p, q);
        if (left == null) {
            return right;
        }
        if (right == null) {
            return left;
        }

        return node;
    }

    /**
     * 迭代方法
     */
    HashMap<TreeNode, TreeNode> parentMap = new HashMap<>();
    public TreeNode lowestCommonAncestor1(TreeNode root, TreeNode p, TreeNode q) {
        if (root == null || p == null || q == null) {
            return null;
        }

        dfs(root, p, q);

        Set<TreeNode> plist = new HashSet<>();
        do {
            plist.add(p);
            p = parentMap.getOrDefault(p, null);
        } while (p != null);

        do {
            if (plist.contains(q)) {
                return q;
            }
            q = parentMap.getOrDefault(q, null);
        } while (q != null);

        return null;
    }

    void dfs(TreeNode root, TreeNode p, TreeNode q) {
        if (root == null) {
            return;
        }

        parentMap.put(root, null);
        Stack<TreeNode> stack = new Stack<>();
        stack.push(root);

        while (!stack.empty() &&
                !(parentMap.containsKey(p) && parentMap.containsKey(q))) {
            TreeNode node = stack.pop();
            if (node.right != null) {
                stack.push(node.right);
                parentMap.put(node.right, node);
            }
            if (node.left != null) {
                stack.push(node.left);
                parentMap.put(node.left, node);
            }
        }
    }

    /* 递归的dfs
    void dfs(TreeNode node) {
        if (node == null) {
            return;
        }
        if (node.left != null) {
            parentMap.put(node.left, node);
            dfs(node.left);
        }
        if (node.right != null) {
            parentMap.put(node.right, node);
            dfs(node.right);
        }
    }

     */

}
