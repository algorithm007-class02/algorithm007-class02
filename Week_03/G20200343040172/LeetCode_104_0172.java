package week03.g20200343040172;

/**
 * https://leetcode-cn.com/problems/maximum-depth-of-binary-tree/
 * 实战题目
 * LeetCode-104 Maximum depth of binary tree
 */
public class LeetCode_104_0172 {

    /**
     * 方法一：使用递归
     * @param root
     * @return
     */
    public int maxDepth(TreeNode root) {
        if (root == null) {
            return 0;
        }
        int left = maxDepth(root.left);
        int right = maxDepth(root.right);
        return Math.max(left + 1, right + 1);
    }
}

class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;

    TreeNode(int x) {
        val = x;
    }
}
