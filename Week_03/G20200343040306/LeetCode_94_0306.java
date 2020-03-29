import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

import javax.swing.tree.TreeNode;

/*
 * @lc app=leetcode.cn id=94 lang=java
 *
 * [94] 二叉树的中序遍历
 *
 * https://leetcode-cn.com/problems/binary-tree-inorder-traversal/description/
 *
 * algorithms
 * Medium (70.50%)
 * Likes:    435
 * Dislikes: 0
 * Total Accepted:    126.2K
 * Total Submissions: 178.6K
 * Testcase Example:  '[1,null,2,3]'
 *
 * 给定一个二叉树，返回它的中序 遍历。
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
 * 输出: [1,3,2]
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
    List<Integer> list = new ArrayList<>();

    // 使用迭代
    public List<Integer> inorderTraversal(TreeNode root) {
        Stack<TreeNode> stack = new Stack<>();
        TreeNode p = root;
        while (p != null || !stack.empty()) {
            while (p != null) {
                stack.push(p);
                p = p.left;
            }
            p = stack.pop();
            list.add(p.val);
            p = p.right;
        }
        return list;
    }

    // public List<Integer> inorderTraversal(TreeNode root) {
    //     List<Integer> list = new ArrayList<>();
    //     Stack<TreeNode> stack = new Stack<>();
    //     TreeNode current = root;
    //     while (current != null || !stack.empty()) {
    //         if (current != null) {
    //             stack.push(current);
    //             current = current.left;
    //         } else {
    //             current = stack.pop();
    //             list.add(current.val);
    //             current = current.right;
    //         }
    //     }
    //     return list;
    // }
    
    // 使用递归
    // public List<Integer> inorderTraversal(TreeNode root) {
    //     if (root == null) return list;
    //     else {
    //         inorderTraversal(root.left);
    //         list.add(root.val);
    //         inorderTraversal(root.right);
    //     }
    //     return list;
    // }
}
// @lc code=end

