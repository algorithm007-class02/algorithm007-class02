package com.heiko;

import java.util.ArrayList;
import java.util.List;

//给定一个二叉树，返回它的中序 遍历。

public class LeetCode_94_0100 {

    public List<Integer> inorderTraversal(TreeNode root) {
        TreeNode current = root;
        ArrayList<Integer> resultGathering = new ArrayList<>();
        // 递归方式
        GatherNodeInfo(root, resultGathering);
        return resultGathering;
    }

    // 递归函数
    public void GatherNodeInfo(TreeNode currentNode, ArrayList<Integer> resultGathering) {
        if (currentNode.left != null) {
            GatherNodeInfo(currentNode.left, resultGathering);
        }
        resultGathering.add(currentNode.val);
        if (currentNode.right != null) {
            GatherNodeInfo(currentNode.right, resultGathering);
        }
    }

    private class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { val = x; }
    }

}
