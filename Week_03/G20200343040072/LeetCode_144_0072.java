import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/*
 * @lc app=leetcode.cn id=144 lang=java
 *
 * [144] 二叉树的前序遍历
 *
 * https://leetcode-cn.com/problems/binary-tree-preorder-traversal/description/
 *
 * algorithms
 * Medium (64.23%)
 * Likes:    228
 * Dislikes: 0
 * Total Accepted:    83.4K
 * Total Submissions: 128.7K
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
    //1.递归法
    // public List<Integer> preorderTraversal(TreeNode root) {
    //     List<Integer> list =new ArrayList<>();
    //     preorder(list , root);
    //     return list;

    // }

    // private void preorder(List<Integer> list, TreeNode root) {
    //     if (root == null) {
    //         return;
    //     }
    //     list.add(root.val);
    //     preorder(list, root.left);
    //     preorder(list, root.right);
    // }

    //迭代法
    public List<Integer> preorderTraversal(TreeNode root) {
        List<Integer> list =new ArrayList<>();
        Stack<TreeNode> stack = new Stack<>();

        while (stack.size()>0 || root != null) {
            while(root != null){
                list.add(root.val);
                stack.add(root);
                root = root.left;
            }
            TreeNode temp =stack.pop();
            root = temp.right;

        }
        return list;
        
    }
}
// @lc code=end

