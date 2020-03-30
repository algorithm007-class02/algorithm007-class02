import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

import javax.swing.tree.TreeNode;

/*
 * @lc app=leetcode.cn id=144 lang=java
 *
 * [144] 二叉树的前序遍历
 *
 * https://leetcode-cn.com/problems/binary-tree-preorder-traversal/description/
 *
 * algorithms
 * Medium (64.74%)
 * Likes:    228
 * Dislikes: 0
 * Total Accepted:    82.4K
 * Total Submissions: 127.2K
 * Testcase Example:  '[1,null,2,3]'
 *
 * 给定一个二叉树，返回它的 前序 遍历。
 * 
 * 示例:
 * 
 * 输入: [1,null,2,3]  
 * ⁠  1
 * ⁠   \
 * ⁠    2
 * ⁠   /
 * ⁠  3 
 * 
 * 输出: [1,2,3]
 * 
 * 
 * 进阶: 递归算法很简单，你可以通过迭代算法完成吗？
 * 
 */

// @lc code=start
/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
class Solution {
    // 递归法
    // List<Integer> list = new ArrayList<>();
    // public List<Integer> preorderTraversal(TreeNode root) {
    //     if (root == null) return list;
    //     list.add(root.val);
    //     preorderTraversal(root.left);
    //     preorderTraversal(root.right);
    //     return list;
    // }

    public List<Integer> preorderTraversal(TreeNode root) {
        List<Integer> list = new ArrayList<>();
        Stack<TreeNode> stack = new Stack<>();
        while (root != null || !stack.empty()) {
            while (root != null) {
                list.add(root.val);
                stack.push(root);
                root = root.left;
            }
            root = stack.pop();
            root = root.right;
        }
        return list;
    }

    // public List<Integer> preorderTraversal(TreeNode root) {
    //     List<Integer> list = new ArrayList<>();
    //     Stack<TreeNode> stack = new Stack<>();
    //     TreeNode current = root;
    //     while (current != null || !stack.empty()) {
    //         if (current != null) {
    //             list.add(current.val);
    //             stack.push(current);
    //             current = current.left;
    //         } else {
    //             current = stack.pop();
    //             current = current.right;
    //         }
    //     }
    //     return list;
    // }
}
// @lc code=end

