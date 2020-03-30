package level2;

import tools.TreeNode;

import java.util.*;

public class Solution98 {
    public static void main(String[] args) {

    }

    // BST 二叉搜索树的中序遍历是递增的
    // 中序遍历 左 中 右
    public boolean isValidBST(TreeNode root) {
        Stack<TreeNode> nodes = new Stack<>();
        // List<Integer> list = new ArrayList<>();
        double inorder = -Double.MAX_VALUE;
        TreeNode current = root;
        while (current != null || !nodes.isEmpty()) {
            while (current != null) {
                nodes.push(current);
                current = current.left;
            }
            //
            current = nodes.pop();
            if (current.val <= inorder)
                return false;
            inorder = current.val;
            current = current.right;
        }
        return false;
    }

    // 递归法
    public boolean isValidBST2(TreeNode root) {
        return loop(root, null, null);
    }

    public static boolean loop(TreeNode node, Integer lower, Integer higher) {
        if (node != null) {
            int val = node.val;
            if (lower != null && lower >= val)
                return false;
            if (higher != null && higher <= val)
                return false;
            TreeNode left = node.left;
            TreeNode right = node.right;
            // 左节点 最大是当前的节点 val
            // 右节点 最小是当前的节点 val
            return loop(left, lower, val) && loop(right, val, higher);
        }
        return true;
    }

}
