package com.alang.learn.week3;

import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Stack;

/***
 *根据一棵树的前序遍历与中序遍历构造二叉树。
 *
 * 注意:
 * 你可以假设树中没有重复的元素。
 *
 * 例如，给出
 *
 * 前序遍历 preorder = [3,9,20,15,7]
 * 中序遍历 inorder = [9,3,15,20,7]
 * 返回如下的二叉树：
 *
 *     3
 *    / \
 *   9  20
 *     /  \
 *    15   7
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/construct-binary-tree-from-preorder-and-inorder-traversal
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class LeetCode_105_0034 {
    public static void main(String[] args) {
        Solution solution = new Solution();
        int[] preOrder = new int[]{3, 9, 20, 15, 7};
        int[] inOrder = new int[]{9, 3, 15, 20, 7};
        LeetCode_144_0034.TreeNode treeNode = solution.buildTree(preOrder, inOrder);
        LeetCode_144_0034.Solution leetCode_144_0034 = new LeetCode_144_0034.Solution();
        System.out.println(leetCode_144_0034.preorderTraversal(treeNode));
    }

    static class Solution {
        HashMap<Integer, Integer> memo;
        int[] preorder, inorder;

        public LeetCode_144_0034.TreeNode buildTree(int[] preorder, int[] inorder) {
            if (preorder.length == 0) return null;
            if (preorder.length == 1) return new LeetCode_144_0034.TreeNode(preorder[0]);
            this.preorder = preorder;
            this.inorder = inorder;
            this.memo = new HashMap<>();
            for (int i = 0; i < inorder.length; i++) {
                memo.put(inorder[i], i);
            }
            return preinTotree(0, preorder.length - 1, 0, inorder.length - 1);
        }

        public LeetCode_144_0034.TreeNode preinTotree(int pStart, int pEnd, int inStart, int inEnd) {
            if (pStart > pEnd || inStart > inEnd) return null;
            LeetCode_144_0034.TreeNode root = new LeetCode_144_0034.TreeNode(0);
            int i = memo.get(preorder[pStart]);

            root.val = inorder[i];
            root.left = preinTotree(pStart + 1, pStart + i - inStart, inStart, i - 1);
            root.right = preinTotree(pStart + i - inStart + 1, pEnd, i + 1, inEnd);
            return root;
        }
    }
}
