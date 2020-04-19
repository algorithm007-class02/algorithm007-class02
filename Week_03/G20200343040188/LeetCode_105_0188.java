package com.leetcode.tree;

import java.util.HashMap;
import java.util.Map;

/**
 * 105. 从前序与中序遍历序列构造二叉树
 * 根据一棵树的前序遍历与中序遍历构造二叉树。
 *
 * 注意:
 * 你可以假设树中没有重复的元素。
 *
 * 前序遍历 preorder = [3,9,20,15,7]
 * 中序遍历 inorder = [9,3,15,20,7]
 * 返回如下的二叉树：
 *
 *     3
 *    / \
 *   9  20
 *     /  \
 *    15   7
 */
public class L105BuildTreeFromPreAndInOrder {
    Map<Integer, Integer> inMap = new HashMap<>();

    public TreeNode buildTree(int[] preorder, int[] inorder) {
        if (preorder == null || inorder == null ||
            preorder.length == 0 || inorder.length == 0) {
            return null;
        }

        for (int i = 0; i < inorder.length; i++) {
            inMap.put(inorder[i], i);
        }

        return buildTreeRecursion(preorder, 0, preorder.length,
                inorder, 0, inorder.length);
    }

    TreeNode buildTreeRecursion(int[] preorder, int pBegin, int pEnd,
                                int[] inorder, int iBegin, int iEnd) {

        if (iBegin > iEnd - 1) {
            return null;
        }

        TreeNode root = new TreeNode(preorder[pBegin]);
        int pos = inMap.get(preorder[pBegin]);

        // fixme: 将leftNum显式写出来
        int leftNum = pos - iBegin;
        root.left = buildTreeRecursion(preorder, pBegin + 1, pBegin + leftNum + 1,
                inorder, iBegin, pos);
        root.right = buildTreeRecursion(preorder, pBegin + leftNum + 1, pEnd,
                inorder, pos + 1, iEnd);
        return root;
    }
}
