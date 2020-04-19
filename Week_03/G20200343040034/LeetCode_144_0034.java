package com.alang.learn.week3;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/***
 *给定一个二叉树，返回它的 前序 遍历。
 *
 *  示例:
 *
 * 输入: [1,null,2,3]
 *    1
 *     \
 *      2
 *     /
 *    3
 *
 * 输出: [1,2,3]
 * 进阶: 递归算法很简单，你可以通过迭代算法完成吗？
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/binary-tree-preorder-traversal
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class LeetCode_144_0034 {
    public static void main(String[] args) {
        Solution solution = new Solution();
        TreeNode treeNode = new TreeNode(1);
        treeNode.right = new TreeNode(2);
        treeNode.right.left = new TreeNode(3);
        System.out.println(solution.preorderTraversal(treeNode));
        System.out.println(solution.preorderTraversal1(treeNode));
    }

    static public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }

    static class Solution {
        public List<Integer> preorderTraversal(TreeNode root) {
            ArrayList<Integer> res = new ArrayList<>();
            if (root == null) return res;
            Stack<TreeNode> stack = new Stack<>();
            stack.add(root);
            while (!stack.isEmpty()) {
                TreeNode current = stack.pop();
                res.add(current.val);
                if (current.right != null) stack.push(current.right);
                if(current.left != null) stack.push(current.left);
            }
            return res;
        }

        public List<Integer> preorderTraversal1(TreeNode root) {
            ArrayList<Integer> res = new ArrayList<>();
            if (root == null) return res;
            helper(root, res);
            return res;
        }

        private void helper(TreeNode root, List<Integer> res) {
            res.add(root.val);
            if (root.left != null) helper(root.left, res);
            if (root.right != null) helper(root.right, res);
        }
    }
}
