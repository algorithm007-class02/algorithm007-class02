package week03.g20200343040172;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * https://leetcode-cn.com/problems/binary-tree-preorder-traversal/
 * 本周作业
 * LeetCode-144 Binary tree preorder traversal 二叉树的前序遍历
 */
public class LeetCode_144_0172 {

    /**
     * 方法一：递归的写法
     *
     * @param root
     * @return
     */
    public List<Integer> preorderTraversal_1(TreeNode root) {
        List<Integer> list = new ArrayList<>();
        helper(root, list);
        return list;
    }

    private void helper(TreeNode root, List<Integer> list) {
        if (root == null) {
            return;
        }
        list.add(root.val);
        helper(root.left, list);
        helper(root.right, list);
    }

    /**
     * 方法二：迭代的解法
     *
     * @param root
     * @return
     */
    public List<Integer> preorderTraversal_2(TreeNode root) {
        LinkedList<TreeNode> stack = new LinkedList<>();
        LinkedList<Integer> output = new LinkedList<>();
        if (root == null) {
            return output;
        }

        stack.add(root);
        while (!stack.isEmpty()) {
            TreeNode node = stack.pollLast();
            output.add(node.val);
            if (node.right != null) {
                stack.add(node.right);
            }
            if (node.left != null) {
                stack.add(node.left);
            }
        }
        return output;
    }
}
